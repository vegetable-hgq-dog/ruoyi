package com.ruoyi.project.networkStructureModule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/finalAssembleData")
public class finalAssembleDataController {

    @GetMapping()
    public String finalAssembleDataUrl(){
        return "blankPart/finalAssembleDataHTML";
    }
}
