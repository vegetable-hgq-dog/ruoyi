package com.ruoyi.project.system.materialinfo.controller;

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
import com.ruoyi.project.system.materialinfo.domain.Materialinfo;
import com.ruoyi.project.system.materialinfo.service.IMaterialinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 材料信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/materialinfo")
public class MaterialinfoController extends BaseController
{
    private String prefix = "system/materialinfo";

    @Autowired
    private IMaterialinfoService materialinfoService;

    @RequiresPermissions("system:materialinfo:view")
    @GetMapping()
    public String materialinfo()
    {
        return prefix + "/materialinfo";
    }

    /**
     * 查询材料信息列表
     */
    @RequiresPermissions("system:materialinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Materialinfo materialinfo)
    {
        startPage();
        List<Materialinfo> list = materialinfoService.selectMaterialinfoList(materialinfo);
        return getDataTable(list);
    }

    /**
     * 导出材料信息列表
     */
    @RequiresPermissions("system:materialinfo:export")
    @Log(title = "材料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Materialinfo materialinfo)
    {
        List<Materialinfo> list = materialinfoService.selectMaterialinfoList(materialinfo);
        ExcelUtil<Materialinfo> util = new ExcelUtil<Materialinfo>(Materialinfo.class);
        return util.exportExcel(list, "materialinfo");
    }

    /**
     * 新增材料信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料信息
     */
    @RequiresPermissions("system:materialinfo:add")
    @Log(title = "材料信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Materialinfo materialinfo)
    {
        return toAjax(materialinfoService.insertMaterialinfo(materialinfo));
    }

    /**
     * 修改材料信息
     */
    @GetMapping("/edit/{materialid}")
    public String edit(@PathVariable("materialid") Long materialid, ModelMap mmap)
    {
        Materialinfo materialinfo = materialinfoService.selectMaterialinfoById(materialid);
        mmap.put("materialinfo", materialinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料信息
     */
    @RequiresPermissions("system:materialinfo:edit")
    @Log(title = "材料信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Materialinfo materialinfo)
    {
        return toAjax(materialinfoService.updateMaterialinfo(materialinfo));
    }

    /**
     * 删除材料信息
     */
    @RequiresPermissions("system:materialinfo:remove")
    @Log(title = "材料信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(materialinfoService.deleteMaterialinfoByIds(ids));
    }
}
