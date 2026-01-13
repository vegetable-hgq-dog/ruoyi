package com.ruoyi.project.system.devicesInfo.controller;

import java.util.List;

import com.ruoyi.project.system.stationsInfo.service.IDsStationsService;
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
import com.ruoyi.project.system.devicesInfo.domain.DsDevices;
import com.ruoyi.project.system.devicesInfo.service.IDsDevicesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Controller
@RequestMapping("/system/devicesInfo")
public class DsDevicesController extends BaseController
{
    private String prefix = "system/devicesInfo";

    @Autowired
    private IDsDevicesService dsDevicesService;

    @Autowired
    private IDsStationsService dsStationsService;

    @RequiresPermissions("system:devicesInfo:view")
    @GetMapping()
    public String devicesInfo()
    {
        return prefix + "/devicesInfo";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("system:devicesInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsDevices dsDevices)
    {
        startPage();
        List<DsDevices> list = dsDevicesService.selectDsDevicesList(dsDevices);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("system:devicesInfo:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsDevices dsDevices)
    {
        List<DsDevices> list = dsDevicesService.selectDsDevicesList(dsDevices);
        ExcelUtil<DsDevices> util = new ExcelUtil<DsDevices>(DsDevices.class);
        return util.exportExcel(list, "devicesInfo");
    }

    /**
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("stationInfo",dsStationsService.selectStationID());
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("system:devicesInfo:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsDevices dsDevices)
    {
        return toAjax(dsDevicesService.insertDsDevices(dsDevices));
    }

    /**
     * 修改设备信息
     */
    @GetMapping("/edit/{deviceid}")
    public String edit(@PathVariable("deviceid") Long deviceid, ModelMap mmap)
    {
        DsDevices dsDevices = dsDevicesService.selectDsDevicesById(deviceid);
        mmap.put("dsDevices", dsDevices);
        mmap.put("stationInfo",dsStationsService.selectStationID());
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("system:devicesInfo:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsDevices dsDevices)
    {
        return toAjax(dsDevicesService.updateDsDevices(dsDevices));
    }

    /**
     * 删除设备信息
     */
    @RequiresPermissions("system:devicesInfo:remove")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsDevicesService.deleteDsDevicesByIds(ids));
    }


    @RequestMapping("/getAllDeviceInfo")
    @ResponseBody
    public List getAllDeviceInfo(){
        return dsDevicesService.getAllDeviceInfo();
    }
}
