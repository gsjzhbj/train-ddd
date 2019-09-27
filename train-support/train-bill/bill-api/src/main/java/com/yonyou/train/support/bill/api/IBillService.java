package com.yonyou.train.support.bill.api;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.train.support.bill.constants.AppInfoConstant;
@RemoteCall(AppInfoConstant.APP_INF_BILL)
public interface IBillService {
    void bill(String billJson);
}
