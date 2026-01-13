package com.ruoyi.project.manufacture.weldinfo.mapper;

import java.util.List;
import com.ruoyi.project.manufacture.weldinfo.domain.DsWeldingCurrentData;

/**
 * weld_infoMapper接口
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public interface DsWeldingCurrentDataMapper 
{
    /**
     * 查询weld_info
     * 
     * @param autoId weld_infoID
     * @return weld_info
     */
    public DsWeldingCurrentData selectDsWeldingCurrentDataById(Long autoId);

    /**
     * 查询weld_info列表
     * 
     * @param dsWeldingCurrentData weld_info
     * @return weld_info集合
     */
    public List<DsWeldingCurrentData> selectDsWeldingCurrentDataList(DsWeldingCurrentData dsWeldingCurrentData);

    /**
     * 新增weld_info
     * 
     * @param dsWeldingCurrentData weld_info
     * @return 结果
     */
    public int insertDsWeldingCurrentData(DsWeldingCurrentData dsWeldingCurrentData);

    /**
     * 修改weld_info
     * 
     * @param dsWeldingCurrentData weld_info
     * @return 结果
     */
    public int updateDsWeldingCurrentData(DsWeldingCurrentData dsWeldingCurrentData);

    /**
     * 删除weld_info
     * 
     * @param autoId weld_infoID
     * @return 结果
     */
    public int deleteDsWeldingCurrentDataById(Long autoId);

    /**
     * 批量删除weld_info
     * 
     * @param autoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsWeldingCurrentDataByIds(String[] autoIds);
}
