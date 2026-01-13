package com.ruoyi.project.system.sales.service;

import java.util.List;
import com.ruoyi.project.system.sales.domain.DsSales;

/**
 * salesService接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface IDsSalesService 
{
    /**
     * 查询sales
     * 
     * @param salesid salesID
     * @return sales
     */
    public DsSales selectDsSalesById(Long salesid);

    /**
     * 查询sales列表
     * 
     * @param dsSales sales
     * @return sales集合
     */
    public List<DsSales> selectDsSalesList(DsSales dsSales);

    /**
     * 新增sales
     * 
     * @param dsSales sales
     * @return 结果
     */
    public int insertDsSales(DsSales dsSales);

    /**
     * 修改sales
     * 
     * @param dsSales sales
     * @return 结果
     */
    public int updateDsSales(DsSales dsSales);

    /**
     * 批量删除sales
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsSalesByIds(String ids);

    /**
     * 删除sales信息
     * 
     * @param salesid salesID
     * @return 结果
     */
    public int deleteDsSalesById(Long salesid);
}
