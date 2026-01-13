package com.ruoyi.project.system.firmkeychainparameter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmkeychainparameter.mapper.FirmkeychainparameterMapper;
import com.ruoyi.project.system.firmkeychainparameter.domain.Firmkeychainparameter;
import com.ruoyi.project.system.firmkeychainparameter.service.IFirmkeychainparameterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 关键链条参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Service
public class FirmkeychainparameterServiceImpl implements IFirmkeychainparameterService 
{
    @Autowired
    private FirmkeychainparameterMapper firmkeychainparameterMapper;

    /**
     * 查询关键链条参数
     * 
     * @param id 关键链条参数ID
     * @return 关键链条参数
     */
    @Override
    public Firmkeychainparameter selectFirmkeychainparameterById(Long id)
    {
        return firmkeychainparameterMapper.selectFirmkeychainparameterById(id);
    }

    /**
     * 查询关键链条参数列表
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 关键链条参数
     */
    @Override
    public List<Firmkeychainparameter> selectFirmkeychainparameterList(Firmkeychainparameter firmkeychainparameter)
    {
        return firmkeychainparameterMapper.selectFirmkeychainparameterList(firmkeychainparameter);
    }

    /**
     * 新增关键链条参数
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 结果
     */
    @Override
    public int insertFirmkeychainparameter(Firmkeychainparameter firmkeychainparameter)
    {
        return firmkeychainparameterMapper.insertFirmkeychainparameter(firmkeychainparameter);
    }

    /**
     * 修改关键链条参数
     * 
     * @param firmkeychainparameter 关键链条参数
     * @return 结果
     */
    @Override
    public int updateFirmkeychainparameter(Firmkeychainparameter firmkeychainparameter)
    {
        return firmkeychainparameterMapper.updateFirmkeychainparameter(firmkeychainparameter);
    }

    /**
     * 删除关键链条参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmkeychainparameterByIds(String ids)
    {
        return firmkeychainparameterMapper.deleteFirmkeychainparameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关键链条参数信息
     * 
     * @param id 关键链条参数ID
     * @return 结果
     */
    @Override
    public int deleteFirmkeychainparameterById(Long id)
    {
        return firmkeychainparameterMapper.deleteFirmkeychainparameterById(id);
    }

    @Override
    public List getKeyChainParameter(){
        return firmkeychainparameterMapper.getKeyChainParameter();
    }
}
