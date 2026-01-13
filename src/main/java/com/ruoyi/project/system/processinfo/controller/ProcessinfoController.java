package com.ruoyi.project.system.processinfo.controller;

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
import com.ruoyi.project.system.processinfo.domain.Processinfo;
import com.ruoyi.project.system.processinfo.service.IProcessinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 工艺信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/processinfo")
public class ProcessinfoController extends BaseController
{
    private String prefix = "system/processinfo";

    @Autowired
    private IProcessinfoService processinfoService;

    @RequiresPermissions("system:processinfo:view")
    @GetMapping()
    public String processinfo()
    {
        return prefix + "/processinfo";
    }

    /**
     * 查询工艺信息列表
     */
    @RequiresPermissions("system:processinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Processinfo processinfo)
    {
        startPage();
        List<Processinfo> list = processinfoService.selectProcessinfoList(processinfo);
        return getDataTable(list);
    }

    /**
     * 导出工艺信息列表
     */
    @RequiresPermissions("system:processinfo:export")
    @Log(title = "工艺信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Processinfo processinfo)
    {
        List<Processinfo> list = processinfoService.selectProcessinfoList(processinfo);
        ExcelUtil<Processinfo> util = new ExcelUtil<Processinfo>(Processinfo.class);
        return util.exportExcel(list, "processinfo");
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
    @RequiresPermissions("system:processinfo:add")
    @Log(title = "工艺信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Processinfo processinfo)
    {
        return toAjax(processinfoService.insertProcessinfo(processinfo));
    }

    /**
     * 修改工艺信息
     */
    @GetMapping("/edit/{processid}")
    public String edit(@PathVariable("processid") Long processid, ModelMap mmap)
    {
        Processinfo processinfo = processinfoService.selectProcessinfoById(processid);
        mmap.put("processinfo", processinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存工艺信息
     */
    @RequiresPermissions("system:processinfo:edit")
    @Log(title = "工艺信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Processinfo processinfo)
    {
        return toAjax(processinfoService.updateProcessinfo(processinfo));
    }

    /**
     * 删除工艺信息
     */
    @RequiresPermissions("system:processinfo:remove")
    @Log(title = "工艺信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(processinfoService.deleteProcessinfoByIds(ids));
    }
}
