package com.ruoyi.project.system.supplyInf.controller;

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
import com.ruoyi.project.system.supplyInf.domain.SupplyTable;
import com.ruoyi.project.system.supplyInf.service.ISupplyTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 供应信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Controller
@RequestMapping("/system/supplyInf")
public class SupplyTableController extends BaseController
{
    private String prefix = "system/supplyInf";

    @Autowired
    private ISupplyTableService supplyTableService;

    @RequiresPermissions("system:supplyInf:view")
    @GetMapping()
    public String supplyInf()
    {
        return prefix + "/supplyInf";
    }

    /**
     * 查询供应信息列表
     */
    @RequiresPermissions("system:supplyInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SupplyTable supplyTable)
    {
        startPage();
        List<SupplyTable> list = supplyTableService.selectSupplyTableList(supplyTable);
        return getDataTable(list);
    }

    /**
     * 导出供应信息列表
     */
    @RequiresPermissions("system:supplyInf:export")
    @Log(title = "供应信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SupplyTable supplyTable)
    {
        List<SupplyTable> list = supplyTableService.selectSupplyTableList(supplyTable);
        ExcelUtil<SupplyTable> util = new ExcelUtil<SupplyTable>(SupplyTable.class);
        return util.exportExcel(list, "supplyInf");
    }

    /**
     * 新增供应信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应信息
     */
    @RequiresPermissions("system:supplyInf:add")
    @Log(title = "供应信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SupplyTable supplyTable)
    {
        return toAjax(supplyTableService.insertSupplyTable(supplyTable));
    }

    /**
     * 修改供应信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SupplyTable supplyTable = supplyTableService.selectSupplyTableById(id);
        mmap.put("supplyTable", supplyTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应信息
     */
    @RequiresPermissions("system:supplyInf:edit")
    @Log(title = "供应信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SupplyTable supplyTable)
    {
        return toAjax(supplyTableService.updateSupplyTable(supplyTable));
    }

    /**
     * 删除供应信息
     */
    @RequiresPermissions("system:supplyInf:remove")
    @Log(title = "供应信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(supplyTableService.deleteSupplyTableByIds(ids));
    }

    @RequestMapping("/getReceiptState")
    @ResponseBody
    public List getReceiptState(){
        return supplyTableService.getAllSupplyData();
    }
}
