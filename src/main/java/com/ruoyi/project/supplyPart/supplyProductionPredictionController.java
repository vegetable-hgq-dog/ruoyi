package com.ruoyi.project.supplyPart;


import com.ruoyi.project.system.factoryInf.service.impl.FactoryTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplyProductionPrediction")
public class supplyProductionPredictionController {

    @Autowired
    private FactoryTableServiceImpl factoryTableService;

    @GetMapping()
    public String supplyProductionPredictionUrl(ModelMap mmp){
        mmp.put("allFactoryInfo",factoryTableService.selectFactoryInfo());
        return "supplyPart/supplyProductionPredictionHTML";
    }

}
