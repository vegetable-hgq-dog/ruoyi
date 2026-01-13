package com.ruoyi.project.system.ktypeinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.ktypeinfo.domain.Ktypeinfo;

/**
 * 知识类型Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface KtypeinfoMapper 
{
    /**
     * 查询知识类型
     * 
     * @param ktypeid 知识类型ID
     * @return 知识类型
     */
    public Ktypeinfo selectKtypeinfoById(Long ktypeid);

    /**
     * 查询知识类型列表
     * 
     * @param ktypeinfo 知识类型
     * @return 知识类型集合
     */
    public List<Ktypeinfo> selectKtypeinfoList(Ktypeinfo ktypeinfo);

    /**
     * 新增知识类型
     * 
     * @param ktypeinfo 知识类型
     * @return 结果
     */
    public int insertKtypeinfo(Ktypeinfo ktypeinfo);

    /**
     * 修改知识类型
     * 
     * @param ktypeinfo 知识类型
     * @return 结果
     */
    public int updateKtypeinfo(Ktypeinfo ktypeinfo);

    /**
     * 删除知识类型
     * 
     * @param ktypeid 知识类型ID
     * @return 结果
     */
    public int deleteKtypeinfoById(Long ktypeid);

    /**
     * 批量删除知识类型
     * 
     * @param ktypeids 需要删除的数据ID
     * @return 结果
     */
    public int deleteKtypeinfoByIds(String[] ktypeids);

    public List<Ktypeinfo> selectKTypeName();
}
