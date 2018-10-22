package com.ini.rest.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ini.rest.fallback.FeignFallBack;

@FeignClient(name="client1113",fallback=FeignFallBack.class)
public interface ConsumerFeignService {

	@RequestMapping(value="/feign-service/serviceGet",method=RequestMethod.GET)
	public String helloservice(@RequestParam("name") String name);
}
