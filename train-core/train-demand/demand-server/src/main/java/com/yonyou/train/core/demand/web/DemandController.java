package com.yonyou.train.core.demand.web;

import com.yonyou.train.core.demand.api.DemandService;
import com.yonyou.train.core.demand.domain.vo.DemandVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demand")
public class DemandController {
    @Autowired
    DemandService demandService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/get/{id}")
    @ResponseBody
    public DemandVO getDemandById(@PathVariable String id){
        logger.debug(id);
        return demandService.getDemandById(id);
    }
}
