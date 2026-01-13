package com.ruoyi.project.manufacture.robotinfo.controller;

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
import com.ruoyi.project.manufacture.robotinfo.domain.OdsAbbRobotInfoDi;
import com.ruoyi.project.manufacture.robotinfo.service.IOdsAbbRobotInfoDiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * robot_infoController
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Controller
@RequestMapping("/manufacture/robotinfo")
public class OdsAbbRobotInfoDiController extends BaseController
{
    private String prefix = "manufacture/robotinfo";

    @Autowired
    private IOdsAbbRobotInfoDiService odsAbbRobotInfoDiService;

    @RequiresPermissions("manufacture:robotinfo:view")
    @GetMapping()
    public String robotinfo()
    {
        return prefix + "/robotinfo";
    }

    /**
     * 查询robot_info列表
     */
    @RequiresPermissions("manufacture:robotinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        startPage();
        List<OdsAbbRobotInfoDi> list = odsAbbRobotInfoDiService.selectOdsAbbRobotInfoDiList(odsAbbRobotInfoDi);
        return getDataTable(list);
    }

    /**
     * 导出robot_info列表
     */
    @RequiresPermissions("manufacture:robotinfo:export")
    @Log(title = "robot_info", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        List<OdsAbbRobotInfoDi> list = odsAbbRobotInfoDiService.selectOdsAbbRobotInfoDiList(odsAbbRobotInfoDi);
        ExcelUtil<OdsAbbRobotInfoDi> util = new ExcelUtil<OdsAbbRobotInfoDi>(OdsAbbRobotInfoDi.class);
        return util.exportExcel(list, "robotinfo");
    }

    /**
     * 新增robot_info
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存robot_info
     */
    @RequiresPermissions("manufacture:robotinfo:add")
    @Log(title = "robot_info", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        return toAjax(odsAbbRobotInfoDiService.insertOdsAbbRobotInfoDi(odsAbbRobotInfoDi));
    }

    /**
     * 修改robot_info
     */
    @GetMapping("/edit/{autoid}")
    public String edit(@PathVariable("autoid") Long autoid, ModelMap mmap)
    {
        OdsAbbRobotInfoDi odsAbbRobotInfoDi = odsAbbRobotInfoDiService.selectOdsAbbRobotInfoDiById(autoid);
        mmap.put("odsAbbRobotInfoDi", odsAbbRobotInfoDi);
        return prefix + "/edit";
    }

    /**
     * 修改保存robot_info
     */
    @RequiresPermissions("manufacture:robotinfo:edit")
    @Log(title = "robot_info", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        return toAjax(odsAbbRobotInfoDiService.updateOdsAbbRobotInfoDi(odsAbbRobotInfoDi));
    }

    /**
     * 删除robot_info
     */
    @RequiresPermissions("manufacture:robotinfo:remove")
    @Log(title = "robot_info", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(odsAbbRobotInfoDiService.deleteOdsAbbRobotInfoDiByIds(ids));
    }
}
