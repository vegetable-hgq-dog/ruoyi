package com.ruoyi.project.data.designdata.component.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.framework.web.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.data.designdata.component.mapper.DsComponentMapper;
import com.ruoyi.project.data.designdata.component.domain.DsComponent;
import com.ruoyi.project.data.designdata.component.service.IDsComponentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 产品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsComponentServiceImpl implements IDsComponentService 
{
    @Autowired
    private DsComponentMapper dsComponentMapper;

    /**
     * 查询产品信息
     * 
     * @param componentid 产品信息ID
     * @return 产品信息
     */
    @Override
    public DsComponent selectDsComponentById(Long componentid)
    {
        return dsComponentMapper.selectDsComponentById(componentid);
    }

    /**
     * 查询产品信息列表
     * 
     * @param dsComponent 产品信息
     * @return 产品信息
     */
    @Override
    public List<DsComponent> selectDsComponentList(DsComponent dsComponent)
    {
        return dsComponentMapper.selectDsComponentList(dsComponent);
    }

    /**
     * 新增产品信息
     * 
     * @param dsComponent 产品信息
     * @return 结果
     */
    @Override
    public int insertDsComponent(DsComponent dsComponent)
    {
        return dsComponentMapper.insertDsComponent(dsComponent);
    }

    /**
     * 修改产品信息
     * 
     * @param dsComponent 产品信息
     * @return 结果
     */
    @Override
    public int updateDsComponent(DsComponent dsComponent)
    {
        return dsComponentMapper.updateDsComponent(dsComponent);
    }

    /**
     * 删除产品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsComponentByIds(String ids)
    {
        return dsComponentMapper.deleteDsComponentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息信息
     * 
     * @param componentid 产品信息ID
     * @return 结果
     */
    @Override
    public int deleteDsComponentById(Long componentid)
    {
        return dsComponentMapper.deleteDsComponentById(componentid);
    }

    /**
     * 查询产品信息树列表
     * 
     * @return 所有产品信息信息
     */
    @Override
    public List<Ztree> selectDsComponentTree()
    {
        List<DsComponent> dsComponentList = dsComponentMapper.selectDsComponentList(new DsComponent());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (DsComponent dsComponent : dsComponentList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(dsComponent.getComponentid());
            ztree.setpId(dsComponent.getComponentfatherid());
            ztree.setName(dsComponent.getComponentname());
            ztree.setTitle(dsComponent.getComponentname());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
