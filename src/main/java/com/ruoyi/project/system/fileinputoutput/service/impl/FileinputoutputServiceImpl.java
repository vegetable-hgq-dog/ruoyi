package com.ruoyi.project.system.fileinputoutput.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.fileinputoutput.mapper.FileinputoutputMapper;
import com.ruoyi.project.system.fileinputoutput.domain.Fileinputoutput;
import com.ruoyi.project.system.fileinputoutput.service.IFileinputoutputService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文件导入导出测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
@Service
public class FileinputoutputServiceImpl implements IFileinputoutputService 
{
    @Autowired
    private FileinputoutputMapper fileinputoutputMapper;

    /**
     * 查询文件导入导出测试
     * 
     * @param fileid 文件导入导出测试ID
     * @return 文件导入导出测试
     */
    @Override
    public Fileinputoutput selectFileinputoutputById(Long fileid)
    {
        return fileinputoutputMapper.selectFileinputoutputById(fileid);
    }

    /**
     * 查询文件导入导出测试列表
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 文件导入导出测试
     */
    @Override
    public List<Fileinputoutput> selectFileinputoutputList(Fileinputoutput fileinputoutput)
    {
        return fileinputoutputMapper.selectFileinputoutputList(fileinputoutput);
    }

    /**
     * 新增文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    @Override
    public int insertFileinputoutput(Fileinputoutput fileinputoutput)
    {
        return fileinputoutputMapper.insertFileinputoutput(fileinputoutput);
    }

    /**
     * 修改文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    @Override
    public int updateFileinputoutput(Fileinputoutput fileinputoutput)
    {
        return fileinputoutputMapper.updateFileinputoutput(fileinputoutput);
    }

    /**
     * 删除文件导入导出测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFileinputoutputByIds(String ids)
    {
        return fileinputoutputMapper.deleteFileinputoutputByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件导入导出测试信息
     * 
     * @param fileid 文件导入导出测试ID
     * @return 结果
     */
    @Override
    public int deleteFileinputoutputById(Long fileid)
    {
        return fileinputoutputMapper.deleteFileinputoutputById(fileid);
    }
}
