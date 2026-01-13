package com.ruoyi.project.manufacture.weldinfo.controller;

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
import com.ruoyi.project.manufacture.weldinfo.domain.DsWeldingCurrentData;
import com.ruoyi.project.manufacture.weldinfo.service.IDsWeldingCurrentDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * weld_infoController
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Controller
@RequestMapping("/manufacture/weldinfo")
public class DsWeldingCurrentDataController extends BaseController
{
    private String prefix = "manufacture/weldinfo";

    @Autowired
    private IDsWeldingCurrentDataService dsWeldingCurrentDataService;

    @RequiresPermissions("manufacture:weldinfo:view")
    @GetMapping()
    public String weldinfo()
    {
        return prefix + "/weldinfo";
    }

    /**
     * 查询weld_info列表
     */
    @RequiresPermissions("manufacture:weldinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsWeldingCurrentData dsWeldingCurrentData)
    {
        startPage();
        List<DsWeldingCurrentData> list = dsWeldingCurrentDataService.selectDsWeldingCurrentDataList(dsWeldingCurrentData);
        return getDataTable(list);
    }

    /**
     * 导出weld_info列表
     */
    @RequiresPermissions("manufacture:weldinfo:export")
    @Log(title = "weld_info", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsWeldingCurrentData dsWeldingCurrentData)
    {
        List<DsWeldingCurrentData> list = dsWeldingCurrentDataService.selectDsWeldingCurrentDataList(dsWeldingCurrentData);
        ExcelUtil<DsWeldingCurrentData> util = new ExcelUtil<DsWeldingCurrentData>(DsWeldingCurrentData.class);
        return util.exportExcel(list, "weldinfo");
    }

    /**
     * 新增weld_info
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存weld_info
     */
    @RequiresPermissions("manufacture:weldinfo:add")
    @Log(title = "weld_info", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsWeldingCurrentData dsWeldingCurrentData)
    {
        return toAjax(dsWeldingCurrentDataService.insertDsWeldingCurrentData(dsWeldingCurrentData));
    }

    /**
     * 修改weld_info
     */
    @GetMapping("/edit/{autoId}")
    public String edit(@PathVariable("autoId") Long autoId, ModelMap mmap)
    {
        DsWeldingCurrentData dsWeldingCurrentData = dsWeldingCurrentDataService.selectDsWeldingCurrentDataById(autoId);
        mmap.put("dsWeldingCurrentData", dsWeldingCurrentData);
        return prefix + "/edit";
    }

    /**
     * 修改保存weld_info
     */
    @RequiresPermissions("manufacture:weldinfo:edit")
    @Log(title = "weld_info", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsWeldingCurrentData dsWeldingCurrentData)
    {
        return toAjax(dsWeldingCurrentDataService.updateDsWeldingCurrentData(dsWeldingCurrentData));
    }

    /**
     * 删除weld_info
     */
    @RequiresPermissions("manufacture:weldinfo:remove")
    @Log(title = "weld_info", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsWeldingCurrentDataService.deleteDsWeldingCurrentDataByIds(ids));
    }
}
