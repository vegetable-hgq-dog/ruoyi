package com.ruoyi.project.system.vechicleproduction.controller;

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
import com.ruoyi.project.system.vechicleproduction.domain.DsVechicleproduction;
import com.ruoyi.project.system.vechicleproduction.service.IDsVechicleproductionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 生产信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/vechicleproduction")
public class DsVechicleproductionController extends BaseController
{
    private String prefix = "system/vechicleproduction";

    @Autowired
    private IDsVechicleproductionService dsVechicleproductionService;

    @RequiresPermissions("system:vechicleproduction:view")
    @GetMapping()
    public String vechicleproduction()
    {
        return prefix + "/vechicleproduction";
    }

    /**
     * 查询生产信息列表
     */
    @RequiresPermissions("system:vechicleproduction:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsVechicleproduction dsVechicleproduction)
    {
        startPage();
        List<DsVechicleproduction> list = dsVechicleproductionService.selectDsVechicleproductionList(dsVechicleproduction);
        return getDataTable(list);
    }

    /**
     * 导出生产信息列表
     */
    @RequiresPermissions("system:vechicleproduction:export")
    @Log(title = "生产信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsVechicleproduction dsVechicleproduction)
    {
        List<DsVechicleproduction> list = dsVechicleproductionService.selectDsVechicleproductionList(dsVechicleproduction);
        ExcelUtil<DsVechicleproduction> util = new ExcelUtil<DsVechicleproduction>(DsVechicleproduction.class);
        return util.exportExcel(list, "vechicleproduction");
    }

    /**
     * 新增生产信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存生产信息
     */
    @RequiresPermissions("system:vechicleproduction:add")
    @Log(title = "生产信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsVechicleproduction dsVechicleproduction)
    {
        return toAjax(dsVechicleproductionService.insertDsVechicleproduction(dsVechicleproduction));
    }

    /**
     * 修改生产信息
     */
    @GetMapping("/edit/{vechicleproductionid}")
    public String edit(@PathVariable("vechicleproductionid") Long vechicleproductionid, ModelMap mmap)
    {
        DsVechicleproduction dsVechicleproduction = dsVechicleproductionService.selectDsVechicleproductionById(vechicleproductionid);
        mmap.put("dsVechicleproduction", dsVechicleproduction);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产信息
     */
    @RequiresPermissions("system:vechicleproduction:edit")
    @Log(title = "生产信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsVechicleproduction dsVechicleproduction)
    {
        return toAjax(dsVechicleproductionService.updateDsVechicleproduction(dsVechicleproduction));
    }

    /**
     * 删除生产信息
     */
    @RequiresPermissions("system:vechicleproduction:remove")
    @Log(title = "生产信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsVechicleproductionService.deleteDsVechicleproductionByIds(ids));
    }
}
