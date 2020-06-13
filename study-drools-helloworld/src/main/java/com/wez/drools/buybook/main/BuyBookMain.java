package com.wez.drools.buybook.main;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.wez.drools.buybook.entity.Order;

public class BuyBookMain {

    @Test
    public void testBuyBook() {
        // 获取KieServices
        KieServices kieServices = KieServices.Factory.get();
        // 获取KieContainer
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        
        // 会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession("ksession-buybook");
        
        Order order = new Order();
        order.setOriginalPrice(210);
        
        // 将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(order);
        
        // 激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        
        // 关闭会话
        kieSession.dispose();
        
        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }
    
}
