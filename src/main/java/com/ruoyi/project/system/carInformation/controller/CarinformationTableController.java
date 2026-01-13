package com.ruoyi.project.system.carInformation.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
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
import com.ruoyi.project.system.carInformation.domain.CarinformationTable;
import com.ruoyi.project.system.carInformation.service.ICarinformationTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车辆信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/carInformation")
public class CarinformationTableController extends BaseController
{
    private String prefix = "system/carInformation";

    @Autowired
    private ICarinformationTableService carinformationTableService;

    @RequiresPermissions("system:carInformation:view")
    @GetMapping()
    public String carInformation()
    {
        return prefix + "/carInformation";
    }

    /**
     * 查询车辆信息列表
     */
    @RequiresPermissions("system:carInformation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CarinformationTable carinformationTable)
    {
        startPage();
        List<CarinformationTable> list = carinformationTableService.selectCarinformationTableList(carinformationTable);
        return getDataTable(list);
    }

    /**
     * 导出车辆信息列表
     */
    @RequiresPermissions("system:carInformation:export")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CarinformationTable carinformationTable)
    {
        List<CarinformationTable> list = carinformationTableService.selectCarinformationTableList(carinformationTable);
        ExcelUtil<CarinformationTable> util = new ExcelUtil<CarinformationTable>(CarinformationTable.class);
        return util.exportExcel(list, "carInformation");
    }

    /**
     * 新增车辆信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆信息
     */
    @RequiresPermissions("system:carInformation:add")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CarinformationTable carinformationTable)
    {
        return toAjax(carinformationTableService.insertCarinformationTable(carinformationTable));
    }

    /**
     * 修改车辆信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CarinformationTable carinformationTable = carinformationTableService.selectCarinformationTableById(id);
        mmap.put("carinformationTable", carinformationTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆信息
     */
    @RequiresPermissions("system:carInformation:edit")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CarinformationTable carinformationTable)
    {
        return toAjax(carinformationTableService.updateCarinformationTable(carinformationTable));
    }

    /**
     * 删除车辆信息
     */
    @RequiresPermissions("system:carInformation:remove")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(carinformationTableService.deleteCarinformationTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<CarinformationTable> util = new ExcelUtil<CarinformationTable>(CarinformationTable.class);
        return util.importTemplateExcel("车辆信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CarinformationTable> util = new ExcelUtil<CarinformationTable>(CarinformationTable.class);
        List<CarinformationTable> carInformationList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = carinformationTableService.importCarImformation(carInformationList, updateSupport,operName);
        return AjaxResult.success(message);
    }
}
