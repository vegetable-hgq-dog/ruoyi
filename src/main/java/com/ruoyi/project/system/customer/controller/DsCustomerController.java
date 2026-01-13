package com.ruoyi.project.system.customer.controller;

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
import com.ruoyi.project.system.customer.domain.DsCustomer;
import com.ruoyi.project.system.customer.service.IDsCustomerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * customerController
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Controller
@RequestMapping("/system/customer")
public class DsCustomerController extends BaseController
{
    private String prefix = "system/customer";

    @Autowired
    private IDsCustomerService dsCustomerService;

    @RequiresPermissions("system:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询customer列表
     */
    @RequiresPermissions("system:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsCustomer dsCustomer)
    {
        startPage();
        List<DsCustomer> list = dsCustomerService.selectDsCustomerList(dsCustomer);
        return getDataTable(list);
    }

    /**
     * 导出customer列表
     */
    @RequiresPermissions("system:customer:export")
    @Log(title = "customer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsCustomer dsCustomer)
    {
        List<DsCustomer> list = dsCustomerService.selectDsCustomerList(dsCustomer);
        ExcelUtil<DsCustomer> util = new ExcelUtil<DsCustomer>(DsCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 新增customer
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存customer
     */
    @RequiresPermissions("system:customer:add")
    @Log(title = "customer", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsCustomer dsCustomer)
    {
        return toAjax(dsCustomerService.insertDsCustomer(dsCustomer));
    }

    /**
     * 修改customer
     */
    @GetMapping("/edit/{customerid}")
    public String edit(@PathVariable("customerid") Long customerid, ModelMap mmap)
    {
        DsCustomer dsCustomer = dsCustomerService.selectDsCustomerById(customerid);
        mmap.put("dsCustomer", dsCustomer);
        return prefix + "/edit";
    }

    /**
     * 修改保存customer
     */
    @RequiresPermissions("system:customer:edit")
    @Log(title = "customer", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsCustomer dsCustomer)
    {
        return toAjax(dsCustomerService.updateDsCustomer(dsCustomer));
    }

    /**
     * 删除customer
     */
    @RequiresPermissions("system:customer:remove")
    @Log(title = "customer", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsCustomerService.deleteDsCustomerByIds(ids));
    }
}
