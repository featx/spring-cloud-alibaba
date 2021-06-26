package org.featx.templet.app;

//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
//import org.springframework.test.context.ContextConfiguration

import org.jeasy.random.EasyRandom;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

//@MybatisTest
//@ContextConfiguration(classes = DataConfiguration.class)
@SpringBootTest(classes = {DataConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class SpringDataTestSuit {
    protected final static int DEFAULT_AMOUNT_SCALE = 18;

    @Resource
    private EasyRandom beanGenerator;

    protected <T> T generate(Class<T> type) {
        return beanGenerator.nextObject(type);
    }

    protected LocalDateTime keepMillSecond(LocalDateTime localDateTime) {
        int nano = localDateTime.getNano();
        int nanoFront3 = nano / 1000000 * 1000000;
        return localDateTime.minusNanos(nano % nanoFront3);
    }
}