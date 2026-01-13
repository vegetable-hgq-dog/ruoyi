package com.ruoyi.project.system.pickupPlanInf.controller;

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
import com.ruoyi.project.system.pickupPlanInf.domain.PickupplanTable;
import com.ruoyi.project.system.pickupPlanInf.service.IPickupplanTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 取货计划Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/pickupPlanInf")
public class PickupplanTableController extends BaseController
{
    private String prefix = "system/pickupPlanInf";

    @Autowired
    private IPickupplanTableService pickupplanTableService;

    @RequiresPermissions("system:pickupPlanInf:view")
    @GetMapping()
    public String pickupPlanInf()
    {
        return prefix + "/pickupPlanInf";
    }

    /**
     * 查询取货计划列表
     */
    @RequiresPermissions("system:pickupPlanInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PickupplanTable pickupplanTable)
    {
        startPage();
        List<PickupplanTable> list = pickupplanTableService.selectPickupplanTableList(pickupplanTable);
        return getDataTable(list);
    }

    /**
     * 导出取货计划列表
     */
    @RequiresPermissions("system:pickupPlanInf:export")
    @Log(title = "取货计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PickupplanTable pickupplanTable)
    {
        List<PickupplanTable> list = pickupplanTableService.selectPickupplanTableList(pickupplanTable);
        ExcelUtil<PickupplanTable> util = new ExcelUtil<PickupplanTable>(PickupplanTable.class);
        return util.exportExcel(list, "pickupPlanInf");
    }

    /**
     * 新增取货计划
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存取货计划
     */
    @RequiresPermissions("system:pickupPlanInf:add")
    @Log(title = "取货计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PickupplanTable pickupplanTable)
    {
        return toAjax(pickupplanTableService.insertPickupplanTable(pickupplanTable));
    }

    /**
     * 修改取货计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PickupplanTable pickupplanTable = pickupplanTableService.selectPickupplanTableById(id);
        mmap.put("pickupplanTable", pickupplanTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存取货计划
     */
    @RequiresPermissions("system:pickupPlanInf:edit")
    @Log(title = "取货计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PickupplanTable pickupplanTable)
    {
        return toAjax(pickupplanTableService.updatePickupplanTable(pickupplanTable));
    }

    /**
     * 删除取货计划
     */
    @RequiresPermissions("system:pickupPlanInf:remove")
    @Log(title = "取货计划", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(pickupplanTableService.deletePickupplanTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PickupplanTable> util = new ExcelUtil<PickupplanTable>(PickupplanTable.class);
        return util.importTemplateExcel("计划交货信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<PickupplanTable> util = new ExcelUtil<PickupplanTable>(PickupplanTable.class);
        List<PickupplanTable> pickupplanList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = pickupplanTableService.importPickupplan(pickupplanList, updateSupport,operName);
        return AjaxResult.success(message);
    }


    @RequestMapping("/getAllPickupplanData")
    @ResponseBody
    public List getAllPickupplanData(){
        return pickupplanTableService.getAllPickupplanData();
    }
}
