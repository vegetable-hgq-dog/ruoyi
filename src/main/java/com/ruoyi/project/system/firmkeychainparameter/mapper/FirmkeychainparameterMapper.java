package com.ruoyi.project.system.firmkeychainparameter.mapper;

import java.util.List;
import com.ruoyi.project.system.firmkeychainparameter.domain.Firmkeychainparameter;

/**
 * 关键链条参数Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public interface FirmkeychainparameterMapper 
{
    /**
     * 查询关键链条参数
     * 
     * @param id 关键链条参数ID
     * @return 关键链条参数
     */
    public Firmkeychainparameter selectFirmkeychainparameterById(Long id);

    /**
     * 查询关键链条参数列表
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 关键链条参数集合
     */
    public List<Firmkeychainparameter> selectFirmkeychainparameterList(Firmkeychainparameter firmkeychainparameter);

    /**
     * 新增关键链条参数
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 结果
     */
    public int insertFirmkeychainparameter(Firmkeychainparameter firmkeychainparameter);

    /**
     * 修改关键链条参数
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 结果
     */
    public int updateFirmkeychainparameter(Firmkeychainparameter firmkeychainparameter);

    /**
     * 删除关键链条参数
     * 
     * @param id 关键链条参数ID
     * @return 结果
     */
    public int deleteFirmkeychainparameterById(Long id);

    /**
     * 批量删除关键链条参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmkeychainparameterByIds(String[] ids);

    public List getKeyChainParameter();
}
