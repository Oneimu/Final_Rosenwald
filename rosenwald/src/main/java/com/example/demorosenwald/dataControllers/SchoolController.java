package com.example.demorosenwald.dataControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchoolController {

    @RequestMapping("/school")
    public String school(){
        return "school";
    }

}
