package com.ruoyi.project.system.mrknowledge.controller;

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
import com.ruoyi.project.system.mrknowledge.domain.DsMrknowledge;
import com.ruoyi.project.system.mrknowledge.service.IDsMrknowledgeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 制造需求Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/mrknowledge")
public class DsMrknowledgeController extends BaseController
{
    private String prefix = "system/mrknowledge";

    @Autowired
    private IDsMrknowledgeService dsMrknowledgeService;

    @RequiresPermissions("system:mrknowledge:view")
    @GetMapping()
    public String mrknowledge()
    {
        return prefix + "/mrknowledge";
    }

    /**
     * 查询制造需求列表
     */
    @RequiresPermissions("system:mrknowledge:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsMrknowledge dsMrknowledge)
    {
        startPage();
        List<DsMrknowledge> list = dsMrknowledgeService.selectDsMrknowledgeList(dsMrknowledge);
        return getDataTable(list);
    }

    /**
     * 导出制造需求列表
     */
    @RequiresPermissions("system:mrknowledge:export")
    @Log(title = "制造需求", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsMrknowledge dsMrknowledge)
    {
        List<DsMrknowledge> list = dsMrknowledgeService.selectDsMrknowledgeList(dsMrknowledge);
        ExcelUtil<DsMrknowledge> util = new ExcelUtil<DsMrknowledge>(DsMrknowledge.class);
        return util.exportExcel(list, "mrknowledge");
    }

    /**
     * 新增制造需求
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存制造需求
     */
    @RequiresPermissions("system:mrknowledge:add")
    @Log(title = "制造需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsMrknowledge dsMrknowledge)
    {
        return toAjax(dsMrknowledgeService.insertDsMrknowledge(dsMrknowledge));
    }

    /**
     * 修改制造需求
     */
    @GetMapping("/edit/{mritemid}")
    public String edit(@PathVariable("mritemid") Long mritemid, ModelMap mmap)
    {
        DsMrknowledge dsMrknowledge = dsMrknowledgeService.selectDsMrknowledgeById(mritemid);
        mmap.put("dsMrknowledge", dsMrknowledge);
        return prefix + "/edit";
    }

    /**
     * 修改保存制造需求
     */
    @RequiresPermissions("system:mrknowledge:edit")
    @Log(title = "制造需求", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsMrknowledge dsMrknowledge)
    {
        return toAjax(dsMrknowledgeService.updateDsMrknowledge(dsMrknowledge));
    }

    /**
     * 删除制造需求
     */
    @RequiresPermissions("system:mrknowledge:remove")
    @Log(title = "制造需求", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsMrknowledgeService.deleteDsMrknowledgeByIds(ids));
    }
}
