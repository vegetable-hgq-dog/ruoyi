package com.ruoyi.project.system.workshop.controller;

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
import com.ruoyi.project.system.workshop.domain.DsWorkshop;
import com.ruoyi.project.system.workshop.service.IDsWorkshopService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 车间信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/system/workshop")
public class DsWorkshopController extends BaseController
{
    private String prefix = "system/workshop";

    @Autowired
    private IDsWorkshopService dsWorkshopService;

    @RequiresPermissions("system:workshop:view")
    @GetMapping()
    public String workshop()
    {
        return prefix + "/workshop";
    }

    /**
     * 查询车间信息列表
     */
    @RequiresPermissions("system:workshop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsWorkshop dsWorkshop)
    {
        startPage();
        List<DsWorkshop> list = dsWorkshopService.selectDsWorkshopList(dsWorkshop);
        return getDataTable(list);
    }

    /**
     * 导出车间信息列表
     */
    @RequiresPermissions("system:workshop:export")
    @Log(title = "车间信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsWorkshop dsWorkshop)
    {
        List<DsWorkshop> list = dsWorkshopService.selectDsWorkshopList(dsWorkshop);
        ExcelUtil<DsWorkshop> util = new ExcelUtil<DsWorkshop>(DsWorkshop.class);
        return util.exportExcel(list, "workshop");
    }

    /**
     * 新增车间信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车间信息
     */
    @RequiresPermissions("system:workshop:add")
    @Log(title = "车间信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsWorkshop dsWorkshop)
    {
        return toAjax(dsWorkshopService.insertDsWorkshop(dsWorkshop));
    }

    /**
     * 修改车间信息
     */
    @GetMapping("/edit/{workshopid}")
    public String edit(@PathVariable("workshopid") Long workshopid, ModelMap mmap)
    {
        DsWorkshop dsWorkshop = dsWorkshopService.selectDsWorkshopById(workshopid);
        mmap.put("dsWorkshop", dsWorkshop);
        return prefix + "/edit";
    }

    /**
     * 修改保存车间信息
     */
    @RequiresPermissions("system:workshop:edit")
    @Log(title = "车间信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsWorkshop dsWorkshop)
    {
        return toAjax(dsWorkshopService.updateDsWorkshop(dsWorkshop));
    }

    /**
     * 删除车间信息
     */
    @RequiresPermissions("system:workshop:remove")
    @Log(title = "车间信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsWorkshopService.deleteDsWorkshopByIds(ids));
    }
}
