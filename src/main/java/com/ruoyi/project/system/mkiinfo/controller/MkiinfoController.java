package com.ruoyi.project.system.mkiinfo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.ktypeinfo.service.IKtypeinfoService;
import com.ruoyi.project.system.manufacturingfeatureinfo.service.IManufacturingfeatureinfoService;
import com.ruoyi.project.system.materialinfo.service.IMaterialinfoService;
import com.ruoyi.project.system.partinfo.service.IPartinfoService;
import com.ruoyi.project.system.processinfo.service.IProcessinfoService;
import com.ruoyi.project.system.shapefeatureinfo.service.IShapefeatureinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.mkiinfo.domain.Mkiinfo;
import com.ruoyi.project.system.mkiinfo.service.IMkiinfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 制造知识信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Controller
@RequestMapping("/system/mkiinfo")
public class MkiinfoController extends BaseController
{
    private String prefix = "system/mkiinfo";

    @Autowired
    private IProcessinfoService processinfoService;
    @Autowired
    private IMaterialinfoService materialinfoService;
    @Autowired
    private IPartinfoService partinfoService;
    @Autowired
    private IShapefeatureinfoService shapefeatureinfoService;
    @Autowired
    private IManufacturingfeatureinfoService manufacturingfeatureinfoService;
    @Autowired
    private IKtypeinfoService ktypeinfoService;

    @Autowired
    private IMkiinfoService mkiinfoService;

    @RequiresPermissions("system:mkiinfo:view")
    @GetMapping()
    public String mkiinfo()
    {
        return prefix + "/mkiinfo";
    }

    /**
     * 查询制造知识信息列表
     */
    @RequiresPermissions("system:mkiinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Mkiinfo mkiinfo)
    {
        startPage();
        List<Mkiinfo> list = mkiinfoService.selectMkiinfoList(mkiinfo);
        return getDataTable(list);
    }

    /**
     * 导出制造知识信息列表
     */
    @RequiresPermissions("system:mkiinfo:export")
    @Log(title = "制造知识信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Mkiinfo mkiinfo)
    {
        List<Mkiinfo> list = mkiinfoService.selectMkiinfoList(mkiinfo);
        ExcelUtil<Mkiinfo> util = new ExcelUtil<Mkiinfo>(Mkiinfo.class);
        return util.exportExcel(list, "mkiinfo");
    }

    /**
     * 新增制造知识信息
     */
    @GetMapping("/add")
    public String add(ModelMap contentInfo)
    {
        contentInfo.put("processInfo",processinfoService.selectProcessName());
        contentInfo.put("materialInfo",materialinfoService.selectMaterialName());
        contentInfo.put("partInfo",partinfoService.selectPartName());
        contentInfo.put("shapeFeatureInfo",shapefeatureinfoService.selectShapefeatureName());
        contentInfo.put("manufacturingFeatureInfo",manufacturingfeatureinfoService.selectManufacturingfeatureName());
        contentInfo.put("ktypeInfo",ktypeinfoService.selectKTypeName());
        return prefix + "/add";
    }

    /**
     * 新增保存制造知识信息
     */
    @RequiresPermissions("system:mkiinfo:add")
    @Log(title = "制造知识信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestPart("file") MultipartFile file,
                              @RequestParam("mkiname") String mkiname,
                              @RequestParam("processname") String processname,
                              @RequestParam("materialname") String materialname,
                              @RequestParam("partname") String partname,
                              @RequestParam("manufacturingfeaturename") String manufacturingfeaturename,
                              @RequestParam("shapefeaturename") String shapefeaturename,
                              @RequestParam("ktypename") String ktypename,
                              @RequestParam("edittime") Date edittime,
                              Mkiinfo mkiinfo) throws IOException
    {

        String filePath = RuoYiConfig.getUploadPath();
        String fileNewName = FileUploadUtils.upload(filePath,file);
        mkiinfo.setMkiname(mkiname);
        mkiinfo.setProcessname(processname);
        mkiinfo.setMaterialname(materialname);
        mkiinfo.setPartname(partname);
        mkiinfo.setManufacturingfeaturename(manufacturingfeaturename);
        mkiinfo.setShapefeaturename(shapefeaturename);
        mkiinfo.setKtypename(ktypename);
        mkiinfo.setEdittime(edittime);
        mkiinfo.setDetails(fileNewName);
        return toAjax(mkiinfoService.insertMkiinfo(mkiinfo));
    }

    /**
     * 修改制造知识信息
     */
    @GetMapping("/edit/{mkiid}")
    public String edit(@PathVariable("mkiid") Long mkiid, ModelMap mmap)
    {
        Mkiinfo mkiinfo = mkiinfoService.selectMkiinfoById(mkiid);
        mmap.put("mkiinfo", mkiinfo);
        mmap.put("processInfo",processinfoService.selectProcessName());
        mmap.put("materialInfo",materialinfoService.selectMaterialName());
        mmap.put("partInfo",partinfoService.selectPartName());
        mmap.put("shapeFeatureInfo",shapefeatureinfoService.selectShapefeatureName());
        mmap.put("manufacturingFeatureInfo",manufacturingfeatureinfoService.selectManufacturingfeatureName());
        mmap.put("ktypeInfo",ktypeinfoService.selectKTypeName());
        return prefix + "/edit";
    }

    /**
     * 修改保存制造知识信息
     */
    @RequiresPermissions("system:mkiinfo:edit")
    @Log(title = "制造知识信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestPart("file1") MultipartFile file1,
                               @RequestParam("mkiname1") String mkiname1,
                               @RequestParam("processname1") String processname1,
                               @RequestParam("materialname1") String materialname1,
                               @RequestParam("partname1") String partname1,
                               @RequestParam("manufacturingfeaturename1") String manufacturingfeaturename1,
                               @RequestParam("shapefeaturename1") String shapefeaturename1,
                               @RequestParam("ktypename1") String ktypename1,
                               @RequestParam("edittime1") Date edittime1,
                               Mkiinfo mkiinfo) throws IOException
    {
        String filePath = RuoYiConfig.getUploadPath();
        String fileNewName1 = FileUploadUtils.upload(filePath,file1);
        mkiinfo.setMkiname(mkiname1);
        mkiinfo.setProcessname(processname1);
        mkiinfo.setMaterialname(materialname1);
        mkiinfo.setPartname(partname1);
        mkiinfo.setManufacturingfeaturename(manufacturingfeaturename1);
        mkiinfo.setShapefeaturename(shapefeaturename1);
        mkiinfo.setKtypename(ktypename1);
        mkiinfo.setEdittime(edittime1);
        mkiinfo.setDetails(fileNewName1);
        return toAjax(mkiinfoService.updateMkiinfo(mkiinfo));
    }

    /**
     * 删除制造知识信息
     */
    @RequiresPermissions("system:mkiinfo:remove")
    @Log(title = "制造知识信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mkiinfoService.deleteMkiinfoByIds(ids));
    }

    @RequestMapping("/ktypenum")
    @ResponseBody
    public List checkKTypeNum(){
        return mkiinfoService.checkKTypeNum();
    }

    @RequestMapping("/processnum")
    @ResponseBody
    public List checkProcessNum(){
        return mkiinfoService.checkProcessNum();
    }

}
