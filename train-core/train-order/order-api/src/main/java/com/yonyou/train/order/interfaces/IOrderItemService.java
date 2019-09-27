package com.yonyou.train.order.interfaces;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.train.order.constant.AppInfoConstant;
import com.yonyou.train.order.domain.vo.OrderVo;

@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IOrderItemService {
    /***创建订单***/
    void createOrderItems(OrderVo orderVo);
}
