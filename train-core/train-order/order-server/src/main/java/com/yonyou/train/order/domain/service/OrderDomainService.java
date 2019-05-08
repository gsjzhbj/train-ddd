package com.yonyou.train.order.domain.service;

import com.yonyou.train.order.domain.entity.OrderEntity;
import com.yonyou.train.order.domain.vo.OrderVo;
import org.springframework.stereotype.Service;

public interface OrderDomainService {
    /***创建订单***/
    void createOrder(OrderEntity orderEntity);
    /***接收订单***/
    void receiveOrder(OrderEntity orderEntity);
    /***开始订单***/
    void startOrder(OrderEntity orderEntity);
    /***变更订单***/
    void modifyOrder(OrderEntity orderEntity);
    /***查看订单***/
    void viewOrder(OrderEntity orderEntity);
    /***支付订单***/
    void payOrder(OrderEntity orderEntity);
    /***结束订单***/
    void finishOrder(OrderEntity orderEntity);
}
