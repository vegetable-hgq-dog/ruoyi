package com.ruoyi.project.system.parameter.controller;

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
import com.ruoyi.project.system.parameter.domain.DsParameter;
import com.ruoyi.project.system.parameter.service.IDsParameterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 参数信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/parameter")
public class DsParameterController extends BaseController
{
    private String prefix = "system/parameter";

    @Autowired
    private IDsParameterService dsParameterService;

    @RequiresPermissions("system:parameter:view")
    @GetMapping()
    public String parameter()
    {
        return prefix + "/parameter";
    }

    /**
     * 查询参数信息列表
     */
    @RequiresPermissions("system:parameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsParameter dsParameter)
    {
        startPage();
        List<DsParameter> list = dsParameterService.selectDsParameterList(dsParameter);
        return getDataTable(list);
    }

    /**
     * 导出参数信息列表
     */
    @RequiresPermissions("system:parameter:export")
    @Log(title = "参数信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsParameter dsParameter)
    {
        List<DsParameter> list = dsParameterService.selectDsParameterList(dsParameter);
        ExcelUtil<DsParameter> util = new ExcelUtil<DsParameter>(DsParameter.class);
        return util.exportExcel(list, "parameter");
    }

    /**
     * 新增参数信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存参数信息
     */
    @RequiresPermissions("system:parameter:add")
    @Log(title = "参数信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsParameter dsParameter)
    {
        return toAjax(dsParameterService.insertDsParameter(dsParameter));
    }

    /**
     * 修改参数信息
     */
    @GetMapping("/edit/{parameterid}")
    public String edit(@PathVariable("parameterid") Long parameterid, ModelMap mmap)
    {
        DsParameter dsParameter = dsParameterService.selectDsParameterById(parameterid);
        mmap.put("dsParameter", dsParameter);
        return prefix + "/edit";
    }

    /**
     * 修改保存参数信息
     */
    @RequiresPermissions("system:parameter:edit")
    @Log(title = "参数信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsParameter dsParameter)
    {
        return toAjax(dsParameterService.updateDsParameter(dsParameter));
    }

    /**
     * 删除参数信息
     */
    @RequiresPermissions("system:parameter:remove")
    @Log(title = "参数信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsParameterService.deleteDsParameterByIds(ids));
    }
}
