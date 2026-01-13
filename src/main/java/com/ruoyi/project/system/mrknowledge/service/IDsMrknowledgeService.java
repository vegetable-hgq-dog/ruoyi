package com.ruoyi.project.system.mrknowledge.service;

import java.util.List;
import com.ruoyi.project.system.mrknowledge.domain.DsMrknowledge;

/**
 * 制造需求Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsMrknowledgeService 
{
    /**
     * 查询制造需求
     * 
     * @param mritemid 制造需求ID
     * @return 制造需求
     */
    public DsMrknowledge selectDsMrknowledgeById(Long mritemid);

    /**
     * 查询制造需求列表
     * 
     * @param dsMrknowledge 制造需求
     * @return 制造需求集合
     */
    public List<DsMrknowledge> selectDsMrknowledgeList(DsMrknowledge dsMrknowledge);

    /**
     * 新增制造需求
     * 
     * @param dsMrknowledge 制造需求
     * @return 结果
     */
    public int insertDsMrknowledge(DsMrknowledge dsMrknowledge);

    /**
     * 修改制造需求
     * 
     * @param dsMrknowledge 制造需求
     * @return 结果
     */
    public int updateDsMrknowledge(DsMrknowledge dsMrknowledge);

    /**
     * 批量删除制造需求
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsMrknowledgeByIds(String ids);

    /**
     * 删除制造需求信息
     * 
     * @param mritemid 制造需求ID
     * @return 结果
     */
    public int deleteDsMrknowledgeById(Long mritemid);
}
