package com.sauzny.fts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import lombok.Data;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twitter.util.ExecutorServiceFuturePool;
import com.twitter.util.Function0;
import com.twitter.util.Future;
import com.twitter.util.FutureEventListener;

/**
 * *************************************************************************
 * @文件名称: FtsFutureHandle.java
 *
 * @包路径  : com.sauzny.fts
 *
 * @版权所有: Personal (C) 2015~2016
 *
 * @类描述:
 *
 * @创建人:   ljx
 *
 * @创建时间: 2016年7月6日 - 下午4:40:41
 *
 **************************************************************************
 */
@Data
public class FtsFutureHandle {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FtsFutureHandle.class);

    //业务逻辑代码service
    private Object serviceHandle;
    
    //启动服务的工作线程数(默认值32)
    private Integer threads = 32;
    
    // 工作线程池
    private ExecutorServiceFuturePool futurePool = null;
    
    /**
     *  描述:   初始化工作线程池
     *  @param threadNum
     */
    @PostConstruct
    public void postConstruct(){
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        futurePool = new ExecutorServiceFuturePool(executorService);
    }
    
    /**
     * 	方法描述:   反射调用 实际的业务处理 service
     *
     *  @author  ljx 创建时间 2016年7月6日 下午6:26:47
     */
    public Future<Object> apply(final String methodName, final Object... params){
        //线程池 执行 实际的业务类方法
        Future<Object> future = futurePool.apply(new Function0<Object>(){

            @Override
            public Object apply() {
                
                Class<?>[] paramsClass = null;
                if(params != null && params.length > 0){
                    paramsClass = new Class[params.length];
                    for(int i = 0; i < params.length; i++){
                        //如果传递参数为null,会报null point异常,需要做判断
                        paramsClass[i] = params[i] == null ? null : params[i].getClass();
                    }
                }
                
                try {
                    
                    MethodUtils.invokeMethod(serviceHandle, methodName);
                    
                    return MethodUtils.invokeMethod(serviceHandle, methodName, params, paramsClass);
                    
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return null;
            }
            
        });
        
        // 对结果的校验
        if(future instanceof Future) {
            ((Future<Object>) future).addEventListener(
                    new FutureEventListener<Object>() {
                        @Override
                        public void onSuccess(Object res) {
                            LOGGER.debug("方法调用成功，" + methodName);
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            LOGGER.error("方法调用失败，" + methodName, throwable);
                        }
                    }
            );
        }else{
         // TODO 
        }
        
        return future;
    }
}
