package com.ruoyi.project.system.station.controller;

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
import com.ruoyi.project.system.station.domain.DsStation;
import com.ruoyi.project.system.station.service.IDsStationService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工位信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/station")
public class DsStationController extends BaseController
{
    private String prefix = "system/station";

    @Autowired
    private IDsStationService dsStationService;

    @RequiresPermissions("system:station:view")
    @GetMapping()
    public String station()
    {
        return prefix + "/station";
    }

    /**
     * 查询工位信息列表
     */
    @RequiresPermissions("system:station:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsStation dsStation)
    {
        startPage();
        List<DsStation> list = dsStationService.selectDsStationList(dsStation);
        return getDataTable(list);
    }

    /**
     * 导出工位信息列表
     */
    @RequiresPermissions("system:station:export")
    @Log(title = "工位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsStation dsStation)
    {
        List<DsStation> list = dsStationService.selectDsStationList(dsStation);
        ExcelUtil<DsStation> util = new ExcelUtil<DsStation>(DsStation.class);
        return util.exportExcel(list, "station");
    }

    /**
     * 新增工位信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工位信息
     */
    @RequiresPermissions("system:station:add")
    @Log(title = "工位信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsStation dsStation)
    {
        return toAjax(dsStationService.insertDsStation(dsStation));
    }

    /**
     * 修改工位信息
     */
    @GetMapping("/edit/{stationid}")
    public String edit(@PathVariable("stationid") Long stationid, ModelMap mmap)
    {
        DsStation dsStation = dsStationService.selectDsStationById(stationid);
        mmap.put("dsStation", dsStation);
        return prefix + "/edit";
    }

    /**
     * 修改保存工位信息
     */
    @RequiresPermissions("system:station:edit")
    @Log(title = "工位信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsStation dsStation)
    {
        return toAjax(dsStationService.updateDsStation(dsStation));
    }

    /**
     * 删除工位信息
     */
    @RequiresPermissions("system:station:remove")
    @Log(title = "工位信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsStationService.deleteDsStationByIds(ids));
    }
}
