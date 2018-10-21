package com.ini.rest.controller;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerRemoteController {
	@Autowired
    RestTemplate restTemplate;
    
	@HystrixCommand(fallbackMethod = "testConsumerError")
    @RequestMapping(value="/ribbon-consumer-remote",method=RequestMethod.GET)
    public String helloConsumer() {
    	String username="admin";
    	String password="123456";
    	String url="http://client1115:1115//helloServer3";
    	
    	restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
        return restTemplate.getForEntity(url, String.class).getBody();
        
       /* String auth_Str = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth_Str.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        HttpHeaders headers = new HttpHeaders();
        headers.set("authorization", authHeader);
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers),String.class).getBody();*/
    }
	
	//这个方法与helloConsumer方法参数和返回值应该是一样的
	public String testConsumerError(){
		return "服务不可用！";
	}

	
	
}
