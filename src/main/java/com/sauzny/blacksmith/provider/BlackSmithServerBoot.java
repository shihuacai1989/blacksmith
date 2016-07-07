package com.sauzny.blacksmith.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sauzny.blacksmith.utils.JVMUtils;

public class BlackSmithServerBoot {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackSmithServerBoot.class);

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        
        String pid = JVMUtils.populateProcessID();
        
        LOGGER.debug("pid : " + pid);
        
        new ClassPathXmlApplicationContext("/spring/boot.xml");
        
    }
    
    private static void status(){
        
    }
    
    private static void stop() {
        
        Thread shutdownThread = new Thread() {
            public void run() {
                System.out.println("shutdownThread...");
            }
        };

        Runtime.getRuntime().addShutdownHook(shutdownThread);
    }
}
