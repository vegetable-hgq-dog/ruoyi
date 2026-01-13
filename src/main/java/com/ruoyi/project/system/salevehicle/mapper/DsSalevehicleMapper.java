package com.ruoyi.project.system.salevehicle.mapper;

import java.util.List;
import com.ruoyi.project.system.salevehicle.domain.DsSalevehicle;

/**
 * salevehicleMapper接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface DsSalevehicleMapper 
{
    /**
     * 查询salevehicle
     * 
     * @param vehicleid salevehicleID
     * @return salevehicle
     */
    public DsSalevehicle selectDsSalevehicleById(Long vehicleid);

    /**
     * 查询salevehicle列表
     * 
     * @param dsSalevehicle salevehicle
     * @return salevehicle集合
     */
    public List<DsSalevehicle> selectDsSalevehicleList(DsSalevehicle dsSalevehicle);

    /**
     * 新增salevehicle
     * 
     * @param dsSalevehicle salevehicle
     * @return 结果
     */
    public int insertDsSalevehicle(DsSalevehicle dsSalevehicle);

    /**
     * 修改salevehicle
     * 
     * @param dsSalevehicle salevehicle
     * @return 结果
     */
    public int updateDsSalevehicle(DsSalevehicle dsSalevehicle);

    /**
     * 删除salevehicle
     * 
     * @param vehicleid salevehicleID
     * @return 结果
     */
    public int deleteDsSalevehicleById(Long vehicleid);

    /**
     * 批量删除salevehicle
     * 
     * @param vehicleids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsSalevehicleByIds(String[] vehicleids);

    public List selectVehicleId();
}
