package com.jy.mybatis.study;

import com.jy.mybatis.study.dao.param.UserParam;
import com.jy.mybatis.study.entity.User;
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
        logger.info("================================>>> queryUserById: {}", userService.queryUserById(1));
    }

    @Test
    public void selectByIdTest() {
        logger.info("================================>>> selectById: {}", userService.selectById(1));
    }

    @Test
    public void queryUserByParamTest() {
        UserParam userParam = new UserParam();
        logger.info("================================>>> queryUserByParam: {}", userService.queryUserByParam(userParam));
    }

    @Test
    public void updateUserTest() {
        long id = 1;
        User user = userService.selectById(id);
        logger.info("================================>>> old version user: {}", user);
        User newUser = new User();
        newUser.setUsername("750661390");
        newUser.setAge(8);
        newUser.setPassword("new_password");
        newUser.setSex(0);
        newUser.setId(user.getId());
        userService.update(newUser);
        logger.info("================================>>> new version user: {}", userService.selectById(id));
    }

    @Test
    public void stringLengthTest() {
        String src = "\\\\\n";
        System.out.println(src.length());
    }

}
