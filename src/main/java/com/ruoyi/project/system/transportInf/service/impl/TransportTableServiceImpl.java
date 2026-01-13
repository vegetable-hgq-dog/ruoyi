package com.ruoyi.project.system.transportInf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.transportInf.mapper.TransportTableMapper;
import com.ruoyi.project.system.transportInf.domain.TransportTable;
import com.ruoyi.project.system.transportInf.service.ITransportTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 运输信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Service
public class TransportTableServiceImpl implements ITransportTableService 
{
    @Autowired
    private TransportTableMapper transportTableMapper;

    /**
     * 查询运输信息
     * 
     * @param id 运输信息ID
     * @return 运输信息
     */
    @Override
    public TransportTable selectTransportTableById(Long id)
    {
        return transportTableMapper.selectTransportTableById(id);
    }

    /**
     * 查询运输信息列表
     * 
     * @param transportTable 运输信息
     * @return 运输信息
     */
    @Override
    public List<TransportTable> selectTransportTableList(TransportTable transportTable)
    {
        return transportTableMapper.selectTransportTableList(transportTable);
    }

    /**
     * 新增运输信息
     * 
     * @param transportTable 运输信息
     * @return 结果
     */
    @Override
    public int insertTransportTable(TransportTable transportTable)
    {
        return transportTableMapper.insertTransportTable(transportTable);
    }

    /**
     * 修改运输信息
     * 
     * @param transportTable 运输信息
     * @return 结果
     */
    @Override
    public int updateTransportTable(TransportTable transportTable)
    {
        return transportTableMapper.updateTransportTable(transportTable);
    }

    /**
     * 删除运输信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTransportTableByIds(String ids)
    {
        return transportTableMapper.deleteTransportTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除运输信息信息
     * 
     * @param id 运输信息ID
     * @return 结果
     */
    @Override
    public int deleteTransportTableById(Long id)
    {
        return transportTableMapper.deleteTransportTableById(id);
    }

    @Override
    public List getAllTransportData(){
        return transportTableMapper.getAllTransportData();
    }


}
