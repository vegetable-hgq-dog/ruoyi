package com.ruoyi.project.system.workshop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.workshop.mapper.DsWorkshopMapper;
import com.ruoyi.project.system.workshop.domain.DsWorkshop;
import com.ruoyi.project.system.workshop.service.IDsWorkshopService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 车间信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsWorkshopServiceImpl implements IDsWorkshopService 
{
    @Autowired
    private DsWorkshopMapper dsWorkshopMapper;

    /**
     * 查询车间信息
     * 
     * @param workshopid 车间信息ID
     * @return 车间信息
     */
    @Override
    public DsWorkshop selectDsWorkshopById(Long workshopid)
    {
        return dsWorkshopMapper.selectDsWorkshopById(workshopid);
    }

    /**
     * 查询车间信息列表
     * 
     * @param dsWorkshop 车间信息
     * @return 车间信息
     */
    @Override
    public List<DsWorkshop> selectDsWorkshopList(DsWorkshop dsWorkshop)
    {
        return dsWorkshopMapper.selectDsWorkshopList(dsWorkshop);
    }

    /**
     * 新增车间信息
     * 
     * @param dsWorkshop 车间信息
     * @return 结果
     */
    @Override
    public int insertDsWorkshop(DsWorkshop dsWorkshop)
    {
        return dsWorkshopMapper.insertDsWorkshop(dsWorkshop);
    }

    /**
     * 修改车间信息
     * 
     * @param dsWorkshop 车间信息
     * @return 结果
     */
    @Override
    public int updateDsWorkshop(DsWorkshop dsWorkshop)
    {
        return dsWorkshopMapper.updateDsWorkshop(dsWorkshop);
    }

    /**
     * 删除车间信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsWorkshopByIds(String ids)
    {
        return dsWorkshopMapper.deleteDsWorkshopByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车间信息信息
     * 
     * @param workshopid 车间信息ID
     * @return 结果
     */
    @Override
    public int deleteDsWorkshopById(Long workshopid)
    {
        return dsWorkshopMapper.deleteDsWorkshopById(workshopid);
    }
}
