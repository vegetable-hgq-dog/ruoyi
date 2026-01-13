package com.ruoyi.project.system.factory.service;

import java.util.List;
import com.ruoyi.project.system.factory.domain.DsFactory;

/**
 * 工厂信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsFactoryService 
{
    /**
     * 查询工厂信息
     * 
     * @param factoryid 工厂信息ID
     * @return 工厂信息
     */
    public DsFactory selectDsFactoryById(Long factoryid);

    /**
     * 查询工厂信息列表
     * 
     * @param dsFactory 工厂信息
     * @return 工厂信息集合
     */
    public List<DsFactory> selectDsFactoryList(DsFactory dsFactory);

    /**
     * 新增工厂信息
     * 
     * @param dsFactory 工厂信息
     * @return 结果
     */
    public int insertDsFactory(DsFactory dsFactory);

    /**
     * 修改工厂信息
     * 
     * @param dsFactory 工厂信息
     * @return 结果
     */
    public int updateDsFactory(DsFactory dsFactory);

    /**
     * 批量删除工厂信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsFactoryByIds(String ids);

    /**
     * 删除工厂信息信息
     * 
     * @param factoryid 工厂信息ID
     * @return 结果
     */
    public int deleteDsFactoryById(Long factoryid);
}
