package com.ruoyi.project.system.sales.controller;

import java.util.List;

import com.ruoyi.project.system.customer.service.IDsCustomerService;
import com.ruoyi.project.system.salevehicle.service.IDsSalevehicleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.sales.domain.DsSales;
import com.ruoyi.project.system.sales.service.IDsSalesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * salesController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/sales")
public class DsSalesController extends BaseController
{
    private String prefix = "system/sales";

    @Autowired
    private IDsSalesService dsSalesService;

    @Autowired
    private IDsSalevehicleService iDsSalevehicleService;

    @Autowired
    private IDsCustomerService iDsCustomerService;

    @RequiresPermissions("system:sales:view")
    @GetMapping()
    public String sales()
    {
        return prefix + "/sales";
    }

    /**
     * 查询sales列表
     */
    @RequiresPermissions("system:sales:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsSales dsSales)
    {
        startPage();
        List<DsSales> list = dsSalesService.selectDsSalesList(dsSales);
        return getDataTable(list);
    }

    /**
     * 导出sales列表
     */
    @RequiresPermissions("system:sales:export")
    @Log(title = "sales", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsSales dsSales)
    {
        List<DsSales> list = dsSalesService.selectDsSalesList(dsSales);
        ExcelUtil<DsSales> util = new ExcelUtil<DsSales>(DsSales.class);
        return util.exportExcel(list, "sales");
    }

    /**
     * 新增sales
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("vehicleIdInfo",iDsSalevehicleService.selectVehicleId());
        mmap.put("customerIdInfo",iDsCustomerService.selectCustomerId());
        return prefix + "/add";
    }

    /**
     * 新增保存sales
     */
    @RequiresPermissions("system:sales:add")
    @Log(title = "sales", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsSales dsSales)
    {
        return toAjax(dsSalesService.insertDsSales(dsSales));
    }

    /**
     * 修改sales
     */
    @GetMapping("/edit/{salesid}")
    public String edit(@PathVariable("salesid") Long salesid, ModelMap mmap)
    {
        DsSales dsSales = dsSalesService.selectDsSalesById(salesid);
        mmap.put("dsSales", dsSales);
        mmap.put("vehicleIdInfo",iDsSalevehicleService.selectVehicleId());
        mmap.put("customerIdInfo",iDsCustomerService.selectCustomerId());
        return prefix + "/edit";
    }

    /**
     * 修改保存sales
     */
    @RequiresPermissions("system:sales:edit")
    @Log(title = "sales", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsSales dsSales)
    {
        return toAjax(dsSalesService.updateDsSales(dsSales));
    }

    /**
     * 删除sales
     */
    @RequiresPermissions("system:sales:remove")
    @Log(title = "sales", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsSalesService.deleteDsSalesByIds(ids));
    }
}
