package com.netty.tinyRpc;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netty.tinyRpc.client.proxy.ObjectProxy;
import com.netty.tinyRpc.service.HelloService;
import com.netty.tinyRpc.service.PersonService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-client.xml")
public class ClientTestEfficiency {
	
	@Autowired
	private ObjectProxy objectProxy;

    @Test
    public void helloTest() throws InterruptedException {
    	
    	long start = System.currentTimeMillis();
    	CountDownLatch latch = new CountDownLatch(500);
    	
    	for(int i = 0; i < 500; i++){
    		
    		new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					HelloService helloService = objectProxy.create(HelloService.class);
			    	
			    	String res = helloService.sayHello("caicai");
			    	
			    	System.out.println(res);
			    	latch.countDown();
				}
			}).start();
    		
    	}
    	
    	latch.await();
    	System.out.println("程序运行的时间是：" +( System.currentTimeMillis() - start));
    	
    }
    
    @Test
    public void testEfficiency() throws InterruptedException{
    	
    	int threadNum = 10;
        final int requestNum = 100;
        Thread[] threads = new Thread[threadNum];

        long startTime = System.currentTimeMillis();
        
        for(int i = 0; i < threadNum; i++){
        	threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j = 0; j<requestNum; j++){
						HelloService helloService = objectProxy.create(HelloService.class);
				    	String res = helloService.sayHello("caicai");
//				    	System.out.println(res);
					}
				}
			});
        	threads[i].start();
        }
        
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        long timeCost = (System.currentTimeMillis() - startTime);
        String msg = String.format("Sync call total-time-cost:%sms, req/s=%s", timeCost, ((double) (requestNum * threadNum)) / timeCost * 1000);
        System.out.println(msg);
    }
}
