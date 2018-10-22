package com.ini.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ini.rest.service.ConsumerFeignService;

@RestController
public class ConsumerRemoteFeignController {
	
	@Autowired
	ConsumerFeignService consumerFeignService;
	
    @RequestMapping(value="/hello-service",method=RequestMethod.GET)
    public String helloConsumer() {
    	StringBuffer sb = new StringBuffer();
		sb.append(consumerFeignService.helloservice("yuanyuan"));
		return sb.toString();
    }
}

