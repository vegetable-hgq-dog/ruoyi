package com.ruoyi.project.system.search.service;

import java.util.List;
import com.ruoyi.project.system.search.domain.Search;

/**
 * 搜索数据Service接口
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
public interface ISearchService 
{
    /**
     * 查询搜索数据
     * 
     * @param id 搜索数据ID
     * @return 搜索数据
     */
    public Search selectSearchById(Long id);

    /**
     * 查询搜索数据列表
     * 
     * @param search 搜索数据
     * @return 搜索数据集合
     */
    public List<Search> selectSearchList(Search search);

    /**
     * 新增搜索数据
     * 
     * @param search 搜索数据
     * @return 结果
     */
    public int insertSearch(Search search);

    /**
     * 修改搜索数据
     * 
     * @param search 搜索数据
     * @return 结果
     */
    public int updateSearch(Search search);

    /**
     * 批量删除搜索数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSearchByIds(String ids);

    /**
     * 删除搜索数据信息
     * 
     * @param id 搜索数据ID
     * @return 结果
     */
    public int deleteSearchById(Long id);
}
