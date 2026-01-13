package com.ruoyi.project.system.carInformation.service;

import java.util.List;
import com.ruoyi.project.system.carInformation.domain.CarinformationTable;

/**
 * 车辆信息Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface ICarinformationTableService 
{
    /**
     * 查询车辆信息
     * 
     * @param id 车辆信息ID
     * @return 车辆信息
     */
    public CarinformationTable selectCarinformationTableById(Long id);

    /**
     * 查询车辆信息列表
     * 
     * @param carinformationTable 车辆信息
     * @return 车辆信息集合
     */
    public List<CarinformationTable> selectCarinformationTableList(CarinformationTable carinformationTable);

    /**
     * 新增车辆信息
     * 
     * @param carinformationTable 车辆信息
     * @return 结果
     */
    public int insertCarinformationTable(CarinformationTable carinformationTable);

    /**
     * 修改车辆信息
     * 
     * @param carinformationTable 车辆信息
     * @return 结果
     */
    public int updateCarinformationTable(CarinformationTable carinformationTable);

    /**
     * 批量删除车辆信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarinformationTableByIds(String ids);

    /**
     * 删除车辆信息信息
     * 
     * @param id 车辆信息ID
     * @return 结果
     */
    public int deleteCarinformationTableById(Long id);


    public String importCarImformation(List<CarinformationTable> carInformationList, boolean updateSupport, String operName);
}
