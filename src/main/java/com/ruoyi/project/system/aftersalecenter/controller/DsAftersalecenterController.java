package com.ruoyi.project.system.aftersalecenter.controller;

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
import com.ruoyi.project.system.aftersalecenter.domain.DsAftersalecenter;
import com.ruoyi.project.system.aftersalecenter.service.IDsAftersalecenterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * aftersalecenterController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/aftersalecenter")
public class DsAftersalecenterController extends BaseController
{
    private String prefix = "system/aftersalecenter";

    @Autowired
    private IDsAftersalecenterService dsAftersalecenterService;

    @RequiresPermissions("system:aftersalecenter:view")
    @GetMapping()
    public String aftersalecenter()
    {
        return prefix + "/aftersalecenter";
    }

    /**
     * 查询aftersalecenter列表
     */
    @RequiresPermissions("system:aftersalecenter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsAftersalecenter dsAftersalecenter)
    {
        startPage();
        List<DsAftersalecenter> list = dsAftersalecenterService.selectDsAftersalecenterList(dsAftersalecenter);
        return getDataTable(list);
    }

    /**
     * 导出aftersalecenter列表
     */
    @RequiresPermissions("system:aftersalecenter:export")
    @Log(title = "aftersalecenter", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsAftersalecenter dsAftersalecenter)
    {
        List<DsAftersalecenter> list = dsAftersalecenterService.selectDsAftersalecenterList(dsAftersalecenter);
        ExcelUtil<DsAftersalecenter> util = new ExcelUtil<DsAftersalecenter>(DsAftersalecenter.class);
        return util.exportExcel(list, "aftersalecenter");
    }

    /**
     * 新增aftersalecenter
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存aftersalecenter
     */
    @RequiresPermissions("system:aftersalecenter:add")
    @Log(title = "aftersalecenter", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsAftersalecenter dsAftersalecenter)
    {
        return toAjax(dsAftersalecenterService.insertDsAftersalecenter(dsAftersalecenter));
    }

    /**
     * 修改aftersalecenter
     */
    @GetMapping("/edit/{centerid}")
    public String edit(@PathVariable("centerid") Long centerid, ModelMap mmap)
    {
        DsAftersalecenter dsAftersalecenter = dsAftersalecenterService.selectDsAftersalecenterById(centerid);
        mmap.put("dsAftersalecenter", dsAftersalecenter);
        return prefix + "/edit";
    }

    /**
     * 修改保存aftersalecenter
     */
    @RequiresPermissions("system:aftersalecenter:edit")
    @Log(title = "aftersalecenter", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsAftersalecenter dsAftersalecenter)
    {
        return toAjax(dsAftersalecenterService.updateDsAftersalecenter(dsAftersalecenter));
    }

    /**
     * 删除aftersalecenter
     */
    @RequiresPermissions("system:aftersalecenter:remove")
    @Log(title = "aftersalecenter", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsAftersalecenterService.deleteDsAftersalecenterByIds(ids));
    }
}
