package com.ruoyi.project.system.salevehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.salevehicle.mapper.DsSalevehicleMapper;
import com.ruoyi.project.system.salevehicle.domain.DsSalevehicle;
import com.ruoyi.project.system.salevehicle.service.IDsSalevehicleService;
import com.ruoyi.common.utils.text.Convert;

/**
 * salevehicleService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsSalevehicleServiceImpl implements IDsSalevehicleService 
{
    @Autowired
    private DsSalevehicleMapper dsSalevehicleMapper;

    /**
     * 查询salevehicle
     * 
     * @param vehicleid salevehicleID
     * @return salevehicle
     */
    @Override
    public DsSalevehicle selectDsSalevehicleById(Long vehicleid)
    {
        return dsSalevehicleMapper.selectDsSalevehicleById(vehicleid);
    }

    /**
     * 查询salevehicle列表
     * 
     * @param dsSalevehicle salevehicle
     * @return salevehicle
     */
    @Override
    public List<DsSalevehicle> selectDsSalevehicleList(DsSalevehicle dsSalevehicle)
    {
        return dsSalevehicleMapper.selectDsSalevehicleList(dsSalevehicle);
    }

    /**
     * 新增salevehicle
     * 
     * @param dsSalevehicle salevehicle
     * @return 结果
     */
    @Override
    public int insertDsSalevehicle(DsSalevehicle dsSalevehicle)
    {
        return dsSalevehicleMapper.insertDsSalevehicle(dsSalevehicle);
    }

    /**
     * 修改salevehicle
     * 
     * @param dsSalevehicle salevehicle
     * @return 结果
     */
    @Override
    public int updateDsSalevehicle(DsSalevehicle dsSalevehicle)
    {
        return dsSalevehicleMapper.updateDsSalevehicle(dsSalevehicle);
    }

    /**
     * 删除salevehicle对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsSalevehicleByIds(String ids)
    {
        return dsSalevehicleMapper.deleteDsSalevehicleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除salevehicle信息
     * 
     * @param vehicleid salevehicleID
     * @return 结果
     */
    @Override
    public int deleteDsSalevehicleById(Long vehicleid)
    {
        return dsSalevehicleMapper.deleteDsSalevehicleById(vehicleid);
    }

    @Override
    public List selectVehicleId(){
        return dsSalevehicleMapper.selectVehicleId();
    }
}
