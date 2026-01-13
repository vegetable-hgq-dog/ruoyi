package com.ruoyi.project.manufacture.weldpara.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.manufacture.weldpara.mapper.DsWeldingParaMapper;
import com.ruoyi.project.manufacture.weldpara.domain.DsWeldingPara;
import com.ruoyi.project.manufacture.weldpara.service.IDsWeldingParaService;
import com.ruoyi.common.utils.text.Convert;

/**
 * weld_paraService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Service
public class DsWeldingParaServiceImpl implements IDsWeldingParaService 
{
    @Autowired
    private DsWeldingParaMapper dsWeldingParaMapper;

    /**
     * 查询weld_para
     * 
     * @param autoId weld_paraID
     * @return weld_para
     */
    @Override
    public DsWeldingPara selectDsWeldingParaById(Long autoId)
    {
        return dsWeldingParaMapper.selectDsWeldingParaById(autoId);
    }

    /**
     * 查询weld_para列表
     * 
     * @param dsWeldingPara weld_para
     * @return weld_para
     */
    @Override
    public List<DsWeldingPara> selectDsWeldingParaList(DsWeldingPara dsWeldingPara)
    {
        return dsWeldingParaMapper.selectDsWeldingParaList(dsWeldingPara);
    }

    /**
     * 新增weld_para
     * 
     * @param dsWeldingPara weld_para
     * @return 结果
     */
    @Override
    public int insertDsWeldingPara(DsWeldingPara dsWeldingPara)
    {
        return dsWeldingParaMapper.insertDsWeldingPara(dsWeldingPara);
    }

    /**
     * 修改weld_para
     * 
     * @param dsWeldingPara weld_para
     * @return 结果
     */
    @Override
    public int updateDsWeldingPara(DsWeldingPara dsWeldingPara)
    {
        return dsWeldingParaMapper.updateDsWeldingPara(dsWeldingPara);
    }

    /**
     * 删除weld_para对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingParaByIds(String ids)
    {
        return dsWeldingParaMapper.deleteDsWeldingParaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除weld_para信息
     * 
     * @param autoId weld_paraID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingParaById(Long autoId)
    {
        return dsWeldingParaMapper.deleteDsWeldingParaById(autoId);
    }
}
