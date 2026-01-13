package com.ruoyi.project.system.firmrelystates.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmrelystates.mapper.FirmrelystatesMapper;
import com.ruoyi.project.system.firmrelystates.domain.Firmrelystates;
import com.ruoyi.project.system.firmrelystates.service.IFirmrelystatesService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 企业群数据管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Service
public class FirmrelystatesServiceImpl implements IFirmrelystatesService 
{
    @Autowired
    private FirmrelystatesMapper firmrelystatesMapper;

    /**
     * 查询企业群数据管理
     * 
     * @param id 企业群数据管理ID
     * @return 企业群数据管理
     */
    @Override
    public Firmrelystates selectFirmrelystatesById(Long id)
    {
        return firmrelystatesMapper.selectFirmrelystatesById(id);
    }

    /**
     * 查询企业群数据管理列表
     * 
     * @param firmrelystates 企业群数据管理
     * @return 企业群数据管理
     */
    @Override
    public List<Firmrelystates> selectFirmrelystatesList(Firmrelystates firmrelystates)
    {
        return firmrelystatesMapper.selectFirmrelystatesList(firmrelystates);
    }

    /**
     * 新增企业群数据管理
     * 
     * @param firmrelystates 企业群数据管理
     * @return 结果
     */
    @Override
    public int insertFirmrelystates(Firmrelystates firmrelystates)
    {
        return firmrelystatesMapper.insertFirmrelystates(firmrelystates);
    }

    /**
     * 修改企业群数据管理
     * 
     * @param firmrelystates 企业群数据管理
     * @return 结果
     */
    @Override
    public int updateFirmrelystates(Firmrelystates firmrelystates)
    {
        return firmrelystatesMapper.updateFirmrelystates(firmrelystates);
    }

    /**
     * 删除企业群数据管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmrelystatesByIds(String ids)
    {
        return firmrelystatesMapper.deleteFirmrelystatesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业群数据管理信息
     * 
     * @param id 企业群数据管理ID
     * @return 结果
     */
    @Override
    public int deleteFirmrelystatesById(Long id)
    {
        return firmrelystatesMapper.deleteFirmrelystatesById(id);
    }

    @Override
    public List getRelyState(){
        return firmrelystatesMapper.getRelyState();
    }
}
