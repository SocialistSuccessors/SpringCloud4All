package com.lds.controller;

import com.lds.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by n0049901 on 2018/9/21.
 */
@RestController
public class TestFeignController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    TestFeignService testFeignService;

    @GetMapping(value = "/hi/{name}")
    public String sayHi(@PathVariable("name") String name) {
        return testFeignService.sayHiFromClientOne( name );
    }
}
