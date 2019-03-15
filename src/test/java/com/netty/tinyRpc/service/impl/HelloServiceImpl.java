package com.netty.tinyRpc.service.impl;

import com.netty.tinyRpc.annotation.RpcService;
import com.netty.tinyRpc.service.HelloService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService{

	public String sayHello(String str) {
		
		return "hello" + str;
	}

}
