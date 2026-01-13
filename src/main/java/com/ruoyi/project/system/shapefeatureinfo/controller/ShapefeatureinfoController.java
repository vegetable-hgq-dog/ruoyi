package com.ruoyi.project.system.shapefeatureinfo.controller;

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
import com.ruoyi.project.system.shapefeatureinfo.domain.Shapefeatureinfo;
import com.ruoyi.project.system.shapefeatureinfo.service.IShapefeatureinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 设计特征信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/shapefeatureinfo")
public class ShapefeatureinfoController extends BaseController
{
    private String prefix = "system/shapefeatureinfo";

    @Autowired
    private IShapefeatureinfoService shapefeatureinfoService;

    @RequiresPermissions("system:shapefeatureinfo:view")
    @GetMapping()
    public String shapefeatureinfo()
    {
        return prefix + "/shapefeatureinfo";
    }

    /**
     * 查询设计特征信息列表
     */
    @RequiresPermissions("system:shapefeatureinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Shapefeatureinfo shapefeatureinfo)
    {
        startPage();
        List<Shapefeatureinfo> list = shapefeatureinfoService.selectShapefeatureinfoList(shapefeatureinfo);
        return getDataTable(list);
    }

    /**
     * 导出设计特征信息列表
     */
    @RequiresPermissions("system:shapefeatureinfo:export")
    @Log(title = "设计特征信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shapefeatureinfo shapefeatureinfo)
    {
        List<Shapefeatureinfo> list = shapefeatureinfoService.selectShapefeatureinfoList(shapefeatureinfo);
        ExcelUtil<Shapefeatureinfo> util = new ExcelUtil<Shapefeatureinfo>(Shapefeatureinfo.class);
        return util.exportExcel(list, "shapefeatureinfo");
    }

    /**
     * 新增设计特征信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设计特征信息
     */
    @RequiresPermissions("system:shapefeatureinfo:add")
    @Log(title = "设计特征信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Shapefeatureinfo shapefeatureinfo)
    {
        return toAjax(shapefeatureinfoService.insertShapefeatureinfo(shapefeatureinfo));
    }

    /**
     * 修改设计特征信息
     */
    @GetMapping("/edit/{shapefeatureid}")
    public String edit(@PathVariable("shapefeatureid") Long shapefeatureid, ModelMap mmap)
    {
        Shapefeatureinfo shapefeatureinfo = shapefeatureinfoService.selectShapefeatureinfoById(shapefeatureid);
        mmap.put("shapefeatureinfo", shapefeatureinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设计特征信息
     */
    @RequiresPermissions("system:shapefeatureinfo:edit")
    @Log(title = "设计特征信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Shapefeatureinfo shapefeatureinfo)
    {
        return toAjax(shapefeatureinfoService.updateShapefeatureinfo(shapefeatureinfo));
    }

    /**
     * 删除设计特征信息
     */
    @RequiresPermissions("system:shapefeatureinfo:remove")
    @Log(title = "设计特征信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shapefeatureinfoService.deleteShapefeatureinfoByIds(ids));
    }
}
