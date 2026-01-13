package com.ruoyi.project.system.partinfo.controller;

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
import com.ruoyi.project.system.partinfo.domain.Partinfo;
import com.ruoyi.project.system.partinfo.service.IPartinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 零部件信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/partinfo")
public class PartinfoController extends BaseController
{
    private String prefix = "system/partinfo";

    @Autowired
    private IPartinfoService partinfoService;

    @RequiresPermissions("system:partinfo:view")
    @GetMapping()
    public String partinfo()
    {
        return prefix + "/partinfo";
    }

    /**
     * 查询零部件信息列表
     */
    @RequiresPermissions("system:partinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Partinfo partinfo)
    {
        startPage();
        List<Partinfo> list = partinfoService.selectPartinfoList(partinfo);
        return getDataTable(list);
    }

    /**
     * 导出零部件信息列表
     */
    @RequiresPermissions("system:partinfo:export")
    @Log(title = "零部件信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Partinfo partinfo)
    {
        List<Partinfo> list = partinfoService.selectPartinfoList(partinfo);
        ExcelUtil<Partinfo> util = new ExcelUtil<Partinfo>(Partinfo.class);
        return util.exportExcel(list, "partinfo");
    }

    /**
     * 新增零部件信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存零部件信息
     */
    @RequiresPermissions("system:partinfo:add")
    @Log(title = "零部件信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Partinfo partinfo)
    {
        return toAjax(partinfoService.insertPartinfo(partinfo));
    }

    /**
     * 修改零部件信息
     */
    @GetMapping("/edit/{partid}")
    public String edit(@PathVariable("partid") Long partid, ModelMap mmap)
    {
        Partinfo partinfo = partinfoService.selectPartinfoById(partid);
        mmap.put("partinfo", partinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存零部件信息
     */
    @RequiresPermissions("system:partinfo:edit")
    @Log(title = "零部件信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Partinfo partinfo)
    {
        return toAjax(partinfoService.updatePartinfo(partinfo));
    }

    /**
     * 删除零部件信息
     */
    @RequiresPermissions("system:partinfo:remove")
    @Log(title = "零部件信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(partinfoService.deletePartinfoByIds(ids));
    }
}
