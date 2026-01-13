package com.ruoyi.project.system.factoryInf.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.distributeStaffInf.domain.DistributestaffsTable;
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
import com.ruoyi.project.system.factoryInf.domain.FactoryTable;
import com.ruoyi.project.system.factoryInf.service.IFactoryTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工厂信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/factoryInf")
public class FactoryTableController extends BaseController
{
    private String prefix = "system/factoryInf";

    @Autowired
    private IFactoryTableService factoryTableService;

    @RequiresPermissions("system:factoryInf:view")
    @GetMapping()
    public String factoryInf()
    {
        return prefix + "/factoryInf";
    }

    /**
     * 查询工厂信息列表
     */
    @RequiresPermissions("system:factoryInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FactoryTable factoryTable)
    {
        startPage();
        List<FactoryTable> list = factoryTableService.selectFactoryTableList(factoryTable);
        return getDataTable(list);
    }

    /**
     * 导出工厂信息列表
     */
    @RequiresPermissions("system:factoryInf:export")
    @Log(title = "工厂信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FactoryTable factoryTable)
    {
        List<FactoryTable> list = factoryTableService.selectFactoryTableList(factoryTable);
        ExcelUtil<FactoryTable> util = new ExcelUtil<FactoryTable>(FactoryTable.class);
        return util.exportExcel(list, "factoryInf");
    }

    /**
     * 新增工厂信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工厂信息
     */
    @RequiresPermissions("system:factoryInf:add")
    @Log(title = "工厂信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FactoryTable factoryTable)
    {
        return toAjax(factoryTableService.insertFactoryTable(factoryTable));
    }

    /**
     * 修改工厂信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FactoryTable factoryTable = factoryTableService.selectFactoryTableById(id);
        mmap.put("factoryTable", factoryTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存工厂信息
     */
    @RequiresPermissions("system:factoryInf:edit")
    @Log(title = "工厂信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FactoryTable factoryTable)
    {
        return toAjax(factoryTableService.updateFactoryTable(factoryTable));
    }

    /**
     * 删除工厂信息
     */
    @RequiresPermissions("system:factoryInf:remove")
    @Log(title = "工厂信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(factoryTableService.deleteFactoryTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<FactoryTable> util = new ExcelUtil<FactoryTable>(FactoryTable.class);
        return util.importTemplateExcel("工厂信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FactoryTable> util = new ExcelUtil<FactoryTable>(FactoryTable.class);
        List<FactoryTable> factoryList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = factoryTableService.importFactory(factoryList, updateSupport,operName);
        return AjaxResult.success(message);
    }


    @RequestMapping("/selectFactoryInfo")
    @ResponseBody
    public List selectFactoryInfo(){
        return factoryTableService.selectFactoryInfo();
    }
}
