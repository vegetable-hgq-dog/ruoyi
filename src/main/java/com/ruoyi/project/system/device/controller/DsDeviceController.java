package com.ruoyi.project.system.device.controller;

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
import com.ruoyi.project.system.device.domain.DsDevice;
import com.ruoyi.project.system.device.service.IDsDeviceService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设备管理Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/device")
public class DsDeviceController extends BaseController
{
    private String prefix = "system/device";

    @Autowired
    private IDsDeviceService dsDeviceService;

    @RequiresPermissions("system:device:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询设备管理列表
     */
    @RequiresPermissions("system:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsDevice dsDevice)
    {
        startPage();
        List<DsDevice> list = dsDeviceService.selectDsDeviceList(dsDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @RequiresPermissions("system:device:export")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsDevice dsDevice)
    {
        List<DsDevice> list = dsDeviceService.selectDsDeviceList(dsDevice);
        ExcelUtil<DsDevice> util = new ExcelUtil<DsDevice>(DsDevice.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 新增设备管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备管理
     */
    @RequiresPermissions("system:device:add")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsDevice dsDevice)
    {
        return toAjax(dsDeviceService.insertDsDevice(dsDevice));
    }

    /**
     * 修改设备管理
     */
    @GetMapping("/edit/{deviceid}")
    public String edit(@PathVariable("deviceid") Long deviceid, ModelMap mmap)
    {
        DsDevice dsDevice = dsDeviceService.selectDsDeviceById(deviceid);
        mmap.put("dsDevice", dsDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备管理
     */
    @RequiresPermissions("system:device:edit")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsDevice dsDevice)
    {
        return toAjax(dsDeviceService.updateDsDevice(dsDevice));
    }

    /**
     * 删除设备管理
     */
    @RequiresPermissions("system:device:remove")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsDeviceService.deleteDsDeviceByIds(ids));
    }
}
