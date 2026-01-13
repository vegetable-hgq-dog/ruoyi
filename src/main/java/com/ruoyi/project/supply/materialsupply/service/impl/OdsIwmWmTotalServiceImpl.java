package com.ruoyi.project.supply.materialsupply.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.supply.materialsupply.mapper.OdsIwmWmTotalMapper;
import com.ruoyi.project.supply.materialsupply.domain.OdsIwmWmTotal;
import com.ruoyi.project.supply.materialsupply.service.IOdsIwmWmTotalService;
import com.ruoyi.common.utils.text.Convert;

/**
 * material_supplyService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-03
 */
@Service
public class OdsIwmWmTotalServiceImpl implements IOdsIwmWmTotalService 
{
    @Autowired
    private OdsIwmWmTotalMapper odsIwmWmTotalMapper;

    /**
     * 查询material_supply
     * 
     * @param autoid material_supplyID
     * @return material_supply
     */
    @Override
    public OdsIwmWmTotal selectOdsIwmWmTotalById(Long autoid)
    {
        return odsIwmWmTotalMapper.selectOdsIwmWmTotalById(autoid);
    }

    /**
     * 查询material_supply列表
     * 
     * @param odsIwmWmTotal material_supply
     * @return material_supply
     */
    @Override
    public List<OdsIwmWmTotal> selectOdsIwmWmTotalList(OdsIwmWmTotal odsIwmWmTotal)
    {
        return odsIwmWmTotalMapper.selectOdsIwmWmTotalList(odsIwmWmTotal);
    }

    /**
     * 新增material_supply
     * 
     * @param odsIwmWmTotal material_supply
     * @return 结果
     */
    @Override
    public int insertOdsIwmWmTotal(OdsIwmWmTotal odsIwmWmTotal)
    {
        return odsIwmWmTotalMapper.insertOdsIwmWmTotal(odsIwmWmTotal);
    }

    /**
     * 修改material_supply
     * 
     * @param odsIwmWmTotal material_supply
     * @return 结果
     */
    @Override
    public int updateOdsIwmWmTotal(OdsIwmWmTotal odsIwmWmTotal)
    {
        return odsIwmWmTotalMapper.updateOdsIwmWmTotal(odsIwmWmTotal);
    }

    /**
     * 删除material_supply对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOdsIwmWmTotalByIds(String ids)
    {
        return odsIwmWmTotalMapper.deleteOdsIwmWmTotalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除material_supply信息
     * 
     * @param autoid material_supplyID
     * @return 结果
     */
    @Override
    public int deleteOdsIwmWmTotalById(Long autoid)
    {
        return odsIwmWmTotalMapper.deleteOdsIwmWmTotalById(autoid);
    }
}
