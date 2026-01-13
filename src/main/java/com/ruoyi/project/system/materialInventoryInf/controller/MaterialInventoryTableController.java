package com.ruoyi.project.system.materialInventoryInf.controller;

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
import com.ruoyi.project.system.materialInventoryInf.domain.MaterialInventoryTable;
import com.ruoyi.project.system.materialInventoryInf.service.IMaterialInventoryTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 供应商库存Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/materialInventoryInf")
public class MaterialInventoryTableController extends BaseController
{
    private String prefix = "system/materialInventoryInf";

    @Autowired
    private IMaterialInventoryTableService materialInventoryTableService;

    @RequiresPermissions("system:materialInventoryInf:view")
    @GetMapping()
    public String materialInventoryInf()
    {
        return prefix + "/materialInventoryInf";
    }

    /**
     * 查询供应商库存列表
     */
    @RequiresPermissions("system:materialInventoryInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialInventoryTable materialInventoryTable)
    {
        startPage();
        List<MaterialInventoryTable> list = materialInventoryTableService.selectMaterialInventoryTableList(materialInventoryTable);
        return getDataTable(list);
    }

    /**
     * 导出供应商库存列表
     */
    @RequiresPermissions("system:materialInventoryInf:export")
    @Log(title = "供应商库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialInventoryTable materialInventoryTable)
    {
        List<MaterialInventoryTable> list = materialInventoryTableService.selectMaterialInventoryTableList(materialInventoryTable);
        ExcelUtil<MaterialInventoryTable> util = new ExcelUtil<MaterialInventoryTable>(MaterialInventoryTable.class);
        return util.exportExcel(list, "materialInventoryInf");
    }

    /**
     * 新增供应商库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商库存
     */
    @RequiresPermissions("system:materialInventoryInf:add")
    @Log(title = "供应商库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialInventoryTable materialInventoryTable)
    {
        return toAjax(materialInventoryTableService.insertMaterialInventoryTable(materialInventoryTable));
    }

    /**
     * 修改供应商库存
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MaterialInventoryTable materialInventoryTable = materialInventoryTableService.selectMaterialInventoryTableById(id);
        mmap.put("materialInventoryTable", materialInventoryTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商库存
     */
    @RequiresPermissions("system:materialInventoryInf:edit")
    @Log(title = "供应商库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialInventoryTable materialInventoryTable)
    {
        return toAjax(materialInventoryTableService.updateMaterialInventoryTable(materialInventoryTable));
    }

    /**
     * 删除供应商库存
     */
    @RequiresPermissions("system:materialInventoryInf:remove")
    @Log(title = "供应商库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialInventoryTableService.deleteMaterialInventoryTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<MaterialInventoryTable> util = new ExcelUtil<MaterialInventoryTable>(MaterialInventoryTable.class);
        return util.importTemplateExcel("物料库存信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<MaterialInventoryTable> util = new ExcelUtil<MaterialInventoryTable>(MaterialInventoryTable.class);
        List<MaterialInventoryTable> materialInventoryList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = materialInventoryTableService.importMaterialsInventory(materialInventoryList, updateSupport,operName);
        return AjaxResult.success(message);
    }
}
