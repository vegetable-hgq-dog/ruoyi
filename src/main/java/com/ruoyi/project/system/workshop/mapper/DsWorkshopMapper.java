package com.ruoyi.project.system.workshop.mapper;

import java.util.List;
import com.ruoyi.project.system.workshop.domain.DsWorkshop;

/**
 * 车间信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsWorkshopMapper 
{
    /**
     * 查询车间信息
     * 
     * @param workshopid 车间信息ID
     * @return 车间信息
     */
    public DsWorkshop selectDsWorkshopById(Long workshopid);

    /**
     * 查询车间信息列表
     * 
     * @param dsWorkshop 车间信息
     * @return 车间信息集合
     */
    public List<DsWorkshop> selectDsWorkshopList(DsWorkshop dsWorkshop);

    /**
     * 新增车间信息
     * 
     * @param dsWorkshop 车间信息
     * @return 结果
     */
    public int insertDsWorkshop(DsWorkshop dsWorkshop);

    /**
     * 修改车间信息
     * 
     * @param dsWorkshop 车间信息
     * @return 结果
     */
    public int updateDsWorkshop(DsWorkshop dsWorkshop);

    /**
     * 删除车间信息
     * 
     * @param workshopid 车间信息ID
     * @return 结果
     */
    public int deleteDsWorkshopById(Long workshopid);

    /**
     * 批量删除车间信息
     * 
     * @param workshopids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsWorkshopByIds(String[] workshopids);
}
