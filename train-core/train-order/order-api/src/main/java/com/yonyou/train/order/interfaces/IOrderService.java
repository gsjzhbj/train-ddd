package com.yonyou.train.order.interfaces;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.train.order.constant.AppInfoConstant;
import com.yonyou.train.order.domain.vo.OrderVo;

/***
 * 订单服务层
 */
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface IOrderService {

    /***创建订单***/
    void createOrder(OrderVo orderVo);
    /***接收订单***/
    void receiveOrder(OrderVo orderVo);
    /***开始订单***/
    void startOrder(OrderVo orderVo);
    /***变更订单***/
    void modifyOrder(OrderVo orderVo);
    /***查看订单***/
    void viewOrder(OrderVo orderVo);
    /***支付订单***/
    void payOrder(OrderVo orderVo);
    /***评价***/
    void evaluateOrder(OrderVo orderVo,String info);
    /***完成订单 2019-08-12***/
    void finishOrder(OrderVo orderVo);
}
