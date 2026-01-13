package com.ruoyi.project.supply.materialsupply.controller;

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
import com.ruoyi.project.supply.materialsupply.domain.OdsIwmWmTotal;
import com.ruoyi.project.supply.materialsupply.service.IOdsIwmWmTotalService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * material_supplyController
 * 
 * @author xjtu
 * @date 2023-08-03
 */
@Controller
@RequestMapping("/supply/materialsupply")
public class OdsIwmWmTotalController extends BaseController
{
    private String prefix = "supply/materialsupply";

    @Autowired
    private IOdsIwmWmTotalService odsIwmWmTotalService;

    @RequiresPermissions("supply:materialsupply:view")
    @GetMapping()
    public String materialsupply()
    {
        return prefix + "/materialsupply";
    }

    /**
     * 查询material_supply列表
     */
    @RequiresPermissions("supply:materialsupply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OdsIwmWmTotal odsIwmWmTotal)
    {
        startPage();
        List<OdsIwmWmTotal> list = odsIwmWmTotalService.selectOdsIwmWmTotalList(odsIwmWmTotal);
        return getDataTable(list);
    }

    /**
     * 导出material_supply列表
     */
    @RequiresPermissions("supply:materialsupply:export")
    @Log(title = "material_supply", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OdsIwmWmTotal odsIwmWmTotal)
    {
        List<OdsIwmWmTotal> list = odsIwmWmTotalService.selectOdsIwmWmTotalList(odsIwmWmTotal);
        ExcelUtil<OdsIwmWmTotal> util = new ExcelUtil<OdsIwmWmTotal>(OdsIwmWmTotal.class);
        return util.exportExcel(list, "materialsupply");
    }

    /**
     * 新增material_supply
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存material_supply
     */
    @RequiresPermissions("supply:materialsupply:add")
    @Log(title = "material_supply", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OdsIwmWmTotal odsIwmWmTotal)
    {
        return toAjax(odsIwmWmTotalService.insertOdsIwmWmTotal(odsIwmWmTotal));
    }

    /**
     * 修改material_supply
     */
    @GetMapping("/edit/{autoid}")
    public String edit(@PathVariable("autoid") Long autoid, ModelMap mmap)
    {
        OdsIwmWmTotal odsIwmWmTotal = odsIwmWmTotalService.selectOdsIwmWmTotalById(autoid);
        mmap.put("odsIwmWmTotal", odsIwmWmTotal);
        return prefix + "/edit";
    }

    /**
     * 修改保存material_supply
     */
    @RequiresPermissions("supply:materialsupply:edit")
    @Log(title = "material_supply", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OdsIwmWmTotal odsIwmWmTotal)
    {
        return toAjax(odsIwmWmTotalService.updateOdsIwmWmTotal(odsIwmWmTotal));
    }

    /**
     * 删除material_supply
     */
    @RequiresPermissions("supply:materialsupply:remove")
    @Log(title = "material_supply", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(odsIwmWmTotalService.deleteOdsIwmWmTotalByIds(ids));
    }
}
