package com.ruoyi.project.networkStructureModule;


import com.ruoyi.project.system.firminfo.service.impl.FirminfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/firmNetwork")
public class FirmNetworkController {

    @Autowired
    private FirminfoServiceImpl firminfoService;

    @GetMapping()
    public String firminfoUrl(ModelMap mmp){
        mmp.put("firmInfos",firminfoService.selectFirmInfos());
        return "networkStructureModule/firmNetwork";
    }
}
