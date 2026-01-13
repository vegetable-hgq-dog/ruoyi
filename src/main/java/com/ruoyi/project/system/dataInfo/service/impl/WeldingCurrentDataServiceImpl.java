package com.ruoyi.project.system.dataInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.dataInfo.mapper.WeldingCurrentDataMapper;
import com.ruoyi.project.system.dataInfo.domain.WeldingCurrentData;
import com.ruoyi.project.system.dataInfo.service.IWeldingCurrentDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 焊接实时数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class WeldingCurrentDataServiceImpl implements IWeldingCurrentDataService 
{
    @Autowired
    private WeldingCurrentDataMapper weldingCurrentDataMapper;

    /**
     * 查询焊接实时数据
     * 
     * @param id 焊接实时数据ID
     * @return 焊接实时数据
     */
    @Override
    public WeldingCurrentData selectWeldingCurrentDataById(Long id)
    {
        return weldingCurrentDataMapper.selectWeldingCurrentDataById(id);
    }

    /**
     * 查询焊接实时数据列表
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 焊接实时数据
     */
    @Override
    public List<WeldingCurrentData> selectWeldingCurrentDataList(WeldingCurrentData weldingCurrentData)
    {
        return weldingCurrentDataMapper.selectWeldingCurrentDataList(weldingCurrentData);
    }

    /**
     * 新增焊接实时数据
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 结果
     */
    @Override
    public int insertWeldingCurrentData(WeldingCurrentData weldingCurrentData)
    {
        return weldingCurrentDataMapper.insertWeldingCurrentData(weldingCurrentData);
    }

    /**
     * 修改焊接实时数据
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 结果
     */
    @Override
    public int updateWeldingCurrentData(WeldingCurrentData weldingCurrentData)
    {
        return weldingCurrentDataMapper.updateWeldingCurrentData(weldingCurrentData);
    }

    /**
     * 删除焊接实时数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWeldingCurrentDataByIds(String ids)
    {
        return weldingCurrentDataMapper.deleteWeldingCurrentDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除焊接实时数据信息
     * 
     * @param id 焊接实时数据ID
     * @return 结果
     */
    @Override
    public int deleteWeldingCurrentDataById(Long id)
    {
        return weldingCurrentDataMapper.deleteWeldingCurrentDataById(id);
    }

    @Override
    public List getAllCurrentData(){
        return weldingCurrentDataMapper.getAllCurrentData();
    }

    @Override
    public List getWeldingQualityNum(){
        return weldingCurrentDataMapper.getWeldingQualityNum();
    }

    @Override
    public List getHistoryQuality(){
        return weldingCurrentDataMapper.getHistoryQuality();
    }
}
