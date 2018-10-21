package com.ini.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ini.rest.service.ConsumerRmoteService;

@RestController
public class ConsumerRemoteController {
	
	@Autowired
	ConsumerRmoteService consumerRmoteService;
	
    @RequestMapping(value="/ribbon-consumer-remote",method=RequestMethod.GET)
    public String helloConsumer() {
        return consumerRmoteService.service();
      
    }
}
