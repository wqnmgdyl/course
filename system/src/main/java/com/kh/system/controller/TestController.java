package com.kh.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author han.ke
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
