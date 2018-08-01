package com.jy.mybatis.study.listener;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationEventListener implements ApplicationListener<SpringApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SpringApplicationEventListener.class);

    private ApplicationContext applicationContext;
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void onApplicationEvent(SpringApplicationEvent springApplicationEvent) {
        if(springApplicationEvent instanceof ApplicationStartedEvent) {
            logger.info("======> spring context has benn initialized");
        }
    }

    public SpringApplicationEventListener(ApplicationContext applicationContext, SqlSessionFactory sqlSessionFactory) {
        this.applicationContext = applicationContext;
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
