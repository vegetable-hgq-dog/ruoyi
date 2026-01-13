package com.ruoyi.project.manufacture.weldinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.manufacture.weldinfo.mapper.DsWeldingCurrentDataMapper;
import com.ruoyi.project.manufacture.weldinfo.domain.DsWeldingCurrentData;
import com.ruoyi.project.manufacture.weldinfo.service.IDsWeldingCurrentDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * weld_infoService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Service
public class DsWeldingCurrentDataServiceImpl implements IDsWeldingCurrentDataService 
{
    @Autowired
    private DsWeldingCurrentDataMapper dsWeldingCurrentDataMapper;

    /**
     * 查询weld_info
     * 
     * @param autoId weld_infoID
     * @return weld_info
     */
    @Override
    public DsWeldingCurrentData selectDsWeldingCurrentDataById(Long autoId)
    {
        return dsWeldingCurrentDataMapper.selectDsWeldingCurrentDataById(autoId);
    }

    /**
     * 查询weld_info列表
     * 
     * @param dsWeldingCurrentData weld_info
     * @return weld_info
     */
    @Override
    public List<DsWeldingCurrentData> selectDsWeldingCurrentDataList(DsWeldingCurrentData dsWeldingCurrentData)
    {
        return dsWeldingCurrentDataMapper.selectDsWeldingCurrentDataList(dsWeldingCurrentData);
    }

    /**
     * 新增weld_info
     * 
     * @param dsWeldingCurrentData weld_info
     * @return 结果
     */
    @Override
    public int insertDsWeldingCurrentData(DsWeldingCurrentData dsWeldingCurrentData)
    {
        return dsWeldingCurrentDataMapper.insertDsWeldingCurrentData(dsWeldingCurrentData);
    }

    /**
     * 修改weld_info
     * 
     * @param dsWeldingCurrentData weld_info
     * @return 结果
     */
    @Override
    public int updateDsWeldingCurrentData(DsWeldingCurrentData dsWeldingCurrentData)
    {
        return dsWeldingCurrentDataMapper.updateDsWeldingCurrentData(dsWeldingCurrentData);
    }

    /**
     * 删除weld_info对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingCurrentDataByIds(String ids)
    {
        return dsWeldingCurrentDataMapper.deleteDsWeldingCurrentDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除weld_info信息
     * 
     * @param autoId weld_infoID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingCurrentDataById(Long autoId)
    {
        return dsWeldingCurrentDataMapper.deleteDsWeldingCurrentDataById(autoId);
    }
}
