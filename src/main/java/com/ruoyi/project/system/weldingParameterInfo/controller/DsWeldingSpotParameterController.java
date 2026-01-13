package com.ruoyi.project.system.weldingParameterInfo.controller;

import java.util.List;

import com.ruoyi.project.system.devicesInfo.service.IDsDevicesService;
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
import com.ruoyi.project.system.weldingParameterInfo.domain.DsWeldingSpotParameter;
import com.ruoyi.project.system.weldingParameterInfo.service.IDsWeldingSpotParameterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 焊点参数Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Controller
@RequestMapping("/system/weldingParameterInfo")
public class DsWeldingSpotParameterController extends BaseController
{
    private String prefix = "system/weldingParameterInfo";

    @Autowired
    private IDsWeldingSpotParameterService dsWeldingSpotParameterService;

    @Autowired
    private IDsDevicesService dsDevicesService;

    @RequiresPermissions("system:weldingParameterInfo:view")
    @GetMapping()
    public String weldingParameterInfo()
    {
        return prefix + "/weldingParameterInfo";
    }

    /**
     * 查询焊点参数列表
     */
    @RequiresPermissions("system:weldingParameterInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        startPage();
        List<DsWeldingSpotParameter> list = dsWeldingSpotParameterService.selectDsWeldingSpotParameterList(dsWeldingSpotParameter);
        return getDataTable(list);
    }

    /**
     * 导出焊点参数列表
     */
    @RequiresPermissions("system:weldingParameterInfo:export")
    @Log(title = "焊点参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        List<DsWeldingSpotParameter> list = dsWeldingSpotParameterService.selectDsWeldingSpotParameterList(dsWeldingSpotParameter);
        ExcelUtil<DsWeldingSpotParameter> util = new ExcelUtil<DsWeldingSpotParameter>(DsWeldingSpotParameter.class);
        return util.exportExcel(list, "weldingParameterInfo");
    }

    /**
     * 新增焊点参数
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("deviceInfo",dsDevicesService.selectDeviceID());
        return prefix + "/add";
    }

    /**
     * 新增保存焊点参数
     */
    @RequiresPermissions("system:weldingParameterInfo:add")
    @Log(title = "焊点参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        return toAjax(dsWeldingSpotParameterService.insertDsWeldingSpotParameter(dsWeldingSpotParameter));
    }

    /**
     * 修改焊点参数
     */
    @GetMapping("/edit/{dsweldingid}")
    public String edit(@PathVariable("dsweldingid") Long dsweldingid, ModelMap mmap)
    {
        DsWeldingSpotParameter dsWeldingSpotParameter = dsWeldingSpotParameterService.selectDsWeldingSpotParameterById(dsweldingid);
        mmap.put("dsWeldingSpotParameter", dsWeldingSpotParameter);
        mmap.put("deviceInfo",dsDevicesService.selectDeviceID());
        return prefix + "/edit";
    }

    /**
     * 修改保存焊点参数
     */
    @RequiresPermissions("system:weldingParameterInfo:edit")
    @Log(title = "焊点参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        return toAjax(dsWeldingSpotParameterService.updateDsWeldingSpotParameter(dsWeldingSpotParameter));
    }

    /**
     * 删除焊点参数
     */
    @RequiresPermissions("system:weldingParameterInfo:remove")
    @Log(title = "焊点参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsWeldingSpotParameterService.deleteDsWeldingSpotParameterByIds(ids));
    }


    @RequestMapping("/getAllWeldingSpotPara")
    @ResponseBody
    public List getWeldingPara(){
        return dsWeldingSpotParameterService.getAllWeldingSpotPara();
    }
}
