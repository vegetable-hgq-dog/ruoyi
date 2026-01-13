package com.ruoyi.project.system.supplyInf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.supplyInf.mapper.SupplyTableMapper;
import com.ruoyi.project.system.supplyInf.domain.SupplyTable;
import com.ruoyi.project.system.supplyInf.service.ISupplyTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 供应信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Service
public class SupplyTableServiceImpl implements ISupplyTableService 
{
    @Autowired
    private SupplyTableMapper supplyTableMapper;

    /**
     * 查询供应信息
     * 
     * @param id 供应信息ID
     * @return 供应信息
     */
    @Override
    public SupplyTable selectSupplyTableById(Long id)
    {
        return supplyTableMapper.selectSupplyTableById(id);
    }

    /**
     * 查询供应信息列表
     * 
     * @param supplyTable 供应信息
     * @return 供应信息
     */
    @Override
    public List<SupplyTable> selectSupplyTableList(SupplyTable supplyTable)
    {
        return supplyTableMapper.selectSupplyTableList(supplyTable);
    }

    /**
     * 新增供应信息
     * 
     * @param supplyTable 供应信息
     * @return 结果
     */
    @Override
    public int insertSupplyTable(SupplyTable supplyTable)
    {
        return supplyTableMapper.insertSupplyTable(supplyTable);
    }

    /**
     * 修改供应信息
     * 
     * @param supplyTable 供应信息
     * @return 结果
     */
    @Override
    public int updateSupplyTable(SupplyTable supplyTable)
    {
        return supplyTableMapper.updateSupplyTable(supplyTable);
    }

    /**
     * 删除供应信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSupplyTableByIds(String ids)
    {
        return supplyTableMapper.deleteSupplyTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应信息信息
     * 
     * @param id 供应信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplyTableById(Long id)
    {
        return supplyTableMapper.deleteSupplyTableById(id);
    }

    public List getAllSupplyData(){
        return supplyTableMapper.getAllSupplyData();
    }
}
