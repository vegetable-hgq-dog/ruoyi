package com.ruoyi.project.system.fileinputoutput.mapper;

import java.util.List;
import com.ruoyi.project.system.fileinputoutput.domain.Fileinputoutput;

/**
 * 文件导入导出测试Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public interface FileinputoutputMapper 
{
    /**
     * 查询文件导入导出测试
     * 
     * @param fileid 文件导入导出测试ID
     * @return 文件导入导出测试
     */
    public Fileinputoutput selectFileinputoutputById(Long fileid);

    /**
     * 查询文件导入导出测试列表
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 文件导入导出测试集合
     */
    public List<Fileinputoutput> selectFileinputoutputList(Fileinputoutput fileinputoutput);

    /**
     * 新增文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    public int insertFileinputoutput(Fileinputoutput fileinputoutput);

    /**
     * 修改文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    public int updateFileinputoutput(Fileinputoutput fileinputoutput);

    /**
     * 删除文件导入导出测试
     * 
     * @param fileid 文件导入导出测试ID
     * @return 结果
     */
    public int deleteFileinputoutputById(Long fileid);

    /**
     * 批量删除文件导入导出测试
     * 
     * @param fileids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFileinputoutputByIds(String[] fileids);
}
