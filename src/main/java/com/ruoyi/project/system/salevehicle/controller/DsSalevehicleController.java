package com.ruoyi.project.system.salevehicle.controller;

import java.util.List;
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
import com.ruoyi.project.system.salevehicle.domain.DsSalevehicle;
import com.ruoyi.project.system.salevehicle.service.IDsSalevehicleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * salevehicleController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/salevehicle")
public class DsSalevehicleController extends BaseController
{
    private String prefix = "system/salevehicle";

    @Autowired
    private IDsSalevehicleService dsSalevehicleService;

    @RequiresPermissions("system:salevehicle:view")
    @GetMapping()
    public String salevehicle()
    {
        return prefix + "/salevehicle";
    }

    /**
     * 查询salevehicle列表
     */
    @RequiresPermissions("system:salevehicle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsSalevehicle dsSalevehicle)
    {
        startPage();
        List<DsSalevehicle> list = dsSalevehicleService.selectDsSalevehicleList(dsSalevehicle);
        return getDataTable(list);
    }

    /**
     * 导出salevehicle列表
     */
    @RequiresPermissions("system:salevehicle:export")
    @Log(title = "salevehicle", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsSalevehicle dsSalevehicle)
    {
        List<DsSalevehicle> list = dsSalevehicleService.selectDsSalevehicleList(dsSalevehicle);
        ExcelUtil<DsSalevehicle> util = new ExcelUtil<DsSalevehicle>(DsSalevehicle.class);
        return util.exportExcel(list, "salevehicle");
    }

    /**
     * 新增salevehicle
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存salevehicle
     */
    @RequiresPermissions("system:salevehicle:add")
    @Log(title = "salevehicle", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsSalevehicle dsSalevehicle)
    {
        return toAjax(dsSalevehicleService.insertDsSalevehicle(dsSalevehicle));
    }

    /**
     * 修改salevehicle
     */
    @GetMapping("/edit/{vehicleid}")
    public String edit(@PathVariable("vehicleid") Long vehicleid, ModelMap mmap)
    {
        DsSalevehicle dsSalevehicle = dsSalevehicleService.selectDsSalevehicleById(vehicleid);
        mmap.put("dsSalevehicle", dsSalevehicle);
        return prefix + "/edit";
    }

    /**
     * 修改保存salevehicle
     */
    @RequiresPermissions("system:salevehicle:edit")
    @Log(title = "salevehicle", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsSalevehicle dsSalevehicle)
    {
        return toAjax(dsSalevehicleService.updateDsSalevehicle(dsSalevehicle));
    }

    /**
     * 删除salevehicle
     */
    @RequiresPermissions("system:salevehicle:remove")
    @Log(title = "salevehicle", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsSalevehicleService.deleteDsSalevehicleByIds(ids));
    }
}
