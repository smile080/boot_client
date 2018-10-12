package com.ini.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
 
	private final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private DiscoveryClient client;
 
    @RequestMapping(value = "/hello" ,method=RequestMethod.GET)
    public String  saveArticle() {
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
    	return "Hello world";
    	
    }
    
    
    
}