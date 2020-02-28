package com.jilinwula.springboot.helloworld.controller;

import com.jilinwula.springboot.helloworld.DataSource;
import com.jilinwula.springboot.helloworld.DataSourceType;
import com.jilinwula.springboot.helloworld.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/list")
    public Object list() {
        return userInfoRepository.findAll();
    }

    @DataSource(value = DataSourceType.SLAVE)
    @GetMapping("/list2")
    public Object list2() {
        return userInfoRepository.findAll();
    }
}
