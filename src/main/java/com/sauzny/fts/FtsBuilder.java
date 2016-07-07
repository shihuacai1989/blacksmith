package com.sauzny.fts;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.proxy.Invoker;
import org.apache.commons.proxy.ProxyFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twitter.finagle.Service;
import com.twitter.finagle.builder.ServerBuilder;
import com.twitter.finagle.builder.ServerConfig.Yes;
import com.twitter.finagle.thrift.ThriftServerFramedCodec;
import com.twitter.util.Duration;


/**
 * *************************************************************************
 * @文件名称: FtsBuilder.java
 *
 * @包路径  : com.sauzny.fts
 *
 * @版权所有: Personal (C) 2015~2016
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年7月6日 - 下午4:35:56
 *
 **************************************************************************
 */
@Component
public class FtsBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FtsBuilder.class);
    
    @Autowired
    private FtsConfig ftsConfig;
    
    @Autowired
    private FtsFutureHandle ftsFutureHandle;
    
    public FtsBuilder(){
        
        LOGGER.debug("BlackSmithServerBuilder 构造器");
    }
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void start(){
        
        LOGGER.debug("ftsConfig toString() " + ftsConfig.toString());
        
        ServerBuilder<byte[], byte[], Yes, Yes, Yes> serverBuilder = ServerBuilder.get()
                .codec(ThriftServerFramedCodec.get())
                .requestTimeout(new Duration(ftsConfig.getRequestTimeout() * Duration.NanosPerMillisecond()))
                .keepAlive(ftsConfig.getKeepAlive())
                .bindTo(new InetSocketAddress(ftsConfig.getPort()))
                .name(ftsConfig.getName())
                ;
        
        ServerBuilder.safeBuild(
                serviceGenerator(ftsConfig.getServerClassName()),
                serverBuilder);
    }
    
    /**
     * 	方法描述:   service 生成器，利用server的全路径，反射生成一个service的实例
     *
     *  @author  ljx 创建时间 2016年7月2日 下午5:57:27
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Service serviceGenerator(String serverClassName) {
        
        Service result = null;
        
        try {
            // forName 时候 使用连接符号 是 $
            //com.sauzny.finagle.thrift.blacksmith.BlackSmithServer$Service
            Class<Service> serviceClass = (Class<Service>) Class.forName(serverClassName+"$Service");
           
            result = ConstructorUtils.invokeConstructor(serviceClass, serviceIfaceGenerator(serverClassName), new TBinaryProtocol.Factory());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 


        return result;
    }
    
    /**
     * 	方法描述:
     *
     *  @author  ljx 创建时间 2016年7月2日 下午6:08:42
     * @throws ClassNotFoundException 
     */
    public Object serviceIfaceGenerator(String serverClassName) throws ClassNotFoundException {
        
        Class<?> serviceClass = Class.forName(serverClassName+"$ServiceIface");
        
        ProxyFactory factory = new ProxyFactory();
        
        Object result = factory.createInvokerProxy(new ServiceIfaceInvoker(), new Class[] { serviceClass });
        
        return result;
    }
    
    /**
     * 
     */
    private class ServiceIfaceInvoker implements Invoker {

        @Override
        public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
            
           return ftsFutureHandle.apply(arg1.getName(), arg2);
        }
        
    }
    
}
