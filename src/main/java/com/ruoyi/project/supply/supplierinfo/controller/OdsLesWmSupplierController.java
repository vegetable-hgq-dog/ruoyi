package com.ruoyi.project.supply.supplierinfo.controller;

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
import com.ruoyi.project.supply.supplierinfo.domain.OdsLesWmSupplier;
import com.ruoyi.project.supply.supplierinfo.service.IOdsLesWmSupplierService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * supplier_infoController
 * 
 * @author xjtu
 * @date 2023-08-03
 */
@Controller
@RequestMapping("/supply/supplierinfo")
public class OdsLesWmSupplierController extends BaseController
{
    private String prefix = "supply/supplierinfo";

    @Autowired
    private IOdsLesWmSupplierService odsLesWmSupplierService;

    @RequiresPermissions("supply:supplierinfo:view")
    @GetMapping()
    public String supplierinfo()
    {
        return prefix + "/supplierinfo";
    }

    /**
     * 查询supplier_info列表
     */
    @RequiresPermissions("supply:supplierinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OdsLesWmSupplier odsLesWmSupplier)
    {
        startPage();
        List<OdsLesWmSupplier> list = odsLesWmSupplierService.selectOdsLesWmSupplierList(odsLesWmSupplier);
        return getDataTable(list);
    }

    /**
     * 导出supplier_info列表
     */
    @RequiresPermissions("supply:supplierinfo:export")
    @Log(title = "supplier_info", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OdsLesWmSupplier odsLesWmSupplier)
    {
        List<OdsLesWmSupplier> list = odsLesWmSupplierService.selectOdsLesWmSupplierList(odsLesWmSupplier);
        ExcelUtil<OdsLesWmSupplier> util = new ExcelUtil<OdsLesWmSupplier>(OdsLesWmSupplier.class);
        return util.exportExcel(list, "supplierinfo");
    }

    /**
     * 新增supplier_info
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存supplier_info
     */
    @RequiresPermissions("supply:supplierinfo:add")
    @Log(title = "supplier_info", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OdsLesWmSupplier odsLesWmSupplier)
    {
        return toAjax(odsLesWmSupplierService.insertOdsLesWmSupplier(odsLesWmSupplier));
    }

    /**
     * 修改supplier_info
     */
    @GetMapping("/edit/{autoid}")
    public String edit(@PathVariable("autoid") Long autoid, ModelMap mmap)
    {
        OdsLesWmSupplier odsLesWmSupplier = odsLesWmSupplierService.selectOdsLesWmSupplierById(autoid);
        mmap.put("odsLesWmSupplier", odsLesWmSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存supplier_info
     */
    @RequiresPermissions("supply:supplierinfo:edit")
    @Log(title = "supplier_info", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OdsLesWmSupplier odsLesWmSupplier)
    {
        return toAjax(odsLesWmSupplierService.updateOdsLesWmSupplier(odsLesWmSupplier));
    }

    /**
     * 删除supplier_info
     */
    @RequiresPermissions("supply:supplierinfo:remove")
    @Log(title = "supplier_info", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(odsLesWmSupplierService.deleteOdsLesWmSupplierByIds(ids));
    }
}
