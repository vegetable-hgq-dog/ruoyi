package com.ruoyi.project.data.designdata.component.controller;

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
import com.ruoyi.project.data.designdata.component.domain.DsComponent;
import com.ruoyi.project.data.designdata.component.service.IDsComponentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 产品信息Controller
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/designdata/component")
public class DsComponentController extends BaseController
{
    private String prefix = "designdata/component";

    @Autowired
    private IDsComponentService dsComponentService;

    @RequiresPermissions("designdata:component:view")
    @GetMapping()
    public String component()
    {
        return prefix + "/component";
    }

    /**
     * 查询产品信息树列表
     */
    @RequiresPermissions("designdata:component:list")
    @PostMapping("/list")
    @ResponseBody
    public List<DsComponent> list(DsComponent dsComponent)
    {
        List<DsComponent> list = dsComponentService.selectDsComponentList(dsComponent);
        return list;
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("designdata:component:export")
    @Log(title = "产品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DsComponent dsComponent)
    {
        List<DsComponent> list = dsComponentService.selectDsComponentList(dsComponent);
        ExcelUtil<DsComponent> util = new ExcelUtil<DsComponent>(DsComponent.class);
        return util.exportExcel(list, "component");
    }

    /**
     * 新增产品信息
     */
    @GetMapping(value = { "/add/{componentid}", "/add/" })
    public String add(@PathVariable(value = "componentid", required = false) Long componentid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(componentid))
        {
            mmap.put("dsComponent", dsComponentService.selectDsComponentById(componentid));
        } else {
        	DsComponent superRoot = new DsComponent();
        	superRoot.setComponentid(0L);
        	superRoot.setComponentname("超级根节点");
        	mmap.put("dsComponent", superRoot);
        }
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("designdata:component:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DsComponent dsComponent)
    {
        return toAjax(dsComponentService.insertDsComponent(dsComponent));
    }

    /**
     * 修改产品信息
     */
    @GetMapping("/edit/{componentid}")
    public String edit(@PathVariable("componentid") Long componentid, ModelMap mmap)
    {
        DsComponent dsComponent = dsComponentService.selectDsComponentById(componentid);
        mmap.put("dsComponent", dsComponent);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("designdata:component:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DsComponent dsComponent)
    {
        return toAjax(dsComponentService.updateDsComponent(dsComponent));
    }

    /**
     * 删除
     */
    @RequiresPermissions("designdata:component:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{componentid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("componentid") Long componentid)
    {
        return toAjax(dsComponentService.deleteDsComponentById(componentid));
    }

    /**
     * 选择产品信息树
     */
    @GetMapping(value = { "/selectComponentTree/{componentid}", "/selectComponentTree/" })
    public String selectComponentTree(@PathVariable(value = "componentid", required = false) Long componentid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(componentid))
        {
            mmap.put("dsComponent", dsComponentService.selectDsComponentById(componentid));
        }
        return prefix + "/tree";
    }

    /**
     * 加载产品信息树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = dsComponentService.selectDsComponentTree();
        return ztrees;
    }
}
