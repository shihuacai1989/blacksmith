package com.sauzny.blacksmith.services;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sauzny.finagle.thrift.blacksmith.*;
import com.sauzny.finagle.thrift.common.CommonResult;

@Service
public class ServiceHandle implements BlackSmithServer.Iface{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHandle.class);

    @Override
    public QueryResult query(QueryParams QueryParams) throws TException {
        // TODO Auto-generated method stub
        return new QueryResult();
    }

    @Override
    public CommonResult ping() throws TException {
        // TODO Auto-generated method stub
        
        LOGGER.info("ServiceHandle.ping()");
        
        return new CommonResult();
    }
    
  

}
