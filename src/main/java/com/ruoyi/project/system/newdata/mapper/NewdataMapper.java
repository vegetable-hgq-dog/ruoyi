package com.ruoyi.project.system.newdata.mapper;

import java.util.List;
import com.ruoyi.project.system.newdata.domain.Newdata;

/**
 * 最新数据Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
public interface NewdataMapper 
{
    /**
     * 查询最新数据
     * 
     * @param id 最新数据ID
     * @return 最新数据
     */
    public Newdata selectNewdataById(Long id);

    /**
     * 查询最新数据列表
     * 
     * @param newdata 最新数据
     * @return 最新数据集合
     */
    public List<Newdata> selectNewdataList(Newdata newdata);

    /**
     * 新增最新数据
     * 
     * @param newdata 最新数据
     * @return 结果
     */
    public int insertNewdata(Newdata newdata);

    /**
     * 修改最新数据
     * 
     * @param newdata 最新数据
     * @return 结果
     */
    public int updateNewdata(Newdata newdata);

    /**
     * 删除最新数据
     * 
     * @param id 最新数据ID
     * @return 结果
     */
    public int deleteNewdataById(Long id);

    /**
     * 批量删除最新数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewdataByIds(String[] ids);
}
