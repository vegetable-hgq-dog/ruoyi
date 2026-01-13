package com.ruoyi.project.system.designermkiinfo.controller;

import java.util.List;

import com.ruoyi.project.system.designerinfo.service.IDesignerinfoService;
import com.ruoyi.project.system.mkiinfo.service.IMkiinfoService;
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
import com.ruoyi.project.system.designermkiinfo.domain.Designermkiinfo;
import com.ruoyi.project.system.designermkiinfo.service.IDesignermkiinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 研发人员知识交互信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/designermkiinfo")
public class DesignermkiinfoController extends BaseController
{
    private String prefix = "system/designermkiinfo";

    @Autowired
    private IDesignermkiinfoService designermkiinfoService;
    @Autowired
    private IMkiinfoService mkiinfoService;
    @Autowired
    private IDesignerinfoService designerinfoService;

    @RequiresPermissions("system:designermkiinfo:view")
    @GetMapping()
    public String designermkiinfo()
    {
        return prefix + "/designermkiinfo";
    }

    /**
     * 查询研发人员知识交互信息列表
     */
    @RequiresPermissions("system:designermkiinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Designermkiinfo designermkiinfo)
    {
        startPage();
        List<Designermkiinfo> list = designermkiinfoService.selectDesignermkiinfoList(designermkiinfo);
        return getDataTable(list);
    }

    /**
     * 导出研发人员知识交互信息列表
     */
    @RequiresPermissions("system:designermkiinfo:export")
    @Log(title = "研发人员知识交互信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Designermkiinfo designermkiinfo)
    {
        List<Designermkiinfo> list = designermkiinfoService.selectDesignermkiinfoList(designermkiinfo);
        ExcelUtil<Designermkiinfo> util = new ExcelUtil<Designermkiinfo>(Designermkiinfo.class);
        return util.exportExcel(list, "designermkiinfo");
    }

    /**
     * 新增研发人员知识交互信息
     */
    @GetMapping("/add")
    public String add(ModelMap info)
    {
        info.put("mki",mkiinfoService.selectMkiinfo());
        info.put("designer",designerinfoService.selectDesignerinfo());
        return prefix + "/add";
    }

    /**
     * 新增保存研发人员知识交互信息
     */
    @RequiresPermissions("system:designermkiinfo:add")
    @Log(title = "研发人员知识交互信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Designermkiinfo designermkiinfo)
    {
        return toAjax(designermkiinfoService.insertDesignermkiinfo(designermkiinfo));
    }

    /**
     * 修改研发人员知识交互信息
     */
    @GetMapping("/edit/{mkiid}")
    public String edit(@PathVariable("mkiid") Long mkiid, ModelMap mmap)
    {
        Designermkiinfo designermkiinfo = designermkiinfoService.selectDesignermkiinfoById(mkiid);
        mmap.put("designermkiinfo", designermkiinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存研发人员知识交互信息
     */
    @RequiresPermissions("system:designermkiinfo:edit")
    @Log(title = "研发人员知识交互信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Designermkiinfo designermkiinfo)
    {
        return toAjax(designermkiinfoService.updateDesignermkiinfo(designermkiinfo));
    }

    /**
     * 删除研发人员知识交互信息
     */
    @RequiresPermissions("system:designermkiinfo:remove")
    @Log(title = "研发人员知识交互信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(designermkiinfoService.deleteDesignermkiinfoByIds(ids));
    }
}
