package com.ruoyi.project.system.vechicleproduction.mapper;

import java.util.List;
import com.ruoyi.project.system.vechicleproduction.domain.DsVechicleproduction;

/**
 * 生产信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsVechicleproductionMapper 
{
    /**
     * 查询生产信息
     * 
     * @param vechicleproductionid 生产信息ID
     * @return 生产信息
     */
    public DsVechicleproduction selectDsVechicleproductionById(Long vechicleproductionid);

    /**
     * 查询生产信息列表
     * 
     * @param dsVechicleproduction 生产信息
     * @return 生产信息集合
     */
    public List<DsVechicleproduction> selectDsVechicleproductionList(DsVechicleproduction dsVechicleproduction);

    /**
     * 新增生产信息
     * 
     * @param dsVechicleproduction 生产信息
     * @return 结果
     */
    public int insertDsVechicleproduction(DsVechicleproduction dsVechicleproduction);

    /**
     * 修改生产信息
     * 
     * @param dsVechicleproduction 生产信息
     * @return 结果
     */
    public int updateDsVechicleproduction(DsVechicleproduction dsVechicleproduction);

    /**
     * 删除生产信息
     * 
     * @param vechicleproductionid 生产信息ID
     * @return 结果
     */
    public int deleteDsVechicleproductionById(Long vechicleproductionid);

    /**
     * 批量删除生产信息
     * 
     * @param vechicleproductionids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsVechicleproductionByIds(String[] vechicleproductionids);
}
