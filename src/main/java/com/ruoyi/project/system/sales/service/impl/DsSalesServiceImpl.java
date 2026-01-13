package com.ruoyi.project.system.sales.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.sales.mapper.DsSalesMapper;
import com.ruoyi.project.system.sales.domain.DsSales;
import com.ruoyi.project.system.sales.service.IDsSalesService;
import com.ruoyi.common.utils.text.Convert;

/**
 * salesService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsSalesServiceImpl implements IDsSalesService 
{
    @Autowired
    private DsSalesMapper dsSalesMapper;

    /**
     * 查询sales
     * 
     * @param salesid salesID
     * @return sales
     */
    @Override
    public DsSales selectDsSalesById(Long salesid)
    {
        return dsSalesMapper.selectDsSalesById(salesid);
    }

    /**
     * 查询sales列表
     * 
     * @param dsSales sales
     * @return sales
     */
    @Override
    public List<DsSales> selectDsSalesList(DsSales dsSales)
    {
        return dsSalesMapper.selectDsSalesList(dsSales);
    }

    /**
     * 新增sales
     * 
     * @param dsSales sales
     * @return 结果
     */
    @Override
    public int insertDsSales(DsSales dsSales)
    {
        return dsSalesMapper.insertDsSales(dsSales);
    }

    /**
     * 修改sales
     * 
     * @param dsSales sales
     * @return 结果
     */
    @Override
    public int updateDsSales(DsSales dsSales)
    {
        return dsSalesMapper.updateDsSales(dsSales);
    }

    /**
     * 删除sales对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsSalesByIds(String ids)
    {
        return dsSalesMapper.deleteDsSalesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除sales信息
     * 
     * @param salesid salesID
     * @return 结果
     */
    @Override
    public int deleteDsSalesById(Long salesid)
    {
        return dsSalesMapper.deleteDsSalesById(salesid);
    }
}
