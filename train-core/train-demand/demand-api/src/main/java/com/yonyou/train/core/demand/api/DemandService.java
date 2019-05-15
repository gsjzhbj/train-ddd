package com.yonyou.train.core.demand.api;

import com.yonyou.train.core.demand.domain.vo.DemandVO;

/***
 * 需求服务
 */
public interface DemandService {
    /***乘客发送需求单***/
    void sendDemand(DemandVO demandVO);
}
