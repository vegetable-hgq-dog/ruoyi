package com.ruoyi.project.system.ktypeinfo.controller;

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
import com.ruoyi.project.system.ktypeinfo.domain.Ktypeinfo;
import com.ruoyi.project.system.ktypeinfo.service.IKtypeinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 知识类型Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/ktypeinfo")
public class KtypeinfoController extends BaseController
{
    private String prefix = "system/ktypeinfo";

    @Autowired
    private IKtypeinfoService ktypeinfoService;

    @RequiresPermissions("system:ktypeinfo:view")
    @GetMapping()
    public String ktypeinfo()
    {
        return prefix + "/ktypeinfo";
    }

    /**
     * 查询知识类型列表
     */
    @RequiresPermissions("system:ktypeinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Ktypeinfo ktypeinfo)
    {
        startPage();
        List<Ktypeinfo> list = ktypeinfoService.selectKtypeinfoList(ktypeinfo);
        return getDataTable(list);
    }

    /**
     * 导出知识类型列表
     */
    @RequiresPermissions("system:ktypeinfo:export")
    @Log(title = "知识类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Ktypeinfo ktypeinfo)
    {
        List<Ktypeinfo> list = ktypeinfoService.selectKtypeinfoList(ktypeinfo);
        ExcelUtil<Ktypeinfo> util = new ExcelUtil<Ktypeinfo>(Ktypeinfo.class);
        return util.exportExcel(list, "ktypeinfo");
    }

    /**
     * 新增知识类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存知识类型
     */
    @RequiresPermissions("system:ktypeinfo:add")
    @Log(title = "知识类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Ktypeinfo ktypeinfo)
    {
        return toAjax(ktypeinfoService.insertKtypeinfo(ktypeinfo));
    }

    /**
     * 修改知识类型
     */
    @GetMapping("/edit/{ktypeid}")
    public String edit(@PathVariable("ktypeid") Long ktypeid, ModelMap mmap)
    {
        Ktypeinfo ktypeinfo = ktypeinfoService.selectKtypeinfoById(ktypeid);
        mmap.put("ktypeinfo", ktypeinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存知识类型
     */
    @RequiresPermissions("system:ktypeinfo:edit")
    @Log(title = "知识类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Ktypeinfo ktypeinfo)
    {
        return toAjax(ktypeinfoService.updateKtypeinfo(ktypeinfo));
    }

    /**
     * 删除知识类型
     */
    @RequiresPermissions("system:ktypeinfo:remove")
    @Log(title = "知识类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ktypeinfoService.deleteKtypeinfoByIds(ids));
    }
}
