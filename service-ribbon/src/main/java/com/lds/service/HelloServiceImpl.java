package com.lds.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by n0049901 on 2018/9/21.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")//断路器相关注解
    public String hiService(String name) {
        return restTemplate.getForObject("http://client/home/"+name,String.class);
    }
    public String hiError(String name){
        return "hi," + name + ",sorry,error";

    }
}
