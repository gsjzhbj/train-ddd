package com.yonyou.train.core.demand;

import com.yonyou.train.core.demand.domain.entity.DemandEntity;
import com.yonyou.train.core.demand.repository.DemandRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private DemandRepository demandRepository;

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testQuery() throws Exception {
        DemandEntity demandEntity=demandRepository.selectById("1");
        System.out.println(demandEntity);
    }


    @Test
    public void testUpdate() throws Exception {
    }
}
