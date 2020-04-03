package com.base.controller;

import com.base.anno.AuthCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @AuthCheck
    @RequestMapping("/base")
    public String base() {
        System.out.println("enter base....");
        return "base controller...";
    }

}
