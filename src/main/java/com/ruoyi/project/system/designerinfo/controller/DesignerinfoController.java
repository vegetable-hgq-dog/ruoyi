package com.ruoyi.project.system.designerinfo.controller;

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
import com.ruoyi.project.system.designerinfo.domain.Designerinfo;
import com.ruoyi.project.system.designerinfo.service.IDesignerinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 研发人员信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/designerinfo")
public class DesignerinfoController extends BaseController
{
    private String prefix = "system/designerinfo";

    @Autowired
    private IDesignerinfoService designerinfoService;

    @RequiresPermissions("system:designerinfo:view")
    @GetMapping()
    public String designerinfo()
    {
        return prefix + "/designerinfo";
    }

    /**
     * 查询研发人员信息列表
     */
    @RequiresPermissions("system:designerinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Designerinfo designerinfo)
    {
        startPage();
        List<Designerinfo> list = designerinfoService.selectDesignerinfoList(designerinfo);
        return getDataTable(list);
    }

    /**
     * 导出研发人员信息列表
     */
    @RequiresPermissions("system:designerinfo:export")
    @Log(title = "研发人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Designerinfo designerinfo)
    {
        List<Designerinfo> list = designerinfoService.selectDesignerinfoList(designerinfo);
        ExcelUtil<Designerinfo> util = new ExcelUtil<Designerinfo>(Designerinfo.class);
        return util.exportExcel(list, "designerinfo");
    }

    /**
     * 新增研发人员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存研发人员信息
     */
    @RequiresPermissions("system:designerinfo:add")
    @Log(title = "研发人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Designerinfo designerinfo)
    {
        return toAjax(designerinfoService.insertDesignerinfo(designerinfo));
    }

    /**
     * 修改研发人员信息
     */
    @GetMapping("/edit/{designerid}")
    public String edit(@PathVariable("designerid") Long designerid, ModelMap mmap)
    {
        Designerinfo designerinfo = designerinfoService.selectDesignerinfoById(designerid);
        mmap.put("designerinfo", designerinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存研发人员信息
     */
    @RequiresPermissions("system:designerinfo:edit")
    @Log(title = "研发人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Designerinfo designerinfo)
    {
        return toAjax(designerinfoService.updateDesignerinfo(designerinfo));
    }

    /**
     * 删除研发人员信息
     */
    @RequiresPermissions("system:designerinfo:remove")
    @Log(title = "研发人员信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(designerinfoService.deleteDesignerinfoByIds(ids));
    }
}
