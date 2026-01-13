package com.ruoyi.project.designerPart;

import com.ruoyi.project.system.mkiinfo.service.impl.MkiinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perceptionRecommend")
public class PerceptionRecommendController {

    @Autowired
    private MkiinfoServiceImpl mkiinfoService;

    @GetMapping()
    public String perceptionRecommendUrl(ModelMap mmp){
        mmp.put("mki",mkiinfoService.selectMkiinfo());
        return "designerPart/perceptionRecommendHTML";
    }
}
