package com.yonyou.train.core.demand.domain.service;

import com.yonyou.train.core.demand.domain.entity.DemandEntity;
import com.yonyou.train.core.demand.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandDomainService {
    @Autowired
    DemandRepository demandRepository;

    public DemandEntity selectById(String id){
        return demandRepository.selectById(id);
    }
}
