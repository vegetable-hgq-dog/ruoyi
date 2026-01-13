package com.ruoyi.project.system.vechicleproduction.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.vechicleproduction.mapper.DsVechicleproductionMapper;
import com.ruoyi.project.system.vechicleproduction.domain.DsVechicleproduction;
import com.ruoyi.project.system.vechicleproduction.service.IDsVechicleproductionService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 生产信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsVechicleproductionServiceImpl implements IDsVechicleproductionService 
{
    @Autowired
    private DsVechicleproductionMapper dsVechicleproductionMapper;

    /**
     * 查询生产信息
     * 
     * @param vechicleproductionid 生产信息ID
     * @return 生产信息
     */
    @Override
    public DsVechicleproduction selectDsVechicleproductionById(Long vechicleproductionid)
    {
        return dsVechicleproductionMapper.selectDsVechicleproductionById(vechicleproductionid);
    }

    /**
     * 查询生产信息列表
     * 
     * @param dsVechicleproduction 生产信息
     * @return 生产信息
     */
    @Override
    public List<DsVechicleproduction> selectDsVechicleproductionList(DsVechicleproduction dsVechicleproduction)
    {
        return dsVechicleproductionMapper.selectDsVechicleproductionList(dsVechicleproduction);
    }

    /**
     * 新增生产信息
     * 
     * @param dsVechicleproduction 生产信息
     * @return 结果
     */
    @Override
    public int insertDsVechicleproduction(DsVechicleproduction dsVechicleproduction)
    {
        return dsVechicleproductionMapper.insertDsVechicleproduction(dsVechicleproduction);
    }

    /**
     * 修改生产信息
     * 
     * @param dsVechicleproduction 生产信息
     * @return 结果
     */
    @Override
    public int updateDsVechicleproduction(DsVechicleproduction dsVechicleproduction)
    {
        return dsVechicleproductionMapper.updateDsVechicleproduction(dsVechicleproduction);
    }

    /**
     * 删除生产信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsVechicleproductionByIds(String ids)
    {
        return dsVechicleproductionMapper.deleteDsVechicleproductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除生产信息信息
     * 
     * @param vechicleproductionid 生产信息ID
     * @return 结果
     */
    @Override
    public int deleteDsVechicleproductionById(Long vechicleproductionid)
    {
        return dsVechicleproductionMapper.deleteDsVechicleproductionById(vechicleproductionid);
    }
}
