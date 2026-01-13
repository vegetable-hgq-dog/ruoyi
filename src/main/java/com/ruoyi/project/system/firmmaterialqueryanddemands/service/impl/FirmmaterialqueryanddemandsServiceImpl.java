package com.ruoyi.project.system.firmmaterialqueryanddemands.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmmaterialqueryanddemands.mapper.FirmmaterialqueryanddemandsMapper;
import com.ruoyi.project.system.firmmaterialqueryanddemands.domain.Firmmaterialqueryanddemands;
import com.ruoyi.project.system.firmmaterialqueryanddemands.service.IFirmmaterialqueryanddemandsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 需求数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Service
public class FirmmaterialqueryanddemandsServiceImpl implements IFirmmaterialqueryanddemandsService 
{
    @Autowired
    private FirmmaterialqueryanddemandsMapper firmmaterialqueryanddemandsMapper;

    /**
     * 查询需求数据
     * 
     * @param id 需求数据ID
     * @return 需求数据
     */
    @Override
    public Firmmaterialqueryanddemands selectFirmmaterialqueryanddemandsById(Long id)
    {
        return firmmaterialqueryanddemandsMapper.selectFirmmaterialqueryanddemandsById(id);
    }

    /**
     * 查询需求数据列表
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 需求数据
     */
    @Override
    public List<Firmmaterialqueryanddemands> selectFirmmaterialqueryanddemandsList(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        return firmmaterialqueryanddemandsMapper.selectFirmmaterialqueryanddemandsList(firmmaterialqueryanddemands);
    }

    /**
     * 新增需求数据
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 结果
     */
    @Override
    public int insertFirmmaterialqueryanddemands(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        return firmmaterialqueryanddemandsMapper.insertFirmmaterialqueryanddemands(firmmaterialqueryanddemands);
    }

    /**
     * 修改需求数据
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 结果
     */
    @Override
    public int updateFirmmaterialqueryanddemands(Firmmaterialqueryanddemands firmmaterialqueryanddemands)
    {
        return firmmaterialqueryanddemandsMapper.updateFirmmaterialqueryanddemands(firmmaterialqueryanddemands);
    }

    /**
     * 删除需求数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmmaterialqueryanddemandsByIds(String ids)
    {
        return firmmaterialqueryanddemandsMapper.deleteFirmmaterialqueryanddemandsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除需求数据信息
     * 
     * @param id 需求数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmmaterialqueryanddemandsById(Long id)
    {
        return firmmaterialqueryanddemandsMapper.deleteFirmmaterialqueryanddemandsById(id);
    }
}
