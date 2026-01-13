package com.ruoyi.project.system.fileinputoutput.controller;

import java.io.IOException;
import java.util.List;


import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.fileinputoutput.domain.Fileinputoutput;
import com.ruoyi.project.system.fileinputoutput.service.IFileinputoutputService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件导入导出测试Controller
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
@Controller
@RequestMapping("/system/fileinputoutput")
public class FileinputoutputController extends BaseController
{
    private String prefix = "system/fileinputoutput";

    @Autowired
    private IFileinputoutputService fileinputoutputService;

    @RequiresPermissions("system:fileinputoutput:view")
    @GetMapping()
    public String fileinputoutput()
    {
        return prefix + "/fileinputoutput";
    }

    /**
     * 查询文件导入导出测试列表
     */
    @RequiresPermissions("system:fileinputoutput:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fileinputoutput fileinputoutput)
    {
        startPage();
        List<Fileinputoutput> list = fileinputoutputService.selectFileinputoutputList(fileinputoutput);
        return getDataTable(list);
    }

    /**
     * 导出文件导入导出测试列表
     */
    @RequiresPermissions("system:fileinputoutput:export")
    @Log(title = "文件导入导出测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fileinputoutput fileinputoutput)
    {
        List<Fileinputoutput> list = fileinputoutputService.selectFileinputoutputList(fileinputoutput);
        ExcelUtil<Fileinputoutput> util = new ExcelUtil<Fileinputoutput>(Fileinputoutput.class);
        return util.exportExcel(list, "fileinputoutput");
    }

    /**
     * 新增文件导入导出测试
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文件导入导出测试
     */
    @RequiresPermissions("system:fileinputoutput:add")
    @Log(title = "文件导入导出测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,
                              @RequestParam("filename") String filename,
                              Fileinputoutput fileinputoutput) throws IOException
    {
        String filePath = RuoYiConfig.getUploadPath();
        String fileNewName = FileUploadUtils.upload(filePath,file);
        fileinputoutput.setFilename(filename);
        fileinputoutput.setFilepath(fileNewName);
        return toAjax(fileinputoutputService.insertFileinputoutput(fileinputoutput));
    }

    /**
     * 修改文件导入导出测试
     */
    @GetMapping("/edit/{fileid}")
    public String edit(@PathVariable("fileid") Long fileid, ModelMap mmap)
    {
        Fileinputoutput fileinputoutput = fileinputoutputService.selectFileinputoutputById(fileid);
        mmap.put("fileinputoutput", fileinputoutput);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件导入导出测试
     */
    @RequiresPermissions("system:fileinputoutput:ed0it")
    @Log(title = "文件导入导出测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fileinputoutput fileinputoutput)
    {

        return toAjax(fileinputoutputService.updateFileinputoutput(fileinputoutput));
    }

    /**
     * 删除文件导入导出测试
     */
    @RequiresPermissions("system:fileinputoutput:remove")
    @Log(title = "文件导入导出测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fileinputoutputService.deleteFileinputoutputByIds(ids));
    }
}
