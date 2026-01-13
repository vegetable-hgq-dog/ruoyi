package com.ruoyi.project.system.productline.controller;

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
import com.ruoyi.project.system.productline.domain.DsProductline;
import com.ruoyi.project.system.productline.service.IDsProductlineService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 产线信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/productline")
public class DsProductlineController extends BaseController
{
    private String prefix = "system/productline";

    @Autowired
    private IDsProductlineService dsProductlineService;

    @RequiresPermissions("system:productline:view")
    @GetMapping()
    public String productline()
    {
        return prefix + "/productline";
    }

    /**
     * 查询产线信息列表
     */
    @RequiresPermissions("system:productline:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsProductline dsProductline)
    {
        startPage();
        List<DsProductline> list = dsProductlineService.selectDsProductlineList(dsProductline);
        return getDataTable(list);
    }

    /**
     * 导出产线信息列表
     */
    @RequiresPermissions("system:productline:export")
    @Log(title = "产线信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsProductline dsProductline)
    {
        List<DsProductline> list = dsProductlineService.selectDsProductlineList(dsProductline);
        ExcelUtil<DsProductline> util = new ExcelUtil<DsProductline>(DsProductline.class);
        return util.exportExcel(list, "productline");
    }

    /**
     * 新增产线信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产线信息
     */
    @RequiresPermissions("system:productline:add")
    @Log(title = "产线信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsProductline dsProductline)
    {
        return toAjax(dsProductlineService.insertDsProductline(dsProductline));
    }

    /**
     * 修改产线信息
     */
    @GetMapping("/edit/{productlineid}")
    public String edit(@PathVariable("productlineid") Long productlineid, ModelMap mmap)
    {
        DsProductline dsProductline = dsProductlineService.selectDsProductlineById(productlineid);
        mmap.put("dsProductline", dsProductline);
        return prefix + "/edit";
    }

    /**
     * 修改保存产线信息
     */
    @RequiresPermissions("system:productline:edit")
    @Log(title = "产线信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsProductline dsProductline)
    {
        return toAjax(dsProductlineService.updateDsProductline(dsProductline));
    }

    /**
     * 删除产线信息
     */
    @RequiresPermissions("system:productline:remove")
    @Log(title = "产线信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsProductlineService.deleteDsProductlineByIds(ids));
    }
}
