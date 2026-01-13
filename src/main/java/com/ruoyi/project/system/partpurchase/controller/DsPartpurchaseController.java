package com.ruoyi.project.system.partpurchase.controller;

import java.util.List;

import com.ruoyi.project.system.aftersalecenter.service.IDsAftersalecenterService;
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
import com.ruoyi.project.system.partpurchase.domain.DsPartpurchase;
import com.ruoyi.project.system.partpurchase.service.IDsPartpurchaseService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * partpurchaseController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/partpurchase")
public class DsPartpurchaseController extends BaseController
{
    private String prefix = "system/partpurchase";

    @Autowired
    private IDsPartpurchaseService dsPartpurchaseService;

    @Autowired
    private IDsAftersalecenterService dsAftersalecenterService;

    @RequiresPermissions("system:partpurchase:view")
    @GetMapping()
    public String partpurchase()
    {
        return prefix + "/partpurchase";
    }

    /**
     * 查询partpurchase列表
     */
    @RequiresPermissions("system:partpurchase:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsPartpurchase dsPartpurchase)
    {
        startPage();
        List<DsPartpurchase> list = dsPartpurchaseService.selectDsPartpurchaseList(dsPartpurchase);
        return getDataTable(list);
    }

    /**
     * 导出partpurchase列表
     */
    @RequiresPermissions("system:partpurchase:export")
    @Log(title = "partpurchase", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsPartpurchase dsPartpurchase)
    {
        List<DsPartpurchase> list = dsPartpurchaseService.selectDsPartpurchaseList(dsPartpurchase);
        ExcelUtil<DsPartpurchase> util = new ExcelUtil<DsPartpurchase>(DsPartpurchase.class);
        return util.exportExcel(list, "partpurchase");
    }

    /**
     * 新增partpurchase
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("centerIDInfo",dsAftersalecenterService.selectCenterID());
        return prefix + "/add";
    }

    /**
     * 新增保存partpurchase
     */
    @RequiresPermissions("system:partpurchase:add")
    @Log(title = "partpurchase", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsPartpurchase dsPartpurchase)
    {
        return toAjax(dsPartpurchaseService.insertDsPartpurchase(dsPartpurchase));
    }

    /**
     * 修改partpurchase
     */
    @GetMapping("/edit/{purchaseid}")
    public String edit(@PathVariable("purchaseid") Integer purchaseid, ModelMap mmap)
    {
        DsPartpurchase dsPartpurchase = dsPartpurchaseService.selectDsPartpurchaseById(purchaseid);
        mmap.put("dsPartpurchase", dsPartpurchase);
        mmap.put("centerIDInfo",dsAftersalecenterService.selectCenterID());
        return prefix + "/edit";
    }

    /**
     * 修改保存partpurchase
     */
    @RequiresPermissions("system:partpurchase:edit")
    @Log(title = "partpurchase", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsPartpurchase dsPartpurchase)
    {
        return toAjax(dsPartpurchaseService.updateDsPartpurchase(dsPartpurchase));
    }

    /**
     * 删除partpurchase
     */
    @RequiresPermissions("system:partpurchase:remove")
    @Log(title = "partpurchase", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsPartpurchaseService.deleteDsPartpurchaseByIds(ids));
    }
}
