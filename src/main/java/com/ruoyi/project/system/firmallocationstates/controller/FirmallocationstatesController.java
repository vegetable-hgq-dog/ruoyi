package com.ruoyi.project.system.firmallocationstates.controller;

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
import com.ruoyi.project.system.firmallocationstates.domain.Firmallocationstates;
import com.ruoyi.project.system.firmallocationstates.service.IFirmallocationstatesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 初始分配方案Controller
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Controller
@RequestMapping("/system/firmallocationstates")
public class FirmallocationstatesController extends BaseController
{
    private String prefix = "system/firmallocationstates";

    @Autowired
    private IFirmallocationstatesService firmallocationstatesService;

    @RequiresPermissions("system:firmallocationstates:view")
    @GetMapping()
    public String firmallocationstates()
    {
        return prefix + "/firmallocationstates";
    }

    /**
     * 查询初始分配方案列表
     */
    @RequiresPermissions("system:firmallocationstates:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmallocationstates firmallocationstates)
    {
        startPage();
        List<Firmallocationstates> list = firmallocationstatesService.selectFirmallocationstatesList(firmallocationstates);
        return getDataTable(list);
    }

    /**
     * 导出初始分配方案列表
     */
    @RequiresPermissions("system:firmallocationstates:export")
    @Log(title = "初始分配方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmallocationstates firmallocationstates)
    {
        List<Firmallocationstates> list = firmallocationstatesService.selectFirmallocationstatesList(firmallocationstates);
        ExcelUtil<Firmallocationstates> util = new ExcelUtil<Firmallocationstates>(Firmallocationstates.class);
        return util.exportExcel(list, "firmallocationstates");
    }

    /**
     * 新增初始分配方案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存初始分配方案
     */
    @RequiresPermissions("system:firmallocationstates:add")
    @Log(title = "初始分配方案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmallocationstates firmallocationstates)
    {
        return toAjax(firmallocationstatesService.insertFirmallocationstates(firmallocationstates));
    }

    /**
     * 修改初始分配方案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmallocationstates firmallocationstates = firmallocationstatesService.selectFirmallocationstatesById(id);
        mmap.put("firmallocationstates", firmallocationstates);
        return prefix + "/edit";
    }

    /**
     * 修改保存初始分配方案
     */
    @RequiresPermissions("system:firmallocationstates:edit")
    @Log(title = "初始分配方案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmallocationstates firmallocationstates)
    {
        return toAjax(firmallocationstatesService.updateFirmallocationstates(firmallocationstates));
    }

    /**
     * 删除初始分配方案
     */
    @RequiresPermissions("system:firmallocationstates:remove")
    @Log(title = "初始分配方案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmallocationstatesService.deleteFirmallocationstatesByIds(ids));
    }
}
