package com.ruoyi.project.system.material.controller;

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
import com.ruoyi.project.system.material.domain.DsMaterial;
import com.ruoyi.project.system.material.service.IDsMaterialService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 材料信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/material")
public class DsMaterialController extends BaseController
{
    private String prefix = "system/material";

    @Autowired
    private IDsMaterialService dsMaterialService;

    @RequiresPermissions("system:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询材料信息列表
     */
    @RequiresPermissions("system:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsMaterial dsMaterial)
    {
        startPage();
        List<DsMaterial> list = dsMaterialService.selectDsMaterialList(dsMaterial);
        return getDataTable(list);
    }

    /**
     * 导出材料信息列表
     */
    @RequiresPermissions("system:material:export")
    @Log(title = "材料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsMaterial dsMaterial)
    {
        List<DsMaterial> list = dsMaterialService.selectDsMaterialList(dsMaterial);
        ExcelUtil<DsMaterial> util = new ExcelUtil<DsMaterial>(DsMaterial.class);
        return util.exportExcel(list, "material");
    }

    /**
     * 新增材料信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料信息
     */
    @RequiresPermissions("system:material:add")
    @Log(title = "材料信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsMaterial dsMaterial)
    {
        return toAjax(dsMaterialService.insertDsMaterial(dsMaterial));
    }

    /**
     * 修改材料信息
     */
    @GetMapping("/edit/{materialid}")
    public String edit(@PathVariable("materialid") Long materialid, ModelMap mmap)
    {
        DsMaterial dsMaterial = dsMaterialService.selectDsMaterialById(materialid);
        mmap.put("dsMaterial", dsMaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料信息
     */
    @RequiresPermissions("system:material:edit")
    @Log(title = "材料信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsMaterial dsMaterial)
    {
        return toAjax(dsMaterialService.updateDsMaterial(dsMaterial));
    }

    /**
     * 删除材料信息
     */
    @RequiresPermissions("system:material:remove")
    @Log(title = "材料信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsMaterialService.deleteDsMaterialByIds(ids));
    }
}
