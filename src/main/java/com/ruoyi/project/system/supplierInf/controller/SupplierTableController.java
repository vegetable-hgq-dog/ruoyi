package com.ruoyi.project.system.supplierInf.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
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
import com.ruoyi.project.system.supplierInf.domain.SupplierTable;
import com.ruoyi.project.system.supplierInf.service.ISupplierTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 供应商信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/supplierInf")
public class SupplierTableController extends BaseController
{
    private String prefix = "system/supplierInf";

    @Autowired
    private ISupplierTableService supplierTableService;

    @RequiresPermissions("system:supplierInf:view")
    @GetMapping()
    public String supplierInf()
    {
        return prefix + "/supplierInf";
    }

    /**
     * 查询供应商信息列表
     */
    @RequiresPermissions("system:supplierInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SupplierTable supplierTable)
    {
        startPage();
        List<SupplierTable> list = supplierTableService.selectSupplierTableList(supplierTable);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息列表
     */
    @RequiresPermissions("system:supplierInf:export")
    @Log(title = "供应商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SupplierTable supplierTable)
    {
        List<SupplierTable> list = supplierTableService.selectSupplierTableList(supplierTable);
        ExcelUtil<SupplierTable> util = new ExcelUtil<SupplierTable>(SupplierTable.class);
        return util.exportExcel(list, "supplierInf");
    }

    /**
     * 新增供应商信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商信息
     */
    @RequiresPermissions("system:supplierInf:add")
    @Log(title = "供应商信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SupplierTable supplierTable)
    {
        return toAjax(supplierTableService.insertSupplierTable(supplierTable));
    }

    /**
     * 修改供应商信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SupplierTable supplierTable = supplierTableService.selectSupplierTableById(id);
        mmap.put("supplierTable", supplierTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商信息
     */
    @RequiresPermissions("system:supplierInf:edit")
    @Log(title = "供应商信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SupplierTable supplierTable)
    {
        return toAjax(supplierTableService.updateSupplierTable(supplierTable));
    }

    /**
     * 删除供应商信息
     */
    @RequiresPermissions("system:supplierInf:remove")
    @Log(title = "供应商信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(supplierTableService.deleteSupplierTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SupplierTable> util = new ExcelUtil<SupplierTable>(SupplierTable.class);
        return util.importTemplateExcel("供应商信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SupplierTable> util = new ExcelUtil<SupplierTable>(SupplierTable.class);
        List<SupplierTable> SupplierList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = supplierTableService.importSupplier(SupplierList, updateSupport,operName);
        return AjaxResult.success(message);
    }

    @RequestMapping("/getAllSupplierData")
    @ResponseBody
    public List getAllSupplierData(){
        return supplierTableService.getAllSupplierData();
    }
}
