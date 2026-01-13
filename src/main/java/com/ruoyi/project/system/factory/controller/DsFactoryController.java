package com.ruoyi.project.system.factory.controller;

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
import com.ruoyi.project.system.factory.domain.DsFactory;
import com.ruoyi.project.system.factory.service.IDsFactoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工厂信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/factory")
public class DsFactoryController extends BaseController
{
    private String prefix = "system/factory";

    @Autowired
    private IDsFactoryService dsFactoryService;

    @RequiresPermissions("system:factory:view")
    @GetMapping()
    public String factory()
    {
        return prefix + "/factory";
    }

    /**
     * 查询工厂信息列表
     */
    @RequiresPermissions("system:factory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsFactory dsFactory)
    {
        startPage();
        List<DsFactory> list = dsFactoryService.selectDsFactoryList(dsFactory);
        return getDataTable(list);
    }

    /**
     * 导出工厂信息列表
     */
    @RequiresPermissions("system:factory:export")
    @Log(title = "工厂信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsFactory dsFactory)
    {
        List<DsFactory> list = dsFactoryService.selectDsFactoryList(dsFactory);
        ExcelUtil<DsFactory> util = new ExcelUtil<DsFactory>(DsFactory.class);
        return util.exportExcel(list, "factory");
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
    @RequiresPermissions("system:factory:add")
    @Log(title = "工厂信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsFactory dsFactory)
    {
        return toAjax(dsFactoryService.insertDsFactory(dsFactory));
    }

    /**
     * 修改工厂信息
     */
    @GetMapping("/edit/{factoryid}")
    public String edit(@PathVariable("factoryid") Long factoryid, ModelMap mmap)
    {
        DsFactory dsFactory = dsFactoryService.selectDsFactoryById(factoryid);
        mmap.put("dsFactory", dsFactory);
        return prefix + "/edit";
    }

    /**
     * 修改保存工厂信息
     */
    @RequiresPermissions("system:factory:edit")
    @Log(title = "工厂信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsFactory dsFactory)
    {
        return toAjax(dsFactoryService.updateDsFactory(dsFactory));
    }

    /**
     * 删除工厂信息
     */
    @RequiresPermissions("system:factory:remove")
    @Log(title = "工厂信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsFactoryService.deleteDsFactoryByIds(ids));
    }
}
