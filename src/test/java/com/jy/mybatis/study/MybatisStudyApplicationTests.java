package com.jy.mybatis.study;

import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisStudyApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MybatisStudyApplicationTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void queryUserByIdTest() {
        logger.info("================================>>> user: {}", userService.queryUserById(1));
    }

    @Test
    public void queryUserByParamTest() {
        UserParam userParam = new UserParam();
        logger.info("================================>>> user: {}", userService.queryUserByParam(userParam));
    }

    @Test
    public void stringLengthTest() {
        String src = "\\\\\n";
        System.out.println(src.length());
    }

}
