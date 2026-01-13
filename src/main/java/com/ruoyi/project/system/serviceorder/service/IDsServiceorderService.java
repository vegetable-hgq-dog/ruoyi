package com.ruoyi.project.system.serviceorder.service;

import java.util.List;
import com.ruoyi.project.system.serviceorder.domain.DsServiceorder;

/**
 * serviceorderService接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface IDsServiceorderService 
{
    /**
     * 查询serviceorder
     * 
     * @param serviceorderid serviceorderID
     * @return serviceorder
     */
    public DsServiceorder selectDsServiceorderById(Long serviceorderid);

    /**
     * 查询serviceorder列表
     * 
     * @param dsServiceorder serviceorder
     * @return serviceorder集合
     */
    public List<DsServiceorder> selectDsServiceorderList(DsServiceorder dsServiceorder);

    /**
     * 新增serviceorder
     * 
     * @param dsServiceorder serviceorder
     * @return 结果
     */
    public int insertDsServiceorder(DsServiceorder dsServiceorder);

    /**
     * 修改serviceorder
     * 
     * @param dsServiceorder serviceorder
     * @return 结果
     */
    public int updateDsServiceorder(DsServiceorder dsServiceorder);

    /**
     * 批量删除serviceorder
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsServiceorderByIds(String ids);

    /**
     * 删除serviceorder信息
     * 
     * @param serviceorderid serviceorderID
     * @return 结果
     */
    public int deleteDsServiceorderById(Long serviceorderid);
}
