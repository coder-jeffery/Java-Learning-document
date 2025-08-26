package com.easycoding.admin.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApprovalController {

    @GetMapping("/index")
    public String index(){
        return "Hello World";
    }
}
