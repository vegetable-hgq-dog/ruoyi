package com.ruoyi.project.system.search.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.search.mapper.SearchMapper;
import com.ruoyi.project.system.search.domain.Search;
import com.ruoyi.project.system.search.service.ISearchService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 搜索数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class SearchServiceImpl implements ISearchService 
{
    @Autowired
    private SearchMapper searchMapper;

    /**
     * 查询搜索数据
     * 
     * @param id 搜索数据ID
     * @return 搜索数据
     */
    @Override
    public Search selectSearchById(Long id)
    {
        return searchMapper.selectSearchById(id);
    }

    /**
     * 查询搜索数据列表
     * 
     * @param search 搜索数据
     * @return 搜索数据
     */
    @Override
    public List<Search> selectSearchList(Search search)
    {
        return searchMapper.selectSearchList(search);
    }

    /**
     * 新增搜索数据
     * 
     * @param search 搜索数据
     * @return 结果
     */
    @Override
    public int insertSearch(Search search)
    {
        return searchMapper.insertSearch(search);
    }

    /**
     * 修改搜索数据
     * 
     * @param search 搜索数据
     * @return 结果
     */
    @Override
    public int updateSearch(Search search)
    {
        return searchMapper.updateSearch(search);
    }

    /**
     * 删除搜索数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSearchByIds(String ids)
    {
        return searchMapper.deleteSearchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除搜索数据信息
     * 
     * @param id 搜索数据ID
     * @return 结果
     */
    @Override
    public int deleteSearchById(Long id)
    {
        return searchMapper.deleteSearchById(id);
    }
}
