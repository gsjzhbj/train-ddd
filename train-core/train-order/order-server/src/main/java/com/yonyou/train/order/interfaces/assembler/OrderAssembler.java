package com.yonyou.train.order.interfaces.assembler;

import com.yonyou.train.order.domain.entity.OrderEntity;
import com.yonyou.train.order.domain.vo.OrderVo;
import org.springframework.stereotype.Component;

/***
 * 订单装配器
 */
@Component
public class OrderAssembler {
    public OrderEntity convertToOrderEntity(OrderVo orderVo) {
        return null;
    }
    public OrderVo converToOrderVo(OrderEntity orderEntity){
        return null;
    }
}
