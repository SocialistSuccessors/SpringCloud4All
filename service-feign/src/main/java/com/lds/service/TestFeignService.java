package com.lds.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by n0049901 on 2018/9/21.
 */
@FeignClient(value = "client",fallback = TestFeignServiceHystric.class)//client为服务名
public interface TestFeignService {
    @RequestMapping(value = "/home/{name}",method = RequestMethod.GET)//调用服务的接口
    String sayHiFromClientOne(@PathVariable(value = "name") String name);
}
