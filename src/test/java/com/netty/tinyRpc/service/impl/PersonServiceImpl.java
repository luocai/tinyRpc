package com.netty.tinyRpc.service.impl;

import com.netty.tinyRpc.annotation.RpcService;
import com.netty.tinyRpc.service.PersonService;

@RpcService(PersonService.class)
public class PersonServiceImpl implements PersonService {


	public String getPerson() {
	
		return "我是诸葛财财哦";
	}

}
