package com.netty.tinyRpc;

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
public class ClientTestService {
	@Autowired
	private ObjectProxy objectProxy;
	
	@Test
    public void helloTest() {
	
    	HelloService helloService = objectProxy.create(HelloService.class);
    	
    	String res = helloService.sayHello("caicai");
    	
    	System.out.println(res);
   
	}
	
	@Test
	public void personTest(){
		
		PersonService personService = objectProxy.create(PersonService.class);
		
		String res = personService.getPerson();
		
		System.out.println(res);
		
	}
}
