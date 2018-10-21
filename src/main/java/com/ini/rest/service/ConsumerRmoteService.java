package com.ini.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerRmoteService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public String service(){
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
	
	public String fallback(){
		return "服务不可用";
	}
	
}
