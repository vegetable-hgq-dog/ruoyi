package com.ruoyi.project.system.weldingParameterInfo.service;

import java.util.List;
import com.ruoyi.project.system.weldingParameterInfo.domain.DsWeldingSpotParameter;

/**
 * 焊点参数Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IDsWeldingSpotParameterService 
{
    /**
     * 查询焊点参数
     * 
     * @param dsweldingid 焊点参数ID
     * @return 焊点参数
     */
    public DsWeldingSpotParameter selectDsWeldingSpotParameterById(Long dsweldingid);

    /**
     * 查询焊点参数列表
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 焊点参数集合
     */
    public List<DsWeldingSpotParameter> selectDsWeldingSpotParameterList(DsWeldingSpotParameter dsWeldingSpotParameter);

    /**
     * 新增焊点参数
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 结果
     */
    public int insertDsWeldingSpotParameter(DsWeldingSpotParameter dsWeldingSpotParameter);

    /**
     * 修改焊点参数
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 结果
     */
    public int updateDsWeldingSpotParameter(DsWeldingSpotParameter dsWeldingSpotParameter);

    /**
     * 批量删除焊点参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsWeldingSpotParameterByIds(String ids);

    /**
     * 删除焊点参数信息
     * 
     * @param dsweldingid 焊点参数ID
     * @return 结果
     */
    public int deleteDsWeldingSpotParameterById(Long dsweldingid);

    public List<DsWeldingSpotParameter> getAllWeldingSpotPara();
}
