package com.ruoyi.project.system.newdata.controller;

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
import com.ruoyi.project.system.newdata.domain.Newdata;
import com.ruoyi.project.system.newdata.service.INewdataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 最新数据Controller
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Controller
@RequestMapping("/system/newdata")
public class NewdataController extends BaseController
{
    private String prefix = "system/newdata";

    @Autowired
    private INewdataService newdataService;

    @RequiresPermissions("system:newdata:view")
    @GetMapping()
    public String newdata()
    {
        return prefix + "/newdata";
    }

    /**
     * 查询最新数据列表
     */
    @RequiresPermissions("system:newdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Newdata newdata)
    {
        startPage();
        List<Newdata> list = newdataService.selectNewdataList(newdata);
        return getDataTable(list);
    }

    /**
     * 导出最新数据列表
     */
    @RequiresPermissions("system:newdata:export")
    @Log(title = "最新数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Newdata newdata)
    {
        List<Newdata> list = newdataService.selectNewdataList(newdata);
        ExcelUtil<Newdata> util = new ExcelUtil<Newdata>(Newdata.class);
        return util.exportExcel(list, "newdata");
    }

    /**
     * 新增最新数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存最新数据
     */
    @RequiresPermissions("system:newdata:add")
    @Log(title = "最新数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Newdata newdata)
    {
        return toAjax(newdataService.insertNewdata(newdata));
    }

    /**
     * 修改最新数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Newdata newdata = newdataService.selectNewdataById(id);
        mmap.put("newdata", newdata);
        return prefix + "/edit";
    }

    /**
     * 修改保存最新数据
     */
    @RequiresPermissions("system:newdata:edit")
    @Log(title = "最新数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Newdata newdata)
    {
        return toAjax(newdataService.updateNewdata(newdata));
    }

    /**
     * 删除最新数据
     */
    @RequiresPermissions("system:newdata:remove")
    @Log(title = "最新数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newdataService.deleteNewdataByIds(ids));
    }
}
