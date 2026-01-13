package com.ruoyi.project.system.distributeStaffInf.mapper;

import java.util.List;


import com.ruoyi.project.system.distributeStaffInf.domain.DistributestaffsTable;

/**
 * 配送人员Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface DistributestaffsTableMapper 
{
    /**
     * 查询配送人员
     * 
     * @param id 配送人员ID
     * @return 配送人员
     */
    public DistributestaffsTable selectDistributestaffsTableById(Long id);

    /**
     * 查询配送人员列表
     * 
     * @param distributestaffsTable 配送人员
     * @return 配送人员集合
     */
    public List<DistributestaffsTable> selectDistributestaffsTableList(DistributestaffsTable distributestaffsTable);

    /**
     * 新增配送人员
     * 
     * @param distributestaffsTable 配送人员
     * @return 结果
     */
    public int insertDistributestaffsTable(DistributestaffsTable distributestaffsTable);

    /**
     * 修改配送人员
     * 
     * @param distributestaffsTable 配送人员
     * @return 结果
     */
    public int updateDistributestaffsTable(DistributestaffsTable distributestaffsTable);

    /**
     * 删除配送人员
     * 
     * @param id 配送人员ID
     * @return 结果
     */
    public int deleteDistributestaffsTableById(Long id);

    /**
     * 批量删除配送人员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDistributestaffsTableByIds(String[] ids);


    public DistributestaffsTable selectByDrivername(String drivername);

    public int updateDrivername(DistributestaffsTable distributestaffsTable);
}
