package com.ruoyi.project.system.processing.controller;

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
import com.ruoyi.project.system.processing.domain.DsProcessing;
import com.ruoyi.project.system.processing.service.IDsProcessingService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工艺信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/processing")
public class DsProcessingController extends BaseController
{
    private String prefix = "system/processing";

    @Autowired
    private IDsProcessingService dsProcessingService;

    @RequiresPermissions("system:processing:view")
    @GetMapping()
    public String processing()
    {
        return prefix + "/processing";
    }

    /**
     * 查询工艺信息列表
     */
    @RequiresPermissions("system:processing:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsProcessing dsProcessing)
    {
        startPage();
        List<DsProcessing> list = dsProcessingService.selectDsProcessingList(dsProcessing);
        return getDataTable(list);
    }

    /**
     * 导出工艺信息列表
     */
    @RequiresPermissions("system:processing:export")
    @Log(title = "工艺信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsProcessing dsProcessing)
    {
        List<DsProcessing> list = dsProcessingService.selectDsProcessingList(dsProcessing);
        ExcelUtil<DsProcessing> util = new ExcelUtil<DsProcessing>(DsProcessing.class);
        return util.exportExcel(list, "processing");
    }

    /**
     * 新增工艺信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工艺信息
     */
    @RequiresPermissions("system:processing:add")
    @Log(title = "工艺信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsProcessing dsProcessing)
    {
        return toAjax(dsProcessingService.insertDsProcessing(dsProcessing));
    }

    /**
     * 修改工艺信息
     */
    @GetMapping("/edit/{processingid}")
    public String edit(@PathVariable("processingid") Long processingid, ModelMap mmap)
    {
        DsProcessing dsProcessing = dsProcessingService.selectDsProcessingById(processingid);
        mmap.put("dsProcessing", dsProcessing);
        return prefix + "/edit";
    }

    /**
     * 修改保存工艺信息
     */
    @RequiresPermissions("system:processing:edit")
    @Log(title = "工艺信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsProcessing dsProcessing)
    {
        return toAjax(dsProcessingService.updateDsProcessing(dsProcessing));
    }

    /**
     * 删除工艺信息
     */
    @RequiresPermissions("system:processing:remove")
    @Log(title = "工艺信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsProcessingService.deleteDsProcessingByIds(ids));
    }
}
