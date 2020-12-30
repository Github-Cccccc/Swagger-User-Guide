package com.staticzz.controller;


import com.staticzz.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api("用户控制器")
public class Controller {


    @ApiOperation("执行hello请求传参为name")
    @GetMapping("/hello/{name}")
    public  String hello(@ApiParam("name") @PathVariable("name") String name){
        return name;
    }


    @ApiOperation("执行user")
    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }



}
