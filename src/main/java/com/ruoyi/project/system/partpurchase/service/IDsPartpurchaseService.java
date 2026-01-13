package com.ruoyi.project.system.partpurchase.service;

import java.util.List;
import com.ruoyi.project.system.partpurchase.domain.DsPartpurchase;

/**
 * partpurchaseService接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface IDsPartpurchaseService 
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
     * 批量删除partpurchase
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsPartpurchaseByIds(String ids);

    /**
     * 删除partpurchase信息
     * 
     * @param purchaseid partpurchaseID
     * @return 结果
     */
    public int deleteDsPartpurchaseById(Integer purchaseid);
}
