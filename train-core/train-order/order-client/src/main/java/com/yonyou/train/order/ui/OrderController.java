package com.yonyou.train.order.ui;

import com.yonyou.train.order.domain.vo.OrderVo;
import com.yonyou.train.order.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/create")
    public String createOrder(){
        OrderVo orderVo=new OrderVo();
        orderService.createOrder(orderVo);
        return "created";
    }

    @RequestMapping("/finish")
    public String finishOrder(){
        OrderVo orderVo=new OrderVo();
        orderService.finishOrder(orderVo);
        return "finished.";
    }
}
