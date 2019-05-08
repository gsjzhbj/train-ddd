package com.yonyou.train.order.infrastructrue.repository;

import com.yonyou.train.order.domain.entity.OrderEntity;

/***
 * 订单基础设施层服务
 */
public interface OrderRepository {
    /***保存订单***/
    void saveOrder(OrderEntity orderEntity);
    /***推送订单***/
    void pushOrder(OrderEntity orderEntity);
    /***更新订单***/
    void updateOrder(OrderEntity orderEntity);
}
