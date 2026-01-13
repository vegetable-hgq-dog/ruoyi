package com.ruoyi.project.system.dataInfo.controller;

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
import com.ruoyi.project.system.dataInfo.domain.WeldingCurrentData;
import com.ruoyi.project.system.dataInfo.service.IWeldingCurrentDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 焊接实时数据Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Controller
@RequestMapping("/system/dataInfo")
public class WeldingCurrentDataController extends BaseController
{
    private String prefix = "system/dataInfo";

    @Autowired
    private IWeldingCurrentDataService weldingCurrentDataService;

    @RequiresPermissions("system:dataInfo:view")
    @GetMapping()
    public String dataInfo()
    {
        return prefix + "/dataInfo";
    }

    /**
     * 查询焊接实时数据列表
     */
    @RequiresPermissions("system:dataInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WeldingCurrentData weldingCurrentData)
    {
        startPage();
        List<WeldingCurrentData> list = weldingCurrentDataService.selectWeldingCurrentDataList(weldingCurrentData);
        return getDataTable(list);
    }

    /**
     * 导出焊接实时数据列表
     */
    @RequiresPermissions("system:dataInfo:export")
    @Log(title = "焊接实时数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WeldingCurrentData weldingCurrentData)
    {
        List<WeldingCurrentData> list = weldingCurrentDataService.selectWeldingCurrentDataList(weldingCurrentData);
        ExcelUtil<WeldingCurrentData> util = new ExcelUtil<WeldingCurrentData>(WeldingCurrentData.class);
        return util.exportExcel(list, "dataInfo");
    }

    /**
     * 新增焊接实时数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存焊接实时数据
     */
    @RequiresPermissions("system:dataInfo:add")
    @Log(title = "焊接实时数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WeldingCurrentData weldingCurrentData)
    {
        return toAjax(weldingCurrentDataService.insertWeldingCurrentData(weldingCurrentData));
    }

    /**
     * 修改焊接实时数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WeldingCurrentData weldingCurrentData = weldingCurrentDataService.selectWeldingCurrentDataById(id);
        mmap.put("weldingCurrentData", weldingCurrentData);
        return prefix + "/edit";
    }

    /**
     * 修改保存焊接实时数据
     */
    @RequiresPermissions("system:dataInfo:edit")
    @Log(title = "焊接实时数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WeldingCurrentData weldingCurrentData)
    {
        return toAjax(weldingCurrentDataService.updateWeldingCurrentData(weldingCurrentData));
    }

    /**
     * 删除焊接实时数据
     */
    @RequiresPermissions("system:dataInfo:remove")
    @Log(title = "焊接实时数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(weldingCurrentDataService.deleteWeldingCurrentDataByIds(ids));
    }


    @RequestMapping("/getAllCurrentData")
    @ResponseBody
    public List getAllCurrentData(){
        return weldingCurrentDataService.getAllCurrentData();
    }

    @RequestMapping("/getWeldingQualityNum")
    @ResponseBody
    public List getWeldingQualityNum(){
        return weldingCurrentDataService.getWeldingQualityNum();
    }


    @RequestMapping("/getHistoryQuality")
    @ResponseBody
    public List getHistoryQuality(){
        return weldingCurrentDataService.getHistoryQuality();
    }
}
