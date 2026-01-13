package com.ruoyi.project.scheduleModule;

import com.ruoyi.project.system.firminfo.service.impl.FirminfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderReallocate")
public class orderReallocate {

    @GetMapping()
    public String orderReallocateUrl(){
        return "scheduleModule/orderReallocate";
    }

}
