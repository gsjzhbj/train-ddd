package com.yonyou.train.pay.api;

import com.wordnik.swagger.annotations.ApiOperation;
import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiParam;
import com.yonyou.cloud.mwclient.servmeta.annotation.ApiReturnValue;
import com.yonyou.train.pay.constant.AppInfoConstant;
import com.yonyou.train.pay.domain.vo.PayInfoVO;

@RemoteCall(AppInfoConstant.APP_INF_PAY)
public interface IPayService {

    /**
     * 根据订单创建支付单
     *
     * @param  payInfo
     * @return 支付单
     */
    @ApiOperation("根据订单创建支付单")
    public @ApiReturnValue(name="支付单", description="根据订单创建支付单，支付单详情请查阅支付信息。") String createPayInfo(@ApiParam(name="支付单", required=true, description="支付单，订单信息，价格信息，支付流水等", exampleValue="payInfo") PayInfoVO payInfo) throws Exception;
}
