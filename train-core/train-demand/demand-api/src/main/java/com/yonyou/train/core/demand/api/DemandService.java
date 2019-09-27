package com.yonyou.train.core.demand.api;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.train.core.demand.constant.AppInfoConstant;
import com.yonyou.train.core.demand.domain.vo.DemandVO;

/***
 * 需求服务
 */
//@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface DemandService {
    /***乘客发送需求单***/
    void sendDemand(DemandVO demandVO);
    /***乘客查询需求单***/
    DemandVO getDemandById(String id);
}
