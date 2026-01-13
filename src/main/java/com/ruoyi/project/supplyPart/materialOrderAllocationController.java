package com.ruoyi.project.supplyPart;


import com.ruoyi.project.system.factoryInf.service.impl.FactoryTableServiceImpl;
import com.ruoyi.project.system.materialInf.service.impl.MaterialsTableServiceImpl;
import com.ruoyi.project.system.orderInf.service.impl.OrderTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materialOrderAllocation")
public class materialOrderAllocationController {

    @Autowired
    private FactoryTableServiceImpl factoryTableService;

    @Autowired
    private OrderTableServiceImpl orderTableService;

    @Autowired
    private MaterialsTableServiceImpl materialsTableService;

    @GetMapping()
    public String materialOrderAllocationUrl(ModelMap mmp){
        mmp.put("factoryTableInfo",factoryTableService.selectFactoryInfo());
        mmp.put("orderTableInfo",orderTableService.getData());
        mmp.put("materialsTableInfo",materialsTableService.getAllMaterialData());
        return "supplyPart/materialOrderAllocationHTML";
    }
}
