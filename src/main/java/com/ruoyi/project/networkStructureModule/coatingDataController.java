package com.ruoyi.project.networkStructureModule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coatingData")
public class coatingDataController {

    @GetMapping()
    public String coatingDataUrl(){
        return "blankPart/coatingDataHTML";
    }
}
