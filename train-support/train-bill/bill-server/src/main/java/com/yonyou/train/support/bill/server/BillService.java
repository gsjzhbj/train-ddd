package com.yonyou.train.support.bill.server;

import com.yonyou.train.support.bill.api.IBillService;
import org.springframework.stereotype.Service;

@Service
public class BillService implements IBillService {
    public void bill(String billJson){
        System.out.println("bill");
    }
}
