package com.yonyou.train.core.demand.repository;

import com.yonyou.train.core.demand.domain.entity.DemandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemandRepository {
    DemandEntity selectById(String id);
}
