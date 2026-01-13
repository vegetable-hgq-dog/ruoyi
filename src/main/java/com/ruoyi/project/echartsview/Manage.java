package com.ruoyi.project.echartsview;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echartsview")
public class Manage {


    @GetMapping()
    public String ord(){

        return "/echartsview/ord";
    }
}
