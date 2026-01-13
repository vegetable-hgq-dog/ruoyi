package com.ruoyi.project.system.manufacturingfeatureinfo.controller;

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
import com.ruoyi.project.system.manufacturingfeatureinfo.domain.Manufacturingfeatureinfo;
import com.ruoyi.project.system.manufacturingfeatureinfo.service.IManufacturingfeatureinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 制造特征Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/manufacturingfeatureinfo")
public class ManufacturingfeatureinfoController extends BaseController
{
    private String prefix = "system/manufacturingfeatureinfo";

    @Autowired
    private IManufacturingfeatureinfoService manufacturingfeatureinfoService;

    @RequiresPermissions("system:manufacturingfeatureinfo:view")
    @GetMapping()
    public String manufacturingfeatureinfo()
    {
        return prefix + "/manufacturingfeatureinfo";
    }

    /**
     * 查询制造特征列表
     */
    @RequiresPermissions("system:manufacturingfeatureinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        startPage();
        List<Manufacturingfeatureinfo> list = manufacturingfeatureinfoService.selectManufacturingfeatureinfoList(manufacturingfeatureinfo);
        return getDataTable(list);
    }

    /**
     * 导出制造特征列表
     */
    @RequiresPermissions("system:manufacturingfeatureinfo:export")
    @Log(title = "制造特征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        List<Manufacturingfeatureinfo> list = manufacturingfeatureinfoService.selectManufacturingfeatureinfoList(manufacturingfeatureinfo);
        ExcelUtil<Manufacturingfeatureinfo> util = new ExcelUtil<Manufacturingfeatureinfo>(Manufacturingfeatureinfo.class);
        return util.exportExcel(list, "manufacturingfeatureinfo");
    }

    /**
     * 新增制造特征
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存制造特征
     */
    @RequiresPermissions("system:manufacturingfeatureinfo:add")
    @Log(title = "制造特征", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        return toAjax(manufacturingfeatureinfoService.insertManufacturingfeatureinfo(manufacturingfeatureinfo));
    }

    /**
     * 修改制造特征
     */
    @GetMapping("/edit/{manufacturingfeatureid}")
    public String edit(@PathVariable("manufacturingfeatureid") Long manufacturingfeatureid, ModelMap mmap)
    {
        Manufacturingfeatureinfo manufacturingfeatureinfo = manufacturingfeatureinfoService.selectManufacturingfeatureinfoById(manufacturingfeatureid);
        mmap.put("manufacturingfeatureinfo", manufacturingfeatureinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存制造特征
     */
    @RequiresPermissions("system:manufacturingfeatureinfo:edit")
    @Log(title = "制造特征", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        return toAjax(manufacturingfeatureinfoService.updateManufacturingfeatureinfo(manufacturingfeatureinfo));
    }

    /**
     * 删除制造特征
     */
    @RequiresPermissions("system:manufacturingfeatureinfo:remove")
    @Log(title = "制造特征", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(manufacturingfeatureinfoService.deleteManufacturingfeatureinfoByIds(ids));
    }
}
