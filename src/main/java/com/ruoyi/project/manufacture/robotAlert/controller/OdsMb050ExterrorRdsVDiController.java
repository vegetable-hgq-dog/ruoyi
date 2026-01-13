package com.ruoyi.project.manufacture.robotAlert.controller;

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
import com.ruoyi.project.manufacture.robotAlert.domain.OdsMb050ExterrorRdsVDi;
import com.ruoyi.project.manufacture.robotAlert.service.IOdsMb050ExterrorRdsVDiService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * robot_alertController
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Controller
@RequestMapping("/manufacture/robotAlert")
public class OdsMb050ExterrorRdsVDiController extends BaseController
{
    private String prefix = "manufacture/robotAlert";

    @Autowired
    private IOdsMb050ExterrorRdsVDiService odsMb050ExterrorRdsVDiService;

    @RequiresPermissions("manufacture:robotAlert:view")
    @GetMapping()
    public String robotAlert()
    {
        return prefix + "/robotAlert";
    }

    /**
     * 查询robot_alert列表
     */
    @RequiresPermissions("manufacture:robotAlert:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        startPage();
        List<OdsMb050ExterrorRdsVDi> list = odsMb050ExterrorRdsVDiService.selectOdsMb050ExterrorRdsVDiList(odsMb050ExterrorRdsVDi);
        return getDataTable(list);
    }

    /**
     * 导出robot_alert列表
     */
    @RequiresPermissions("manufacture:robotAlert:export")
    @Log(title = "robot_alert", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        List<OdsMb050ExterrorRdsVDi> list = odsMb050ExterrorRdsVDiService.selectOdsMb050ExterrorRdsVDiList(odsMb050ExterrorRdsVDi);
        ExcelUtil<OdsMb050ExterrorRdsVDi> util = new ExcelUtil<OdsMb050ExterrorRdsVDi>(OdsMb050ExterrorRdsVDi.class);
        return util.exportExcel(list, "robotAlert");
    }

    /**
     * 新增robot_alert
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存robot_alert
     */
    @RequiresPermissions("manufacture:robotAlert:add")
    @Log(title = "robot_alert", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        return toAjax(odsMb050ExterrorRdsVDiService.insertOdsMb050ExterrorRdsVDi(odsMb050ExterrorRdsVDi));
    }

    /**
     * 修改robot_alert
     */
    @GetMapping("/edit/{autoid}")
    public String edit(@PathVariable("autoid") Long autoid, ModelMap mmap)
    {
        OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi = odsMb050ExterrorRdsVDiService.selectOdsMb050ExterrorRdsVDiById(autoid);
        mmap.put("odsMb050ExterrorRdsVDi", odsMb050ExterrorRdsVDi);
        return prefix + "/edit";
    }

    /**
     * 修改保存robot_alert
     */
    @RequiresPermissions("manufacture:robotAlert:edit")
    @Log(title = "robot_alert", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        return toAjax(odsMb050ExterrorRdsVDiService.updateOdsMb050ExterrorRdsVDi(odsMb050ExterrorRdsVDi));
    }

    /**
     * 删除robot_alert
     */
    @RequiresPermissions("manufacture:robotAlert:remove")
    @Log(title = "robot_alert", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(odsMb050ExterrorRdsVDiService.deleteOdsMb050ExterrorRdsVDiByIds(ids));
    }
}
