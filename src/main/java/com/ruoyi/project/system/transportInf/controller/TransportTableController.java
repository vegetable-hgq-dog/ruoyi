package com.ruoyi.project.system.transportInf.controller;

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
import com.ruoyi.project.system.transportInf.domain.TransportTable;
import com.ruoyi.project.system.transportInf.service.ITransportTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 运输信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Controller
@RequestMapping("/system/transportInf")
public class TransportTableController extends BaseController
{
    private String prefix = "system/transportInf";

    @Autowired
    private ITransportTableService transportTableService;

    @RequiresPermissions("system:transportInf:view")
    @GetMapping()
    public String transportInf()
    {
        return prefix + "/transportInf";
    }

    /**
     * 查询运输信息列表
     */
    @RequiresPermissions("system:transportInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TransportTable transportTable)
    {
        startPage();
        List<TransportTable> list = transportTableService.selectTransportTableList(transportTable);
        return getDataTable(list);
    }

    /**
     * 导出运输信息列表
     */
    @RequiresPermissions("system:transportInf:export")
    @Log(title = "运输信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TransportTable transportTable)
    {
        List<TransportTable> list = transportTableService.selectTransportTableList(transportTable);
        ExcelUtil<TransportTable> util = new ExcelUtil<TransportTable>(TransportTable.class);
        return util.exportExcel(list, "transportInf");
    }

    /**
     * 新增运输信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存运输信息
     */
    @RequiresPermissions("system:transportInf:add")
    @Log(title = "运输信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TransportTable transportTable)
    {
        return toAjax(transportTableService.insertTransportTable(transportTable));
    }

    /**
     * 修改运输信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TransportTable transportTable = transportTableService.selectTransportTableById(id);
        mmap.put("transportTable", transportTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存运输信息
     */
    @RequiresPermissions("system:transportInf:edit")
    @Log(title = "运输信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TransportTable transportTable)
    {
        return toAjax(transportTableService.updateTransportTable(transportTable));
    }

    /**
     * 删除运输信息
     */
    @RequiresPermissions("system:transportInf:remove")
    @Log(title = "运输信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(transportTableService.deleteTransportTableByIds(ids));
    }


    @RequestMapping("/getTransportState")
    @ResponseBody
    public List getTransportState(){
        return transportTableService.getAllTransportData();
    }
}
