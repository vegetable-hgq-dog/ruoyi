package com.ruoyi.project.system.search.controller;

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
import com.ruoyi.project.system.search.domain.Search;
import com.ruoyi.project.system.search.service.ISearchService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 搜索数据Controller
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Controller
@RequestMapping("/system/search")
public class SearchController extends BaseController
{
    private String prefix = "system/search";

    @Autowired
    private ISearchService searchService;

    @RequiresPermissions("system:search:view")
    @GetMapping()
    public String search()
    {
        return prefix + "/search";
    }

    /**
     * 查询搜索数据列表
     */
    @RequiresPermissions("system:search:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Search search)
    {
        startPage();
        List<Search> list = searchService.selectSearchList(search);
        return getDataTable(list);
    }

    /**
     * 导出搜索数据列表
     */
    @RequiresPermissions("system:search:export")
    @Log(title = "搜索数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Search search)
    {
        List<Search> list = searchService.selectSearchList(search);
        ExcelUtil<Search> util = new ExcelUtil<Search>(Search.class);
        return util.exportExcel(list, "search");
    }

    /**
     * 新增搜索数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存搜索数据
     */
    @RequiresPermissions("system:search:add")
    @Log(title = "搜索数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Search search)
    {
        return toAjax(searchService.insertSearch(search));
    }

    /**
     * 修改搜索数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Search search = searchService.selectSearchById(id);
        mmap.put("search", search);
        return prefix + "/edit";
    }

    /**
     * 修改保存搜索数据
     */
    @RequiresPermissions("system:search:edit")
    @Log(title = "搜索数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Search search)
    {
        return toAjax(searchService.updateSearch(search));
    }

    /**
     * 删除搜索数据
     */
    @RequiresPermissions("system:search:remove")
    @Log(title = "搜索数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(searchService.deleteSearchByIds(ids));
    }
}
