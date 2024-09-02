package com.phase.zk.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping(path = "/test")
    public String getDynamicZkVersion(){
        return "zk_version";
    }
}
