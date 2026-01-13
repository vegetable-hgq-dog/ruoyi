package com.ruoyi.project.system.feature.controller;

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
import com.ruoyi.project.system.feature.domain.DsFeature;
import com.ruoyi.project.system.feature.service.IDsFeatureService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 特征信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/feature")
public class DsFeatureController extends BaseController
{
    private String prefix = "system/feature";

    @Autowired
    private IDsFeatureService dsFeatureService;

    @RequiresPermissions("system:feature:view")
    @GetMapping()
    public String feature()
    {
        return prefix + "/feature";
    }

    /**
     * 查询特征信息列表
     */
    @RequiresPermissions("system:feature:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsFeature dsFeature)
    {
        startPage();
        List<DsFeature> list = dsFeatureService.selectDsFeatureList(dsFeature);
        return getDataTable(list);
    }

    /**
     * 导出特征信息列表
     */
    @RequiresPermissions("system:feature:export")
    @Log(title = "特征信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsFeature dsFeature)
    {
        List<DsFeature> list = dsFeatureService.selectDsFeatureList(dsFeature);
        ExcelUtil<DsFeature> util = new ExcelUtil<DsFeature>(DsFeature.class);
        return util.exportExcel(list, "feature");
    }

    /**
     * 新增特征信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存特征信息
     */
    @RequiresPermissions("system:feature:add")
    @Log(title = "特征信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsFeature dsFeature)
    {
        return toAjax(dsFeatureService.insertDsFeature(dsFeature));
    }

    /**
     * 修改特征信息
     */
    @GetMapping("/edit/{featureid}")
    public String edit(@PathVariable("featureid") Long featureid, ModelMap mmap)
    {
        DsFeature dsFeature = dsFeatureService.selectDsFeatureById(featureid);
        mmap.put("dsFeature", dsFeature);
        return prefix + "/edit";
    }

    /**
     * 修改保存特征信息
     */
    @RequiresPermissions("system:feature:edit")
    @Log(title = "特征信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsFeature dsFeature)
    {
        return toAjax(dsFeatureService.updateDsFeature(dsFeature));
    }

    /**
     * 删除特征信息
     */
    @RequiresPermissions("system:feature:remove")
    @Log(title = "特征信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsFeatureService.deleteDsFeatureByIds(ids));
    }
}
