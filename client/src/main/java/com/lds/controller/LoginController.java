package com.lds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by n0049901 on 2018/9/26.
 */
@RequestMapping("/basic")
@RestController
public class LoginController extends BaseController{

    @RequestMapping("/index")
    public String login(){
        return "this is index!";
    }
}
