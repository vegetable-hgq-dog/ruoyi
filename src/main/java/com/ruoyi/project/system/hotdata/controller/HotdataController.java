package com.ruoyi.project.system.hotdata.controller;

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
import com.ruoyi.project.system.hotdata.domain.Hotdata;
import com.ruoyi.project.system.hotdata.service.IHotdataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 热门数据Controller
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Controller
@RequestMapping("/system/hotdata")
public class HotdataController extends BaseController
{
    private String prefix = "system/hotdata";

    @Autowired
    private IHotdataService hotdataService;

    @RequiresPermissions("system:hotdata:view")
    @GetMapping()
    public String hotdata()
    {
        return prefix + "/hotdata";
    }

    /**
     * 查询热门数据列表
     */
    @RequiresPermissions("system:hotdata:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Hotdata hotdata)
    {
        startPage();
        List<Hotdata> list = hotdataService.selectHotdataList(hotdata);
        return getDataTable(list);
    }

    /**
     * 导出热门数据列表
     */
    @RequiresPermissions("system:hotdata:export")
    @Log(title = "热门数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Hotdata hotdata)
    {
        List<Hotdata> list = hotdataService.selectHotdataList(hotdata);
        ExcelUtil<Hotdata> util = new ExcelUtil<Hotdata>(Hotdata.class);
        return util.exportExcel(list, "hotdata");
    }

    /**
     * 新增热门数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存热门数据
     */
    @RequiresPermissions("system:hotdata:add")
    @Log(title = "热门数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Hotdata hotdata)
    {
        return toAjax(hotdataService.insertHotdata(hotdata));
    }

    /**
     * 修改热门数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Hotdata hotdata = hotdataService.selectHotdataById(id);
        mmap.put("hotdata", hotdata);
        return prefix + "/edit";
    }

    /**
     * 修改保存热门数据
     */
    @RequiresPermissions("system:hotdata:edit")
    @Log(title = "热门数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Hotdata hotdata)
    {
        return toAjax(hotdataService.updateHotdata(hotdata));
    }

    /**
     * 删除热门数据
     */
    @RequiresPermissions("system:hotdata:remove")
    @Log(title = "热门数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hotdataService.deleteHotdataByIds(ids));
    }
}
