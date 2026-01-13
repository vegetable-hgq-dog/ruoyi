package com.ruoyi.project.system.materialInf.controller;

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
import com.ruoyi.project.system.materialInf.domain.MaterialsTable;
import com.ruoyi.project.system.materialInf.service.IMaterialsTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 物料信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/materialInf")
public class MaterialsTableController extends BaseController
{
    private String prefix = "system/materialInf";

    @Autowired
    private IMaterialsTableService materialsTableService;

    @RequiresPermissions("system:materialInf:view")
    @GetMapping()
    public String materialInf()
    {
        return prefix + "/materialInf";
    }

    /**
     * 查询物料信息列表
     */
    @RequiresPermissions("system:materialInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaterialsTable materialsTable)
    {
        startPage();
        List<MaterialsTable> list = materialsTableService.selectMaterialsTableList(materialsTable);
        return getDataTable(list);
    }

    /**
     * 导出物料信息列表
     */
    @RequiresPermissions("system:materialInf:export")
    @Log(title = "物料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MaterialsTable materialsTable)
    {
        List<MaterialsTable> list = materialsTableService.selectMaterialsTableList(materialsTable);
        ExcelUtil<MaterialsTable> util = new ExcelUtil<MaterialsTable>(MaterialsTable.class);
        return util.exportExcel(list, "materialInf");
    }

    /**
     * 新增物料信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物料信息
     */
    @RequiresPermissions("system:materialInf:add")
    @Log(title = "物料信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaterialsTable materialsTable)
    {
        return toAjax(materialsTableService.insertMaterialsTable(materialsTable));
    }

    /**
     * 修改物料信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MaterialsTable materialsTable = materialsTableService.selectMaterialsTableById(id);
        mmap.put("materialsTable", materialsTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存物料信息
     */
    @RequiresPermissions("system:materialInf:edit")
    @Log(title = "物料信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MaterialsTable materialsTable)
    {
        return toAjax(materialsTableService.updateMaterialsTable(materialsTable));
    }

    /**
     * 删除物料信息
     */
    @RequiresPermissions("system:materialInf:remove")
    @Log(title = "物料信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialsTableService.deleteMaterialsTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<MaterialsTable> util = new ExcelUtil<MaterialsTable>(MaterialsTable.class);
        return util.importTemplateExcel("物料信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<MaterialsTable> util = new ExcelUtil<MaterialsTable>(MaterialsTable.class);
        List<MaterialsTable> materialsList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = materialsTableService.importMaterials(materialsList, updateSupport,operName);
        return AjaxResult.success(message);
    }

    @RequestMapping("/getAllMaterialData")
    @ResponseBody
    public List getAllMaterialData(){
        return materialsTableService.getAllMaterialData();
    }
}
