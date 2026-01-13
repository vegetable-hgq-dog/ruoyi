package com.ruoyi.project.system.carrierInf.controller;

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
import com.ruoyi.project.system.carrierInf.domain.CarriersTable;
import com.ruoyi.project.system.carrierInf.service.ICarriersTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 承运商信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/carrierInf")
public class CarriersTableController extends BaseController
{
    private String prefix = "system/carrierInf";

    @Autowired
    private ICarriersTableService carriersTableService;

    @RequiresPermissions("system:carrierInf:view")
    @GetMapping()
    public String carrierInf()
    {
        return prefix + "/carrierInf";
    }

    /**
     * 查询承运商信息列表
     */
    @RequiresPermissions("system:carrierInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CarriersTable carriersTable)
    {
        startPage();
        List<CarriersTable> list = carriersTableService.selectCarriersTableList(carriersTable);
        return getDataTable(list);
    }

    /**
     * 导出承运商信息列表
     */
    @RequiresPermissions("system:carrierInf:export")
    @Log(title = "承运商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CarriersTable carriersTable)
    {
        List<CarriersTable> list = carriersTableService.selectCarriersTableList(carriersTable);
        ExcelUtil<CarriersTable> util = new ExcelUtil<CarriersTable>(CarriersTable.class);
        return util.exportExcel(list, "carrierInf");
    }

    /**
     * 新增承运商信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存承运商信息
     */
    @RequiresPermissions("system:carrierInf:add")
    @Log(title = "承运商信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CarriersTable carriersTable)
    {
        return toAjax(carriersTableService.insertCarriersTable(carriersTable));
    }

    /**
     * 修改承运商信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CarriersTable carriersTable = carriersTableService.selectCarriersTableById(id);
        mmap.put("carriersTable", carriersTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存承运商信息
     */
    @RequiresPermissions("system:carrierInf:edit")
    @Log(title = "承运商信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CarriersTable carriersTable)
    {
        return toAjax(carriersTableService.updateCarriersTable(carriersTable));
    }

    /**
     * 删除承运商信息
     */
    @RequiresPermissions("system:carrierInf:remove")
    @Log(title = "承运商信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(carriersTableService.deleteCarriersTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<CarriersTable> util = new ExcelUtil<CarriersTable>(CarriersTable.class);
        return util.importTemplateExcel("承运商信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CarriersTable> util = new ExcelUtil<CarriersTable>(CarriersTable.class);
        List<CarriersTable> carriersList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = carriersTableService.importCarriers(carriersList, updateSupport,operName);
        return AjaxResult.success(message);
    }
}
