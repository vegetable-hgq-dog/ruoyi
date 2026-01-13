package com.ruoyi.project.supplyPart;


import com.ruoyi.project.system.factoryInventoryInf.service.impl.FactoryInventoryTableServiceImpl;
import com.ruoyi.project.system.materialInf.service.impl.MaterialsTableServiceImpl;
import com.ruoyi.project.system.supplyInf.service.impl.SupplyTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplyDataVisual")
public class SupplyDataVisualController {


    @Autowired
    private FactoryInventoryTableServiceImpl factoryInventoryTableService;


    @Autowired
    private MaterialsTableServiceImpl materialsTableService;


    @Autowired
    private SupplyTableServiceImpl supplyTableService;


    @GetMapping()
    public String supplyDataVisualUrl(ModelMap mmap){

        mmap.put("factoryInventoryData",factoryInventoryTableService.getAllFactoryInventoryData());
        mmap.put("materialsData",materialsTableService.getAllMaterialData());
        mmap.put("supplyData",supplyTableService.getAllSupplyData());

        return "supplyPart/supplyDataVisualHTML";
    }
}
