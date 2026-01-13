package com.ruoyi.project.system.transportInf.mapper;

import java.util.List;
import com.ruoyi.project.system.transportInf.domain.TransportTable;

/**
 * 运输信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public interface TransportTableMapper 
{
    /**
     * 查询运输信息
     * 
     * @param id 运输信息ID
     * @return 运输信息
     */
    public TransportTable selectTransportTableById(Long id);

    /**
     * 查询运输信息列表
     * 
     * @param transportTable 运输信息
     * @return 运输信息集合
     */
    public List<TransportTable> selectTransportTableList(TransportTable transportTable);

    /**
     * 新增运输信息
     * 
     * @param transportTable 运输信息
     * @return 结果
     */
    public int insertTransportTable(TransportTable transportTable);

    /**
     * 修改运输信息
     * 
     * @param transportTable 运输信息
     * @return 结果
     */
    public int updateTransportTable(TransportTable transportTable);

    /**
     * 删除运输信息
     * 
     * @param id 运输信息ID
     * @return 结果
     */
    public int deleteTransportTableById(Long id);

    /**
     * 批量删除运输信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTransportTableByIds(String[] ids);

    public List getAllTransportData();
}
