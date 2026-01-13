package com.ruoyi.project.system.firminfo.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.firminfo.domain.Firminfo;
import com.ruoyi.project.system.firminfo.service.IFirminfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 供应链企业信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
@Controller
@RequestMapping("/system/firminfo")
public class FirminfoController extends BaseController
{
    private String prefix = "system/firminfo";

    @Autowired
    private IFirminfoService firminfoService;

    @RequiresPermissions("system:firminfo:view")
    @GetMapping()
    public String firminfo()
    {
        return prefix + "/firminfo";
    }

    /**
     * 查询供应链企业信息列表
     */
    @RequiresPermissions("system:firminfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Firminfo firminfo)
    {
        startPage();
        List<Firminfo> list = firminfoService.selectFirminfoList(firminfo);
        return getDataTable(list);
    }

    /**
     * 导出供应链企业信息列表
     */
    @RequiresPermissions("system:firminfo:export")
    @Log(title = "供应链企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Firminfo firminfo)
    {
        List<Firminfo> list = firminfoService.selectFirminfoList(firminfo);
        ExcelUtil<Firminfo> util = new ExcelUtil<Firminfo>(Firminfo.class);
        return util.exportExcel(list, "firminfo");
    }

    /**
     * 新增供应链企业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应链企业信息
     */
    @RequiresPermissions("system:firminfo:add")
    @Log(title = "供应链企业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Firminfo firminfo)
    {
        return toAjax(firminfoService.insertFirminfo(firminfo));
    }

    /**
     * 修改供应链企业信息
     */
    @GetMapping("/edit/{firmId}")
    public String edit(@PathVariable("firmId") Long firmId, ModelMap mmap)
    {
        Firminfo firminfo = firminfoService.selectFirminfoById(firmId);
        mmap.put("firminfo", firminfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应链企业信息
     */
    @RequiresPermissions("system:firminfo:edit")
    @Log(title = "供应链企业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Firminfo firminfo)
    {
        return toAjax(firminfoService.updateFirminfo(firminfo));
    }

    /**
     * 删除供应链企业信息
     */
    @RequiresPermissions("system:firminfo:remove")
    @Log(title = "供应链企业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(firminfoService.deleteFirminfoByIds(ids));
    }

    @RequestMapping("/getFirmInfos")
    @ResponseBody
    public List getFirmInfos(){
        return firminfoService.selectFirmInfos();
    }

    @RequestMapping("/getLayers")
    @ResponseBody
    public List getLayers(){
        return firminfoService.getLayers();
    }

    //测试后端数据传入前端
//    @RequestMapping("/backToFront")
//    @ResponseBody
//    public int testTransfer(@RequestParam("ar[]")  List ar,@RequestParam("ar2[]")  List ar2){
//        return ar.size() + ar2.size();
//
//};


}
