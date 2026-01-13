package com.ruoyi.project.system.aftersalecenter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.aftersalecenter.mapper.DsAftersalecenterMapper;
import com.ruoyi.project.system.aftersalecenter.domain.DsAftersalecenter;
import com.ruoyi.project.system.aftersalecenter.service.IDsAftersalecenterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * aftersalecenterService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsAftersalecenterServiceImpl implements IDsAftersalecenterService 
{
    @Autowired
    private DsAftersalecenterMapper dsAftersalecenterMapper;

    /**
     * 查询aftersalecenter
     * 
     * @param centerid aftersalecenterID
     * @return aftersalecenter
     */
    @Override
    public DsAftersalecenter selectDsAftersalecenterById(Long centerid)
    {
        return dsAftersalecenterMapper.selectDsAftersalecenterById(centerid);
    }

    /**
     * 查询aftersalecenter列表
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return aftersalecenter
     */
    @Override
    public List<DsAftersalecenter> selectDsAftersalecenterList(DsAftersalecenter dsAftersalecenter)
    {
        return dsAftersalecenterMapper.selectDsAftersalecenterList(dsAftersalecenter);
    }

    /**
     * 新增aftersalecenter
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return 结果
     */
    @Override
    public int insertDsAftersalecenter(DsAftersalecenter dsAftersalecenter)
    {
        return dsAftersalecenterMapper.insertDsAftersalecenter(dsAftersalecenter);
    }

    /**
     * 修改aftersalecenter
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return 结果
     */
    @Override
    public int updateDsAftersalecenter(DsAftersalecenter dsAftersalecenter)
    {
        return dsAftersalecenterMapper.updateDsAftersalecenter(dsAftersalecenter);
    }

    /**
     * 删除aftersalecenter对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsAftersalecenterByIds(String ids)
    {
        return dsAftersalecenterMapper.deleteDsAftersalecenterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除aftersalecenter信息
     * 
     * @param centerid aftersalecenterID
     * @return 结果
     */
    @Override
    public int deleteDsAftersalecenterById(Long centerid)
    {
        return dsAftersalecenterMapper.deleteDsAftersalecenterById(centerid);
    }

    @Override
    public List selectCenterID(){
        return dsAftersalecenterMapper.selectCenterID();
    }
}
