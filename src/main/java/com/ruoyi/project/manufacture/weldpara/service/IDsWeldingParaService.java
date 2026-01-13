package com.ruoyi.project.manufacture.weldpara.service;

import java.util.List;
import com.ruoyi.project.manufacture.weldpara.domain.DsWeldingPara;

/**
 * weld_paraService接口
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public interface IDsWeldingParaService 
{
    /**
     * 查询weld_para
     * 
     * @param autoId weld_paraID
     * @return weld_para
     */
    public DsWeldingPara selectDsWeldingParaById(Long autoId);

    /**
     * 查询weld_para列表
     * 
     * @param dsWeldingPara weld_para
     * @return weld_para集合
     */
    public List<DsWeldingPara> selectDsWeldingParaList(DsWeldingPara dsWeldingPara);

    /**
     * 新增weld_para
     * 
     * @param dsWeldingPara weld_para
     * @return 结果
     */
    public int insertDsWeldingPara(DsWeldingPara dsWeldingPara);

    /**
     * 修改weld_para
     * 
     * @param dsWeldingPara weld_para
     * @return 结果
     */
    public int updateDsWeldingPara(DsWeldingPara dsWeldingPara);

    /**
     * 批量删除weld_para
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsWeldingParaByIds(String ids);

    /**
     * 删除weld_para信息
     * 
     * @param autoId weld_paraID
     * @return 结果
     */
    public int deleteDsWeldingParaById(Long autoId);
}
