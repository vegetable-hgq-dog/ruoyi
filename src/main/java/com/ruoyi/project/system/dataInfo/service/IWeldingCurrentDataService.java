package com.ruoyi.project.system.dataInfo.service;

import java.util.List;
import com.ruoyi.project.system.dataInfo.domain.WeldingCurrentData;

/**
 * 焊接实时数据Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IWeldingCurrentDataService 
{
    /**
     * 查询焊接实时数据
     * 
     * @param id 焊接实时数据ID
     * @return 焊接实时数据
     */
    public WeldingCurrentData selectWeldingCurrentDataById(Long id);

    /**
     * 查询焊接实时数据列表
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 焊接实时数据集合
     */
    public List<WeldingCurrentData> selectWeldingCurrentDataList(WeldingCurrentData weldingCurrentData);

    /**
     * 新增焊接实时数据
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 结果
     */
    public int insertWeldingCurrentData(WeldingCurrentData weldingCurrentData);

    /**
     * 修改焊接实时数据
     * 
     * @param weldingCurrentData 焊接实时数据
     * @return 结果
     */
    public int updateWeldingCurrentData(WeldingCurrentData weldingCurrentData);

    /**
     * 批量删除焊接实时数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeldingCurrentDataByIds(String ids);

    /**
     * 删除焊接实时数据信息
     * 
     * @param id 焊接实时数据ID
     * @return 结果
     */
    public int deleteWeldingCurrentDataById(Long id);

    public List getAllCurrentData();

    public List getWeldingQualityNum();

    public List getHistoryQuality();
}
