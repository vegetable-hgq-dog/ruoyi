package com.ruoyi.project.system.factoryInventoryInf.controller;

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
import com.ruoyi.project.system.factoryInventoryInf.domain.FactoryInventoryTable;
import com.ruoyi.project.system.factoryInventoryInf.service.IFactoryInventoryTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.utils.security.ShiroUtils;

/**
 * 工厂库存Controller
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Controller
@RequestMapping("/system/factoryInventoryInf")
public class FactoryInventoryTableController extends BaseController
{
    private String prefix = "system/factoryInventoryInf";

    @Autowired
    private IFactoryInventoryTableService factoryInventoryTableService;

    @RequiresPermissions("system:factoryInventoryInf:view")
    @GetMapping()
    public String factoryInventoryInf()
    {
        return prefix + "/factoryInventoryInf";
    }

    /**
     * 查询工厂库存列表
     */
    @RequiresPermissions("system:factoryInventoryInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FactoryInventoryTable factoryInventoryTable)
    {
        startPage();
        List<FactoryInventoryTable> list = factoryInventoryTableService.selectFactoryInventoryTableList(factoryInventoryTable);
        return getDataTable(list);
    }

    /**
     * 导出工厂库存列表
     */
    @RequiresPermissions("system:factoryInventoryInf:export")
    @Log(title = "工厂库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FactoryInventoryTable factoryInventoryTable)
    {
        List<FactoryInventoryTable> list = factoryInventoryTableService.selectFactoryInventoryTableList(factoryInventoryTable);
        ExcelUtil<FactoryInventoryTable> util = new ExcelUtil<FactoryInventoryTable>(FactoryInventoryTable.class);
        return util.exportExcel(list, "factoryInventoryInf");
    }

    /**
     * 新增工厂库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工厂库存
     */
    @RequiresPermissions("system:factoryInventoryInf:add")
    @Log(title = "工厂库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FactoryInventoryTable factoryInventoryTable)
    {
        return toAjax(factoryInventoryTableService.insertFactoryInventoryTable(factoryInventoryTable));
    }

    /**
     * 修改工厂库存
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FactoryInventoryTable factoryInventoryTable = factoryInventoryTableService.selectFactoryInventoryTableById(id);
        mmap.put("factoryInventoryTable", factoryInventoryTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存工厂库存
     */
    @RequiresPermissions("system:factoryInventoryInf:edit")
    @Log(title = "工厂库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FactoryInventoryTable factoryInventoryTable)
    {
        return toAjax(factoryInventoryTableService.updateFactoryInventoryTable(factoryInventoryTable));
    }

    /**
     * 删除工厂库存
     */
    @RequiresPermissions("system:factoryInventoryInf:remove")
    @Log(title = "工厂库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(factoryInventoryTableService.deleteFactoryInventoryTableByIds(ids));
    }

//=========================================

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<FactoryInventoryTable> util = new ExcelUtil<FactoryInventoryTable>(FactoryInventoryTable.class);
        return util.importTemplateExcel("工厂库存信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FactoryInventoryTable> util = new ExcelUtil<FactoryInventoryTable>(FactoryInventoryTable.class);
        List<FactoryInventoryTable> factoryInventoryList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = factoryInventoryTableService.importFactoryInventory(factoryInventoryList, updateSupport,operName);
        return AjaxResult.success(message);
    }
}
