package com.sauzny.blacksmith.test;

import org.apache.thrift.protocol.TBinaryProtocol;

import com.sauzny.finagle.thrift.blacksmith.BlackSmithServer;
import com.sauzny.finagle.thrift.common.CommonResult;
import com.twitter.finagle.Service;
import com.twitter.finagle.builder.ClientBuilder;
import com.twitter.finagle.builder.ClientConfig.Yes;
import com.twitter.finagle.thrift.ThriftClientFramedCodec;
import com.twitter.finagle.thrift.ThriftClientRequest;
import com.twitter.util.Await;
import com.twitter.util.Duration;

public class APITest {

    public static void main(String[] args) {
        
        final String ip_port = "127.0.0.1:50002";
        
        // TODO Auto-generated method stub
        ClientBuilder<ThriftClientRequest, byte[], Yes, Yes, Yes> clientBuilder = ClientBuilder.get()
                .hosts(ip_port) 
                .codec(ThriftClientFramedCodec.get())
                .keepAlive(true)
                .hostConnectionLimit(1)
                .hostConnectionCoresize(1)
                .hostConnectionIdleTime( new Duration(300L * Duration.NanosPerSecond()))
                .hostConnectionMaxIdleTime( new Duration(300L * Duration.NanosPerSecond()))
                //.hostConnectionMaxLifeTime( new Duration(30L * Duration.NanosPerSecond()))
                .tcpConnectTimeout(new Duration(2L * Duration.NanosPerSecond()));

        System.out.println(System.currentTimeMillis());
        Service<ThriftClientRequest, byte[]> serviceClient = ClientBuilder.safeBuild(clientBuilder);
        System.out.println(System.currentTimeMillis());
        
        serviceClient.isAvailable();
        
        
        BlackSmithServer.ServiceIface service = new BlackSmithServer.ServiceToClient(serviceClient, new TBinaryProtocol.Factory());
        
        
        try {
            
            CommonResult commonResult = Await.result(service.ping(), new Duration(Duration.NanosPerMinute()));
            
            System.out.println(commonResult);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
