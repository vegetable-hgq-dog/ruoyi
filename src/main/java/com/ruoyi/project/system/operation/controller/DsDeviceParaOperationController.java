package com.ruoyi.project.system.operation.controller;

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
import com.ruoyi.project.system.operation.domain.DsDeviceParaOperation;
import com.ruoyi.project.system.operation.service.IDsDeviceParaOperationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 实时状态Controller
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Controller
@RequestMapping("/system/operation")
public class DsDeviceParaOperationController extends BaseController
{
    private String prefix = "system/operation";

    @Autowired
    private IDsDeviceParaOperationService dsDeviceParaOperationService;

    @RequiresPermissions("system:operation:view")
    @GetMapping()
    public String operation()
    {
        return prefix + "/operation";
    }

    /**
     * 查询实时状态列表
     */
    @RequiresPermissions("system:operation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsDeviceParaOperation dsDeviceParaOperation)
    {
        startPage();
        List<DsDeviceParaOperation> list = dsDeviceParaOperationService.selectDsDeviceParaOperationList(dsDeviceParaOperation);
        return getDataTable(list);
    }

    /**
     * 导出实时状态列表
     */
    @RequiresPermissions("system:operation:export")
    @Log(title = "实时状态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsDeviceParaOperation dsDeviceParaOperation)
    {
        List<DsDeviceParaOperation> list = dsDeviceParaOperationService.selectDsDeviceParaOperationList(dsDeviceParaOperation);
        ExcelUtil<DsDeviceParaOperation> util = new ExcelUtil<DsDeviceParaOperation>(DsDeviceParaOperation.class);
        return util.exportExcel(list, "operation");
    }

    /**
     * 新增实时状态
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存实时状态
     */
    @RequiresPermissions("system:operation:add")
    @Log(title = "实时状态", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsDeviceParaOperation dsDeviceParaOperation)
    {
        return toAjax(dsDeviceParaOperationService.insertDsDeviceParaOperation(dsDeviceParaOperation));
    }

    /**
     * 修改实时状态
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsDeviceParaOperation dsDeviceParaOperation = dsDeviceParaOperationService.selectDsDeviceParaOperationById(id);
        mmap.put("dsDeviceParaOperation", dsDeviceParaOperation);
        return prefix + "/edit";
    }

    /**
     * 修改保存实时状态
     */
    @RequiresPermissions("system:operation:edit")
    @Log(title = "实时状态", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsDeviceParaOperation dsDeviceParaOperation)
    {
        return toAjax(dsDeviceParaOperationService.updateDsDeviceParaOperation(dsDeviceParaOperation));
    }

    /**
     * 删除实时状态
     */
    @RequiresPermissions("system:operation:remove")
    @Log(title = "实时状态", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsDeviceParaOperationService.deleteDsDeviceParaOperationByIds(ids));
    }
}
