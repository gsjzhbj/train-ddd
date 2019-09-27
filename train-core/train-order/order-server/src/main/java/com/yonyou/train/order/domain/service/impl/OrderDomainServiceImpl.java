package com.yonyou.train.order.domain.service.impl;

import com.yonyou.train.order.domain.entity.OrderEntity;
import com.yonyou.train.order.domain.service.OrderDomainService;
import com.yonyou.train.order.infrastructrue.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderDomainServiceImpl implements OrderDomainService {
    private OrderRepository orderRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void createOrder(OrderEntity orderEntity) {
        logger.debug("createOrder");
        orderRepository.saveOrder(orderEntity);
    }

    @Override
    public void receiveOrder(OrderEntity orderEntity) {

    }

    @Override
    public void startOrder(OrderEntity orderEntity) {

    }

    @Override
    public void modifyOrder(OrderEntity orderEntity) {

    }

    @Override
    public void viewOrder(OrderEntity orderEntity) {

    }

    @Override
    public void payOrder(OrderEntity orderEntity) {

    }

    @Override
    public void finishOrder(OrderEntity orderEntity) {

    }
}
