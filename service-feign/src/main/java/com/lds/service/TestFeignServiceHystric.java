package com.lds.service;

import org.springframework.stereotype.Component;

/**
 * Created by n0049901 on 2018/9/25.
 */
@Component//需要加入spring容器 并实现需要断路的接口
public class TestFeignServiceHystric implements TestFeignService{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,"+name;
    }
}
