package com.ruoyi.project.system.firmmaterialqueryanddemands.controller;

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
import com.ruoyi.project.system.firmmaterialqueryanddemands.domain.Firmmaterialqueryanddemands;
import com.ruoyi.project.system.firmmaterialqueryanddemands.service.IFirmmaterialqueryanddemandsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 需求数据Controller
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Controller
@RequestMapping("/system/firmmaterialqueryanddemands")
public class FirmmaterialqueryanddemandsController extends BaseController
{
    private String prefix = "system/firmmaterialqueryanddemands";

    @Autowired
    private IFirmmaterialqueryanddemandsService firmmaterialqueryanddemandsService;

    @RequiresPermissions("system:firmmaterialqueryanddemands:view")
    @GetMapping()
    public String firmmaterialqueryanddemands()
    {
        return prefix + "/firmmaterialqueryanddemands";
    }

    /**
     * 查询需求数据列表
     */
    @RequiresPermissions("system:firmmaterialqueryanddemands:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        startPage();
        List<Firmmaterialqueryanddemands> list = firmmaterialqueryanddemandsService.selectFirmmaterialqueryanddemandsList(firmmaterialqueryanddemands);
        return getDataTable(list);
    }

    /**
     * 导出需求数据列表
     */
    @RequiresPermissions("system:firmmaterialqueryanddemands:export")
    @Log(title = "需求数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        List<Firmmaterialqueryanddemands> list = firmmaterialqueryanddemandsService.selectFirmmaterialqueryanddemandsList(firmmaterialqueryanddemands);
        ExcelUtil<Firmmaterialqueryanddemands> util = new ExcelUtil<Firmmaterialqueryanddemands>(Firmmaterialqueryanddemands.class);
        return util.exportExcel(list, "firmmaterialqueryanddemands");
    }

    /**
     * 新增需求数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存需求数据
     */
    @RequiresPermissions("system:firmmaterialqueryanddemands:add")
    @Log(title = "需求数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        return toAjax(firmmaterialqueryanddemandsService.insertFirmmaterialqueryanddemands(firmmaterialqueryanddemands));
    }

    /**
     * 修改需求数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmmaterialqueryanddemands firmmaterialqueryanddemands = firmmaterialqueryanddemandsService.selectFirmmaterialqueryanddemandsById(id);
        mmap.put("firmmaterialqueryanddemands", firmmaterialqueryanddemands);
        return prefix + "/edit";
    }

    /**
     * 修改保存需求数据
     */
    @RequiresPermissions("system:firmmaterialqueryanddemands:edit")
    @Log(title = "需求数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        return toAjax(firmmaterialqueryanddemandsService.updateFirmmaterialqueryanddemands(firmmaterialqueryanddemands));
    }

    /**
     * 删除需求数据
     */
    @RequiresPermissions("system:firmmaterialqueryanddemands:remove")
    @Log(title = "需求数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmmaterialqueryanddemandsService.deleteFirmmaterialqueryanddemandsByIds(ids));
    }
}
