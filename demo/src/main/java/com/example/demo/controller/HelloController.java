package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** important without it, web will have no reaction*/
@RestController
@RequestMapping("/")
public class HelloController {
    protected static Logger logger= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    public String helloworld(){
        logger.debug("hello debug!");
        logger.info("info 级别的日志");
        return "Hello world!";
    }
    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        logger.debug("debug: hello,Name={}",name);
        return "Hello "+name;
    }
}
