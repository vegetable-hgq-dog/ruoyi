package com.ruoyi.project.system.orderInf.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.factoryInf.service.impl.FactoryTableServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.orderInf.domain.OrderTable;
import com.ruoyi.project.system.orderInf.service.IOrderTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 订单信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/orderInf")
public class OrderTableController extends BaseController
{
    private String prefix = "system/orderInf";
    @Autowired
    private FactoryTableServiceImpl factoryTableService;

    @Autowired
    private IOrderTableService orderTableService;

    @RequiresPermissions("system:orderInf:view")
    @GetMapping()
    public String orderInf()
    {

        return prefix + "/orderInf";
    }

    /**
     * 查询订单信息列表
     */
    @RequiresPermissions("system:orderInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderTable orderTable)
    {
        startPage();
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @RequiresPermissions("system:orderInf:export")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderTable orderTable)
    {
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        ExcelUtil<OrderTable> util = new ExcelUtil<OrderTable>(OrderTable.class);
        return util.exportExcel(list, "orderInf");
    }

    /**
     * 新增订单信息
     */
    @GetMapping("/add")
    public String add(ModelMap ordermap)
    {
        ordermap.put("factoryInfo",factoryTableService.selectFactoryInfo());

        return prefix + "/add";
    }

    /**
     * 新增保存订单信息
     */
    @RequiresPermissions("system:orderInf:add")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderTable orderTable)
    {
        return toAjax(orderTableService.insertOrderTable(orderTable));
    }

    /**
     * 修改订单信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OrderTable orderTable = orderTableService.selectOrderTableById(id);
        mmap.put("orderTable", orderTable);
        mmap.put("factoryInfo",factoryTableService.selectFactoryInfo());
        return prefix + "/edit";
    }

    /**
     * 修改保存订单信息
     */
    @RequiresPermissions("system:orderInf:edit")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderTable orderTable)
    {
        return toAjax(orderTableService.updateOrderTable(orderTable));
    }

    /**
     * 删除订单信息
     */
    @RequiresPermissions("system:orderInf:remove")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderTableService.deleteOrderTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<OrderTable> util = new ExcelUtil<OrderTable>(OrderTable.class);
        return util.importTemplateExcel("订单信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<OrderTable> util = new ExcelUtil<OrderTable>(OrderTable.class);
        List<OrderTable> orderList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = orderTableService.importOrder(orderList, updateSupport,operName);
        return AjaxResult.success(message);
    }

    @RequestMapping("/allData")
    @ResponseBody
    public List<OrderTable> getAllData(){
        return orderTableService.getData();
    }

    @RequestMapping("/getMaterialAmount")
    @ResponseBody
    public List getMaterialAmount(){
        return orderTableService.getMaterialAmount();
    }

    @RequestMapping("/getSupplierAmount")
    @ResponseBody
    public List getSupplierAmount(){
        return orderTableService.getSupplierAmount();
    }


}
