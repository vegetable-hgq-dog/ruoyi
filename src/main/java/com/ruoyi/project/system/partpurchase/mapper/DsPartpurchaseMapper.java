package com.ruoyi.project.system.partpurchase.mapper;

import java.util.List;
import com.ruoyi.project.system.partpurchase.domain.DsPartpurchase;

/**
 * partpurchaseMapper接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface DsPartpurchaseMapper 
{
    /**
     * 查询partpurchase
     * 
     * @param purchaseid partpurchaseID
     * @return partpurchase
     */
    public DsPartpurchase selectDsPartpurchaseById(Integer purchaseid);

    /**
     * 查询partpurchase列表
     * 
     * @param dsPartpurchase partpurchase
     * @return partpurchase集合
     */
    public List<DsPartpurchase> selectDsPartpurchaseList(DsPartpurchase dsPartpurchase);

    /**
     * 新增partpurchase
     * 
     * @param dsPartpurchase partpurchase
     * @return 结果
     */
    public int insertDsPartpurchase(DsPartpurchase dsPartpurchase);

    /**
     * 修改partpurchase
     * 
     * @param dsPartpurchase partpurchase
     * @return 结果
     */
    public int updateDsPartpurchase(DsPartpurchase dsPartpurchase);

    /**
     * 删除partpurchase
     * 
     * @param purchaseid partpurchaseID
     * @return 结果
     */
    public int deleteDsPartpurchaseById(Integer purchaseid);

    /**
     * 批量删除partpurchase
     * 
     * @param purchaseids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsPartpurchaseByIds(String[] purchaseids);
}
