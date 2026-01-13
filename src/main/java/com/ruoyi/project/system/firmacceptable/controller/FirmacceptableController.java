package com.ruoyi.project.system.firmacceptable.controller;

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
import com.ruoyi.project.system.firmacceptable.domain.Firmacceptable;
import com.ruoyi.project.system.firmacceptable.service.IFirmacceptableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 可接受不可操作的程度Controller
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Controller
@RequestMapping("/system/firmacceptable")
public class FirmacceptableController extends BaseController
{
    private String prefix = "system/firmacceptable";

    @Autowired
    private IFirmacceptableService firmacceptableService;

    @RequiresPermissions("system:firmacceptable:view")
    @GetMapping()
    public String firmacceptable()
    {
        return prefix + "/firmacceptable";
    }

    /**
     * 查询可接受不可操作的程度列表
     */
    @RequiresPermissions("system:firmacceptable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmacceptable firmacceptable)
    {
        startPage();
        List<Firmacceptable> list = firmacceptableService.selectFirmacceptableList(firmacceptable);
        return getDataTable(list);
    }

    /**
     * 导出可接受不可操作的程度列表
     */
    @RequiresPermissions("system:firmacceptable:export")
    @Log(title = "可接受不可操作的程度", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmacceptable firmacceptable)
    {
        List<Firmacceptable> list = firmacceptableService.selectFirmacceptableList(firmacceptable);
        ExcelUtil<Firmacceptable> util = new ExcelUtil<Firmacceptable>(Firmacceptable.class);
        return util.exportExcel(list, "firmacceptable");
    }

    /**
     * 新增可接受不可操作的程度
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存可接受不可操作的程度
     */
    @RequiresPermissions("system:firmacceptable:add")
    @Log(title = "可接受不可操作的程度", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmacceptable firmacceptable)
    {
        return toAjax(firmacceptableService.insertFirmacceptable(firmacceptable));
    }

    /**
     * 修改可接受不可操作的程度
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmacceptable firmacceptable = firmacceptableService.selectFirmacceptableById(id);
        mmap.put("firmacceptable", firmacceptable);
        return prefix + "/edit";
    }

    /**
     * 修改保存可接受不可操作的程度
     */
    @RequiresPermissions("system:firmacceptable:edit")
    @Log(title = "可接受不可操作的程度", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmacceptable firmacceptable)
    {
        return toAjax(firmacceptableService.updateFirmacceptable(firmacceptable));
    }

    /**
     * 删除可接受不可操作的程度
     */
    @RequiresPermissions("system:firmacceptable:remove")
    @Log(title = "可接受不可操作的程度", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmacceptableService.deleteFirmacceptableByIds(ids));
    }

    @RequestMapping("/getAcceptable")
    @ResponseBody
    public List getAcceptable(){
        return firmacceptableService.getAcceptable();
    }
}
