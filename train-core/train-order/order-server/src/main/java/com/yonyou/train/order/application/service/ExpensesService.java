package com.yonyou.train.order.application.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ExpensesService {
    double cost(){
        return Calendar.getInstance().getTime().getTime()*10;
    }
}
