package com.ruoyi.project.system.firmrelystates.controller;

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
import com.ruoyi.project.system.firmrelystates.domain.Firmrelystates;
import com.ruoyi.project.system.firmrelystates.service.IFirmrelystatesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 企业群数据管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Controller
@RequestMapping("/system/firmrelystates")
public class FirmrelystatesController extends BaseController
{
    private String prefix = "system/firmrelystates";

    @Autowired
    private IFirmrelystatesService firmrelystatesService;

    @RequiresPermissions("system:firmrelystates:view")
    @GetMapping()
    public String firmrelystates()
    {
        return prefix + "/firmrelystates";
    }

    /**
     * 查询企业群数据管理列表
     */
    @RequiresPermissions("system:firmrelystates:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmrelystates firmrelystates)
    {
        startPage();
        List<Firmrelystates> list = firmrelystatesService.selectFirmrelystatesList(firmrelystates);
        return getDataTable(list);
    }

    /**
     * 导出企业群数据管理列表
     */
    @RequiresPermissions("system:firmrelystates:export")
    @Log(title = "企业群数据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmrelystates firmrelystates)
    {
        List<Firmrelystates> list = firmrelystatesService.selectFirmrelystatesList(firmrelystates);
        ExcelUtil<Firmrelystates> util = new ExcelUtil<Firmrelystates>(Firmrelystates.class);
        return util.exportExcel(list, "firmrelystates");
    }

    /**
     * 新增企业群数据管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业群数据管理
     */
    @RequiresPermissions("system:firmrelystates:add")
    @Log(title = "企业群数据管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmrelystates firmrelystates)
    {
        return toAjax(firmrelystatesService.insertFirmrelystates(firmrelystates));
    }

    /**
     * 修改企业群数据管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmrelystates firmrelystates = firmrelystatesService.selectFirmrelystatesById(id);
        mmap.put("firmrelystates", firmrelystates);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业群数据管理
     */
    @RequiresPermissions("system:firmrelystates:edit")
    @Log(title = "企业群数据管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmrelystates firmrelystates)
    {
        return toAjax(firmrelystatesService.updateFirmrelystates(firmrelystates));
    }

    /**
     * 删除企业群数据管理
     */
    @RequiresPermissions("system:firmrelystates:remove")
    @Log(title = "企业群数据管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmrelystatesService.deleteFirmrelystatesByIds(ids));
    }


    @RequestMapping("/getRelyState")
    @ResponseBody
    public List getRelyState(){
        return firmrelystatesService.getRelyState();
    }
}
