package com.yonyou.train.order.application.service;

import com.yonyou.train.order.domain.service.OrderDomainService;
import com.yonyou.train.order.interfaces.IOrderService;
import com.yonyou.train.order.interfaces.assembler.OrderAssembler;
import com.yonyou.train.order.domain.vo.OrderVo;
import com.yonyou.train.pay.api.IPayService;
import com.yonyou.train.pay.domain.vo.PayInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 订单服务层
 */
@Service
public class OrderService implements IOrderService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private OrderAssembler orderAssembler;

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private IPayService payService;

    @Override
    public void createOrder(OrderVo orderVo) {
        logger.debug("order vo to order entity,then save.");
        orderDomainService.createOrder(orderAssembler.convertToOrderEntity(orderVo));
        logger.debug("finished.");
    }

    @Override
    public void receiveOrder(OrderVo orderVo) {

    }

    @Override
    public void startOrder(OrderVo orderVo) {
        //1、开始订单 2、开始计费
        expensesService.cost();
    }

    @Override
    public void modifyOrder(OrderVo orderVo) {

    }

    @Override
    public void viewOrder(OrderVo orderVo) {

    }

    @Override
    public void payOrder(OrderVo orderVo) {

    }

    @Override
    public void evaluateOrder(OrderVo orderVo) {

    }

    @Override
    public void finishOrder(OrderVo orderVo) {
        PayInfoVO payInfoVO = new PayInfoVO();
        try {
            payService.createPayInfo(payInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
