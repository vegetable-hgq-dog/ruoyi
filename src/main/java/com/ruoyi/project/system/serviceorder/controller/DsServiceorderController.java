package com.ruoyi.project.system.serviceorder.controller;

import java.util.List;

import com.ruoyi.project.system.aftersalecenter.service.IDsAftersalecenterService;
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
import com.ruoyi.project.system.serviceorder.domain.DsServiceorder;
import com.ruoyi.project.system.serviceorder.service.IDsServiceorderService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * serviceorderController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/serviceorder")
public class DsServiceorderController extends BaseController
{
    private String prefix = "system/serviceorder";

    @Autowired
    private IDsServiceorderService dsServiceorderService;

    @Autowired
    private IDsAftersalecenterService dsAftersalecenterService;

    @Autowired
    private IDsSalevehicleService dsSalevehicleService;

    @RequiresPermissions("system:serviceorder:view")
    @GetMapping()
    public String serviceorder()
    {
        return prefix + "/serviceorder";
    }

    /**
     * 查询serviceorder列表
     */
    @RequiresPermissions("system:serviceorder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsServiceorder dsServiceorder)
    {
        startPage();
        List<DsServiceorder> list = dsServiceorderService.selectDsServiceorderList(dsServiceorder);
        return getDataTable(list);
    }

    /**
     * 导出serviceorder列表
     */
    @RequiresPermissions("system:serviceorder:export")
    @Log(title = "serviceorder", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsServiceorder dsServiceorder)
    {
        List<DsServiceorder> list = dsServiceorderService.selectDsServiceorderList(dsServiceorder);
        ExcelUtil<DsServiceorder> util = new ExcelUtil<DsServiceorder>(DsServiceorder.class);
        return util.exportExcel(list, "serviceorder");
    }

    /**
     * 新增serviceorder
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("centerIdInfo",dsAftersalecenterService.selectCenterID());
        mmap.put("vehicleIdInfo",dsSalevehicleService.selectVehicleId());
        return prefix + "/add";
    }

    /**
     * 新增保存serviceorder
     */
    @RequiresPermissions("system:serviceorder:add")
    @Log(title = "serviceorder", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsServiceorder dsServiceorder)
    {
        return toAjax(dsServiceorderService.insertDsServiceorder(dsServiceorder));
    }

    /**
     * 修改serviceorder
     */
    @GetMapping("/edit/{serviceorderid}")
    public String edit(@PathVariable("serviceorderid") Long serviceorderid, ModelMap mmap)
    {
        DsServiceorder dsServiceorder = dsServiceorderService.selectDsServiceorderById(serviceorderid);
        mmap.put("dsServiceorder", dsServiceorder);
        mmap.put("centerIdInfo",dsAftersalecenterService.selectCenterID());
        mmap.put("vehicleIdInfo",dsSalevehicleService.selectVehicleId());
        return prefix + "/edit";
    }

    /**
     * 修改保存serviceorder
     */
    @RequiresPermissions("system:serviceorder:edit")
    @Log(title = "serviceorder", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsServiceorder dsServiceorder)
    {
        return toAjax(dsServiceorderService.updateDsServiceorder(dsServiceorder));
    }

    /**
     * 删除serviceorder
     */
    @RequiresPermissions("system:serviceorder:remove")
    @Log(title = "serviceorder", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsServiceorderService.deleteDsServiceorderByIds(ids));
    }
}
