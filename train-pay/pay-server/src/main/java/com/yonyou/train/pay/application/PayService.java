package com.yonyou.train.pay.application;

import com.yonyou.train.pay.api.IPayService;
import com.yonyou.train.pay.domain.vo.PayInfoVO;
import com.yonyou.train.pay.infrastructrue.repository.PayRepository;
import com.yonyou.train.support.bill.api.IBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayService implements IPayService {
    @Autowired
    private IBillService billService;
    @Autowired
    private PayRepository payRepository;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public String createPayInfo(PayInfoVO payInfoVO) throws Exception {
        logger.debug("createPayInfo");
        payRepository.createPayInfo();
        billService.bill("pay");
        return null;
    }
}
