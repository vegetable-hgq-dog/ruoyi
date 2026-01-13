package com.ruoyi.project.system.partpurchase.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.partpurchase.mapper.DsPartpurchaseMapper;
import com.ruoyi.project.system.partpurchase.domain.DsPartpurchase;
import com.ruoyi.project.system.partpurchase.service.IDsPartpurchaseService;
import com.ruoyi.common.utils.text.Convert;

/**
 * partpurchaseService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsPartpurchaseServiceImpl implements IDsPartpurchaseService 
{
    @Autowired
    private DsPartpurchaseMapper dsPartpurchaseMapper;

    /**
     * 查询partpurchase
     * 
     * @param purchaseid partpurchaseID
     * @return partpurchase
     */
    @Override
    public DsPartpurchase selectDsPartpurchaseById(Integer purchaseid)
    {
        return dsPartpurchaseMapper.selectDsPartpurchaseById(purchaseid);
    }

    /**
     * 查询partpurchase列表
     * 
     * @param dsPartpurchase partpurchase
     * @return partpurchase
     */
    @Override
    public List<DsPartpurchase> selectDsPartpurchaseList(DsPartpurchase dsPartpurchase)
    {
        return dsPartpurchaseMapper.selectDsPartpurchaseList(dsPartpurchase);
    }

    /**
     * 新增partpurchase
     * 
     * @param dsPartpurchase partpurchase
     * @return 结果
     */
    @Override
    public int insertDsPartpurchase(DsPartpurchase dsPartpurchase)
    {
        return dsPartpurchaseMapper.insertDsPartpurchase(dsPartpurchase);
    }

    /**
     * 修改partpurchase
     * 
     * @param dsPartpurchase partpurchase
     * @return 结果
     */
    @Override
    public int updateDsPartpurchase(DsPartpurchase dsPartpurchase)
    {
        return dsPartpurchaseMapper.updateDsPartpurchase(dsPartpurchase);
    }

    /**
     * 删除partpurchase对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsPartpurchaseByIds(String ids)
    {
        return dsPartpurchaseMapper.deleteDsPartpurchaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除partpurchase信息
     * 
     * @param purchaseid partpurchaseID
     * @return 结果
     */
    @Override
    public int deleteDsPartpurchaseById(Integer purchaseid)
    {
        return dsPartpurchaseMapper.deleteDsPartpurchaseById(purchaseid);
    }
}
