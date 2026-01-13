package com.ruoyi.project.manufacture.robotAlert.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.manufacture.robotAlert.mapper.OdsMb050ExterrorRdsVDiMapper;
import com.ruoyi.project.manufacture.robotAlert.domain.OdsMb050ExterrorRdsVDi;
import com.ruoyi.project.manufacture.robotAlert.service.IOdsMb050ExterrorRdsVDiService;
import com.ruoyi.common.utils.text.Convert;

/**
 * robot_alertService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Service
public class OdsMb050ExterrorRdsVDiServiceImpl implements IOdsMb050ExterrorRdsVDiService 
{
    @Autowired
    private OdsMb050ExterrorRdsVDiMapper odsMb050ExterrorRdsVDiMapper;

    /**
     * 查询robot_alert
     * 
     * @param autoid robot_alertID
     * @return robot_alert
     */
    @Override
    public OdsMb050ExterrorRdsVDi selectOdsMb050ExterrorRdsVDiById(Long autoid)
    {
        return odsMb050ExterrorRdsVDiMapper.selectOdsMb050ExterrorRdsVDiById(autoid);
    }

    /**
     * 查询robot_alert列表
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return robot_alert
     */
    @Override
    public List<OdsMb050ExterrorRdsVDi> selectOdsMb050ExterrorRdsVDiList(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        return odsMb050ExterrorRdsVDiMapper.selectOdsMb050ExterrorRdsVDiList(odsMb050ExterrorRdsVDi);
    }

    /**
     * 新增robot_alert
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return 结果
     */
    @Override
    public int insertOdsMb050ExterrorRdsVDi(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        return odsMb050ExterrorRdsVDiMapper.insertOdsMb050ExterrorRdsVDi(odsMb050ExterrorRdsVDi);
    }

    /**
     * 修改robot_alert
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return 结果
     */
    @Override
    public int updateOdsMb050ExterrorRdsVDi(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi)
    {
        return odsMb050ExterrorRdsVDiMapper.updateOdsMb050ExterrorRdsVDi(odsMb050ExterrorRdsVDi);
    }

    /**
     * 删除robot_alert对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOdsMb050ExterrorRdsVDiByIds(String ids)
    {
        return odsMb050ExterrorRdsVDiMapper.deleteOdsMb050ExterrorRdsVDiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除robot_alert信息
     * 
     * @param autoid robot_alertID
     * @return 结果
     */
    @Override
    public int deleteOdsMb050ExterrorRdsVDiById(Long autoid)
    {
        return odsMb050ExterrorRdsVDiMapper.deleteOdsMb050ExterrorRdsVDiById(autoid);
    }
}
