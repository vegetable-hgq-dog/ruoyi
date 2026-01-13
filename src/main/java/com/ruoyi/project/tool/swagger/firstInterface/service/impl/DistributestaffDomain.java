package com.ruoyi.project.tool.swagger.firstInterface.service.impl;

import com.ruoyi.project.tool.swagger.firstInterface.domain.distributestaffsDomain;
import com.ruoyi.project.tool.swagger.firstInterface.mapper.DistributestaffDomainMapper;
import com.ruoyi.project.tool.swagger.firstInterface.service.IDistributestaffsDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributestaffDomain implements IDistributestaffsDomain {

    @Autowired
    private DistributestaffDomainMapper distributestaffDomainMapper;

    @Override
    public int insertDistributestaffsDomain(distributestaffsDomain distributestaffsDomain){
        return distributestaffDomainMapper.insertDistributestaffsDomain(distributestaffsDomain);
    }

    @Override
    public int deleteCarriersDomainByCondition(distributestaffsDomain distributestaffsDomain){
        return distributestaffDomainMapper.deleteCarriersDomainByCondition(distributestaffsDomain);
    }
}
