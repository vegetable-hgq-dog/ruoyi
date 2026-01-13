package com.ruoyi.project.tool.swagger.firstInterface.service.impl;


import com.ruoyi.project.tool.swagger.firstInterface.domain.OrderDomain;
import com.ruoyi.project.tool.swagger.firstInterface.mapper.OrderDomainMapper;
import com.ruoyi.project.tool.swagger.firstInterface.service.IOrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDomainService implements IOrderDomainService {

    @Autowired
    private OrderDomainMapper orderDomainMapper;


    @Override
    public int insertOrderDomain(OrderDomain orderDomain){
        return orderDomainMapper.insertOrderDomain(orderDomain);
    }
}
