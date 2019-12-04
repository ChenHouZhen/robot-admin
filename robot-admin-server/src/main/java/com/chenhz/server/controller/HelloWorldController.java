package com.chenhz.server.controller;

import com.chenhz.server.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @GetMapping("/say")
    public R say(){
        Map<String,Object> data = new HashMap<>();
        data.put("lan","hello world");
        return R.ok().put("data",data);
    }
}
