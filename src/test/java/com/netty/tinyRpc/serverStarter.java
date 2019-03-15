package com.netty.tinyRpc;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class serverStarter {

    public static void main(String[] args) {
    	
    	
        new ClassPathXmlApplicationContext("spring-context-server.xml");	
        
    }
}
