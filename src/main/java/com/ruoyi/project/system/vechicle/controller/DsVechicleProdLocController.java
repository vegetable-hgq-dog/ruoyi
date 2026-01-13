package com.ruoyi.project.system.vechicle.controller;

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
import com.ruoyi.project.system.vechicle.domain.DsVechicleProdLoc;
import com.ruoyi.project.system.vechicle.service.IDsVechicleProdLocService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 生产信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Controller
@RequestMapping("/system/vechicle")
public class DsVechicleProdLocController extends BaseController
{
    private String prefix = "system/vechicle";

    @Autowired
    private IDsVechicleProdLocService dsVechicleProdLocService;

    @RequiresPermissions("system:vechicle:view")
    @GetMapping()
    public String vechicle()
    {
        return prefix + "/vechicle";
    }

    /**
     * 查询生产信息列表
     */
    @RequiresPermissions("system:vechicle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsVechicleProdLoc dsVechicleProdLoc)
    {
        startPage();
        List<DsVechicleProdLoc> list = dsVechicleProdLocService.selectDsVechicleProdLocList(dsVechicleProdLoc);
        return getDataTable(list);
    }

    /**
     * 导出生产信息列表
     */
    @RequiresPermissions("system:vechicle:export")
    @Log(title = "生产信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsVechicleProdLoc dsVechicleProdLoc)
    {
        List<DsVechicleProdLoc> list = dsVechicleProdLocService.selectDsVechicleProdLocList(dsVechicleProdLoc);
        ExcelUtil<DsVechicleProdLoc> util = new ExcelUtil<DsVechicleProdLoc>(DsVechicleProdLoc.class);
        return util.exportExcel(list, "vechicle");
    }

    /**
     * 新增生产信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存生产信息
     */
    @RequiresPermissions("system:vechicle:add")
    @Log(title = "生产信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsVechicleProdLoc dsVechicleProdLoc)
    {
        return toAjax(dsVechicleProdLocService.insertDsVechicleProdLoc(dsVechicleProdLoc));
    }

    /**
     * 修改生产信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DsVechicleProdLoc dsVechicleProdLoc = dsVechicleProdLocService.selectDsVechicleProdLocById(id);
        mmap.put("dsVechicleProdLoc", dsVechicleProdLoc);
        return prefix + "/edit";
    }

    /**
     * 修改保存生产信息
     */
    @RequiresPermissions("system:vechicle:edit")
    @Log(title = "生产信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsVechicleProdLoc dsVechicleProdLoc)
    {
        return toAjax(dsVechicleProdLocService.updateDsVechicleProdLoc(dsVechicleProdLoc));
    }

    /**
     * 删除生产信息
     */
    @RequiresPermissions("system:vechicle:remove")
    @Log(title = "生产信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsVechicleProdLocService.deleteDsVechicleProdLocByIds(ids));
    }
}
