package com.ruoyi.project.data.designdata.component.service;

import java.util.List;
import com.ruoyi.project.data.designdata.component.domain.DsComponent;
import com.ruoyi.framework.web.domain.Ztree;

/**
 * 产品信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsComponentService 
{
    /**
     * 查询产品信息
     * 
     * @param componentid 产品信息ID
     * @return 产品信息
     */
    public DsComponent selectDsComponentById(Long componentid);

    /**
     * 查询产品信息列表
     * 
     * @param dsComponent 产品信息
     * @return 产品信息集合
     */
    public List<DsComponent> selectDsComponentList(DsComponent dsComponent);

    /**
     * 新增产品信息
     * 
     * @param dsComponent 产品信息
     * @return 结果
     */
    public int insertDsComponent(DsComponent dsComponent);

    /**
     * 修改产品信息
     * 
     * @param dsComponent 产品信息
     * @return 结果
     */
    public int updateDsComponent(DsComponent dsComponent);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsComponentByIds(String ids);

    /**
     * 删除产品信息信息
     * 
     * @param componentid 产品信息ID
     * @return 结果
     */
    public int deleteDsComponentById(Long componentid);

    /**
     * 查询产品信息树列表
     * 
     * @return 所有产品信息信息
     */
    public List<Ztree> selectDsComponentTree();
}
