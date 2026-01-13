package com.ruoyi.project.designerPart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/embedLearn")
public class EmbedLearnController {

    @GetMapping()
    public String embedLearnUrl(){
        return "designerPart/embedLearnHTML";
    }
}
