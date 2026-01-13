package com.ruoyi.project.system.productline.mapper;

import java.util.List;
import com.ruoyi.project.system.productline.domain.DsProductline;

/**
 * 产线信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsProductlineMapper 
{
    /**
     * 查询产线信息
     * 
     * @param productlineid 产线信息ID
     * @return 产线信息
     */
    public DsProductline selectDsProductlineById(Long productlineid);

    /**
     * 查询产线信息列表
     * 
     * @param dsProductline 产线信息
     * @return 产线信息集合
     */
    public List<DsProductline> selectDsProductlineList(DsProductline dsProductline);

    /**
     * 新增产线信息
     * 
     * @param dsProductline 产线信息
     * @return 结果
     */
    public int insertDsProductline(DsProductline dsProductline);

    /**
     * 修改产线信息
     * 
     * @param dsProductline 产线信息
     * @return 结果
     */
    public int updateDsProductline(DsProductline dsProductline);

    /**
     * 删除产线信息
     * 
     * @param productlineid 产线信息ID
     * @return 结果
     */
    public int deleteDsProductlineById(Long productlineid);

    /**
     * 批量删除产线信息
     * 
     * @param productlineids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsProductlineByIds(String[] productlineids);
}
