package com.ruoyi.project.manufacture.weldpara.controller;

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
import com.ruoyi.project.manufacture.weldpara.domain.DsWeldingPara;
import com.ruoyi.project.manufacture.weldpara.service.IDsWeldingParaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * weld_paraController
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Controller
@RequestMapping("/manufacture/weldpara")
public class DsWeldingParaController extends BaseController
{
    private String prefix = "manufacture/weldpara";

    @Autowired
    private IDsWeldingParaService dsWeldingParaService;

    @RequiresPermissions("manufacture:weldpara:view")
    @GetMapping()
    public String weldpara()
    {
        return prefix + "/weldpara";
    }

    /**
     * 查询weld_para列表
     */
    @RequiresPermissions("manufacture:weldpara:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DsWeldingPara dsWeldingPara)
    {
        startPage();
        List<DsWeldingPara> list = dsWeldingParaService.selectDsWeldingParaList(dsWeldingPara);
        return getDataTable(list);
    }

    /**
     * 导出weld_para列表
     */
    @RequiresPermissions("manufacture:weldpara:export")
    @Log(title = "weld_para", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsWeldingPara dsWeldingPara)
    {
        List<DsWeldingPara> list = dsWeldingParaService.selectDsWeldingParaList(dsWeldingPara);
        ExcelUtil<DsWeldingPara> util = new ExcelUtil<DsWeldingPara>(DsWeldingPara.class);
        return util.exportExcel(list, "weldpara");
    }

    /**
     * 新增weld_para
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存weld_para
     */
    @RequiresPermissions("manufacture:weldpara:add")
    @Log(title = "weld_para", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsWeldingPara dsWeldingPara)
    {
        return toAjax(dsWeldingParaService.insertDsWeldingPara(dsWeldingPara));
    }

    /**
     * 修改weld_para
     */
    @GetMapping("/edit/{autoId}")
    public String edit(@PathVariable("autoId") Long autoId, ModelMap mmap)
    {
        DsWeldingPara dsWeldingPara = dsWeldingParaService.selectDsWeldingParaById(autoId);
        mmap.put("dsWeldingPara", dsWeldingPara);
        return prefix + "/edit";
    }

    /**
     * 修改保存weld_para
     */
    @RequiresPermissions("manufacture:weldpara:edit")
    @Log(title = "weld_para", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsWeldingPara dsWeldingPara)
    {
        return toAjax(dsWeldingParaService.updateDsWeldingPara(dsWeldingPara));
    }

    /**
     * 删除weld_para
     */
    @RequiresPermissions("manufacture:weldpara:remove")
    @Log(title = "weld_para", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dsWeldingParaService.deleteDsWeldingParaByIds(ids));
    }
}
