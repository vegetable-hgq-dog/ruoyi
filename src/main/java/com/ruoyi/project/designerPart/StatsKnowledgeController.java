package com.ruoyi.project.designerPart;



import com.ruoyi.project.system.designermkiinfo.service.impl.DesignermkiinfoServiceImpl;
import com.ruoyi.project.system.mkiinfo.service.impl.MkiinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statsKnowledge")
public class StatsKnowledgeController {

    @Autowired
    private DesignermkiinfoServiceImpl designermkiinfoService;

    @Autowired
    private MkiinfoServiceImpl mkiinfoService;

    @GetMapping()
    public String StatsKnowledgeUrl(ModelMap knowledge){
        knowledge.put("designermki",designermkiinfoService.selectDesignermkiinfo());
        knowledge.put("mki",mkiinfoService.selectMkiinfo());
        knowledge.put("ktype",mkiinfoService.checkKTypeNum());
        knowledge.put("process",mkiinfoService.checkProcessNum());
        return "designerPart/statsKnowledgeHTML";
    }
}
