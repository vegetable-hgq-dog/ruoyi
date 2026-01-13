package com.ruoyi.project.system.firmalgorithmparameter.controller;

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
import com.ruoyi.project.system.firmalgorithmparameter.domain.Firmalgorithmparameter;
import com.ruoyi.project.system.firmalgorithmparameter.service.IFirmalgorithmparameterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 需求数据Controller
 * 
 * @author ruoyi
 * @date 2024-04-16
 */
@Controller
@RequestMapping("/system/firmalgorithmparameter")
public class FirmalgorithmparameterController extends BaseController
{
    private String prefix = "system/firmalgorithmparameter";

    @Autowired
    private IFirmalgorithmparameterService firmalgorithmparameterService;

    @RequiresPermissions("system:firmalgorithmparameter:view")
    @GetMapping()
    public String firmalgorithmparameter()
    {
        return prefix + "/firmalgorithmparameter";
    }

    /**
     * 查询需求数据列表
     */
    @RequiresPermissions("system:firmalgorithmparameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmalgorithmparameter firmalgorithmparameter)
    {
        startPage();
        List<Firmalgorithmparameter> list = firmalgorithmparameterService.selectFirmalgorithmparameterList(firmalgorithmparameter);
        return getDataTable(list);
    }

    /**
     * 导出需求数据列表
     */
    @RequiresPermissions("system:firmalgorithmparameter:export")
    @Log(title = "需求数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmalgorithmparameter firmalgorithmparameter)
    {
        List<Firmalgorithmparameter> list = firmalgorithmparameterService.selectFirmalgorithmparameterList(firmalgorithmparameter);
        ExcelUtil<Firmalgorithmparameter> util = new ExcelUtil<Firmalgorithmparameter>(Firmalgorithmparameter.class);
        return util.exportExcel(list, "firmalgorithmparameter");
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
    @RequiresPermissions("system:firmalgorithmparameter:add")
    @Log(title = "需求数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmalgorithmparameter firmalgorithmparameter)
    {
        return toAjax(firmalgorithmparameterService.insertFirmalgorithmparameter(firmalgorithmparameter));
    }

    /**
     * 修改需求数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmalgorithmparameter firmalgorithmparameter = firmalgorithmparameterService.selectFirmalgorithmparameterById(id);
        mmap.put("firmalgorithmparameter", firmalgorithmparameter);
        return prefix + "/edit";
    }

    /**
     * 修改保存需求数据
     */
    @RequiresPermissions("system:firmalgorithmparameter:edit")
    @Log(title = "需求数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmalgorithmparameter firmalgorithmparameter)
    {
        return toAjax(firmalgorithmparameterService.updateFirmalgorithmparameter(firmalgorithmparameter));
    }

    /**
     * 删除需求数据
     */
    @RequiresPermissions("system:firmalgorithmparameter:remove")
    @Log(title = "需求数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmalgorithmparameterService.deleteFirmalgorithmparameterByIds(ids));
    }
}
