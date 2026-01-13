package com.ruoyi.project.system.firmkeychainparameter.controller;

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
import com.ruoyi.project.system.firmkeychainparameter.domain.Firmkeychainparameter;
import com.ruoyi.project.system.firmkeychainparameter.service.IFirmkeychainparameterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 关键链条参数Controller
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Controller
@RequestMapping("/system/firmkeychainparameter")
public class FirmkeychainparameterController extends BaseController
{
    private String prefix = "system/firmkeychainparameter";

    @Autowired
    private IFirmkeychainparameterService firmkeychainparameterService;

    @RequiresPermissions("system:firmkeychainparameter:view")
    @GetMapping()
    public String firmkeychainparameter()
    {
        return prefix + "/firmkeychainparameter";
    }

    /**
     * 查询关键链条参数列表
     */
    @RequiresPermissions("system:firmkeychainparameter:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firmkeychainparameter firmkeychainparameter)
    {
        startPage();
        List<Firmkeychainparameter> list = firmkeychainparameterService.selectFirmkeychainparameterList(firmkeychainparameter);
        return getDataTable(list);
    }

    /**
     * 导出关键链条参数列表
     */
    @RequiresPermissions("system:firmkeychainparameter:export")
    @Log(title = "关键链条参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firmkeychainparameter firmkeychainparameter)
    {
        List<Firmkeychainparameter> list = firmkeychainparameterService.selectFirmkeychainparameterList(firmkeychainparameter);
        ExcelUtil<Firmkeychainparameter> util = new ExcelUtil<Firmkeychainparameter>(Firmkeychainparameter.class);
        return util.exportExcel(list, "firmkeychainparameter");
    }

    /**
     * 新增关键链条参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存关键链条参数
     */
    @RequiresPermissions("system:firmkeychainparameter:add")
    @Log(title = "关键链条参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firmkeychainparameter firmkeychainparameter)
    {
        return toAjax(firmkeychainparameterService.insertFirmkeychainparameter(firmkeychainparameter));
    }

    /**
     * 修改关键链条参数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Firmkeychainparameter firmkeychainparameter = firmkeychainparameterService.selectFirmkeychainparameterById(id);
        mmap.put("firmkeychainparameter", firmkeychainparameter);
        return prefix + "/edit";
    }

    /**
     * 修改保存关键链条参数
     */
    @RequiresPermissions("system:firmkeychainparameter:edit")
    @Log(title = "关键链条参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firmkeychainparameter firmkeychainparameter)
    {
        return toAjax(firmkeychainparameterService.updateFirmkeychainparameter(firmkeychainparameter));
    }

    /**
     * 删除关键链条参数
     */
    @RequiresPermissions("system:firmkeychainparameter:remove")
    @Log(title = "关键链条参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firmkeychainparameterService.deleteFirmkeychainparameterByIds(ids));
    }

    @RequestMapping("/getKeyChainParameter")
    @ResponseBody
    public List getKeyChainParameter(){
        return firmkeychainparameterService.getKeyChainParameter();
    }

}
