package com.ruoyi.project.system.firminfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firminfo.mapper.FirminfoMapper;
import com.ruoyi.project.system.firminfo.domain.Firminfo;
import com.ruoyi.project.system.firminfo.service.IFirminfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 供应链企业信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
@Service
public class FirminfoServiceImpl implements IFirminfoService 
{
    @Autowired
    private FirminfoMapper firminfoMapper;

    /**
     * 查询供应链企业信息
     * 
     * @param firmId 供应链企业信息ID
     * @return 供应链企业信息
     */
    @Override
    public Firminfo selectFirminfoById(Long firmId)
    {
        return firminfoMapper.selectFirminfoById(firmId);
    }

    /**
     * 查询供应链企业信息列表
     * 
     * @param firminfo 供应链企业信息
     * @return 供应链企业信息
     */
    @Override
    public List<Firminfo> selectFirminfoList(Firminfo firminfo)
    {
        return firminfoMapper.selectFirminfoList(firminfo);
    }

    /**
     * 新增供应链企业信息
     * 
     * @param firminfo 供应链企业信息
     * @return 结果
     */
    @Override
    public int insertFirminfo(Firminfo firminfo)
    {
        return firminfoMapper.insertFirminfo(firminfo);
    }

    /**
     * 修改供应链企业信息
     * 
     * @param firminfo 供应链企业信息
     * @return 结果
     */
    @Override
    public int updateFirminfo(Firminfo firminfo)
    {
        return firminfoMapper.updateFirminfo(firminfo);
    }

    /**
     * 删除供应链企业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirminfoByIds(String ids)
    {
        return firminfoMapper.deleteFirminfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应链企业信息信息
     * 
     * @param firmId 供应链企业信息ID
     * @return 结果
     */
    @Override
    public int deleteFirminfoById(Long firmId)
    {
        return firminfoMapper.deleteFirminfoById(firmId);
    }

    @Override
    public List selectFirmInfos(){
        return firminfoMapper.selectFirmInfos();
    };

    @Override
    public List getLayers(){
        return firminfoMapper.getLayers();
    }
}
