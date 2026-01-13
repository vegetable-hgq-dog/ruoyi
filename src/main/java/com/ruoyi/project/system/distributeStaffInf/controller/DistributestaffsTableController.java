package com.ruoyi.project.system.distributeStaffInf.controller;

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
import com.ruoyi.project.system.distributeStaffInf.domain.DistributestaffsTable;
import com.ruoyi.project.system.distributeStaffInf.service.IDistributestaffsTableService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 配送人员Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/system/distributeStaffInf")
public class DistributestaffsTableController extends BaseController
{
    private String prefix = "system/distributeStaffInf";

    @Autowired
    private IDistributestaffsTableService distributestaffsTableService;

    @RequiresPermissions("system:distributeStaffInf:view")
    @GetMapping()
    public String distributeStaffInf()
    {
        return prefix + "/distributeStaffInf";
    }

    /**
     * 查询配送人员列表
     */
    @RequiresPermissions("system:distributeStaffInf:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DistributestaffsTable distributestaffsTable)
    {
        startPage();
        List<DistributestaffsTable> list = distributestaffsTableService.selectDistributestaffsTableList(distributestaffsTable);
        return getDataTable(list);
    }

    /**
     * 导出配送人员列表
     */
    @RequiresPermissions("system:distributeStaffInf:export")
    @Log(title = "配送人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DistributestaffsTable distributestaffsTable)
    {
        List<DistributestaffsTable> list = distributestaffsTableService.selectDistributestaffsTableList(distributestaffsTable);
        ExcelUtil<DistributestaffsTable> util = new ExcelUtil<DistributestaffsTable>(DistributestaffsTable.class);
        return util.exportExcel(list, "distributeStaffInf");
    }

    /**
     * 新增配送人员
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存配送人员
     */
    @RequiresPermissions("system:distributeStaffInf:add")
    @Log(title = "配送人员", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DistributestaffsTable distributestaffsTable)
    {
        return toAjax(distributestaffsTableService.insertDistributestaffsTable(distributestaffsTable));
    }

    /**
     * 修改配送人员
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DistributestaffsTable distributestaffsTable = distributestaffsTableService.selectDistributestaffsTableById(id);
        mmap.put("distributestaffsTable", distributestaffsTable);
        return prefix + "/edit";
    }

    /**
     * 修改保存配送人员
     */
    @RequiresPermissions("system:distributeStaffInf:edit")
    @Log(title = "配送人员", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DistributestaffsTable distributestaffsTable)
    {
        return toAjax(distributestaffsTableService.updateDistributestaffsTable(distributestaffsTable));
    }

    /**
     * 删除配送人员
     */
    @RequiresPermissions("system:distributeStaffInf:remove")
    @Log(title = "配送人员", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(distributestaffsTableService.deleteDistributestaffsTableByIds(ids));
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<DistributestaffsTable> util = new ExcelUtil<DistributestaffsTable>(DistributestaffsTable.class);
        return util.importTemplateExcel("配送人员信息");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DistributestaffsTable> util = new ExcelUtil<DistributestaffsTable>(DistributestaffsTable.class);
        List<DistributestaffsTable> distributestaffsList = util.importExcel(file.getInputStream());

        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = distributestaffsTableService.importDistributestaffs(distributestaffsList, updateSupport,operName);
        return AjaxResult.success(message);
    }
}
