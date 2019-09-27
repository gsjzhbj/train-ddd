package com.yonyou.train.core.demand.application;

import com.yonyou.train.core.demand.api.DemandService;
import com.yonyou.train.core.demand.domain.entity.DemandEntity;
import com.yonyou.train.core.demand.domain.service.DemandDomainService;
import com.yonyou.train.core.demand.domain.vo.DemandVO;
import com.yonyou.train.core.demand.interfaces.assembler.DemandAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandServiceImpl implements DemandService {
    @Autowired
    DemandDomainService demandDomainService;

    @Override
    public void sendDemand(DemandVO demandVO) {
    }
    public DemandVO getDemandById(String id){
        DemandEntity demandEntity=demandDomainService.selectById(id);
        return DemandAssembler.convertToDemandVO(demandEntity);
    }
}
