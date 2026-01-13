package com.ruoyi.project.manufacture.robotAlert.mapper;

import java.util.List;
import com.ruoyi.project.manufacture.robotAlert.domain.OdsMb050ExterrorRdsVDi;

/**
 * robot_alertMapper接口
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public interface OdsMb050ExterrorRdsVDiMapper 
{
    /**
     * 查询robot_alert
     * 
     * @param autoid robot_alertID
     * @return robot_alert
     */
    public OdsMb050ExterrorRdsVDi selectOdsMb050ExterrorRdsVDiById(Long autoid);

    /**
     * 查询robot_alert列表
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return robot_alert集合
     */
    public List<OdsMb050ExterrorRdsVDi> selectOdsMb050ExterrorRdsVDiList(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi);

    /**
     * 新增robot_alert
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return 结果
     */
    public int insertOdsMb050ExterrorRdsVDi(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi);

    /**
     * 修改robot_alert
     * 
     * @param odsMb050ExterrorRdsVDi robot_alert
     * @return 结果
     */
    public int updateOdsMb050ExterrorRdsVDi(OdsMb050ExterrorRdsVDi odsMb050ExterrorRdsVDi);

    /**
     * 删除robot_alert
     * 
     * @param autoid robot_alertID
     * @return 结果
     */
    public int deleteOdsMb050ExterrorRdsVDiById(Long autoid);

    /**
     * 批量删除robot_alert
     * 
     * @param autoids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOdsMb050ExterrorRdsVDiByIds(String[] autoids);
}
