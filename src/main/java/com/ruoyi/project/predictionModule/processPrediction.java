package com.ruoyi.project.predictionModule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/processPrediction")
public class processPrediction {
    @GetMapping()
    public String finalAssembleDataUrl(){
        return "predictionModule/processPrediction";
    }
}
