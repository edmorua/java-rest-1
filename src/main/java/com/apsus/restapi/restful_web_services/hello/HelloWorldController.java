package com.apsus.restapi.restful_web_services.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping()
    public String hello(){
        return "Hello World";
    }


    @GetMapping(path="/bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path="/bean/{name}")
    public HelloWorldBean helloBean(@PathVariable String name){
        return new HelloWorldBean("Hello World " + name);
    }
}
