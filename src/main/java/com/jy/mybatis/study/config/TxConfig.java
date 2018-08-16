package com.jy.mybatis.study.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TxConfig {

    @Bean
    public TransactionInterceptor txAdvice(PlatformTransactionManager platformTransactionManager){
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        /*只读事务，不做更新操作*/
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED );
        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(5);
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("add*", requiredTx);
        txMap.put("save*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("delete*", requiredTx);
        txMap.put("get*", readOnlyTx);
        txMap.put("query*", readOnlyTx);
        txMap.put("select*", readOnlyTx);
        source.setNameMap( txMap );
        return new TransactionInterceptor(platformTransactionManager, source);
    }

    /*
    * TransactionInterceptor 组合 BeanNameAutoProxyCreator可快速实现声明式事务
    */
//    @Bean
//    public BeanNameAutoProxyCreator txProxy() {
//        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();
//        creator.setInterceptorNames("txAdvice");
//        creator.setBeanNames("*ServiceImpl");
//        creator.setProxyTargetClass(true);
//        return creator;
//    }


    public AspectJExpressionPointcut expressionPointcut(ApplicationContext applicationContext) {
        AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
        //表达式皆可写接口或实现类
        expressionPointcut.setExpression("execution(* com.jy.mybatis.study.service.BaseService.*(..))");
//        expressionPointcut.setExpression("execution(* com.jy.mybatis.study.service.impl.BaseServiceImpl.*(..))");
        expressionPointcut.setBeanFactory(applicationContext);
        return expressionPointcut;
    }

    @Bean
    public Advisor advisor(PlatformTransactionManager platformTransactionManager, ApplicationContext applicationContext) {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(expressionPointcut(applicationContext));
        advisor.setAdvice(txAdvice(platformTransactionManager));
        return advisor;
    }

}
