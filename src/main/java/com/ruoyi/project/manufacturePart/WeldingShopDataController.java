package com.ruoyi.project.manufacturePart;

import com.ruoyi.project.system.devicesInfo.service.IDsDevicesService;
import com.ruoyi.project.system.weldingParameterInfo.service.IDsWeldingSpotParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weldingShopData")
public class WeldingShopDataController {

    @Autowired
    private IDsWeldingSpotParameterService dsWeldingSpotParameterService;

    @Autowired
    private IDsDevicesService dsDevicesService;

    @GetMapping()
    public String weldingShopDataUrl(ModelMap modelMap){
        modelMap.put("weldingSpotPara",dsWeldingSpotParameterService.getAllWeldingSpotPara());
        modelMap.put("allDeviceInfo",dsDevicesService.getAllDeviceInfo());
        return "manufacturePart/weldingShopDataHTML";
    }
}
