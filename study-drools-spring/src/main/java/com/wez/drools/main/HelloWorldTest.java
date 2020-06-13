package com.wez.drools.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-rules.xml"})
public class HelloWorldTest {
    
    @KBase(value="kbase")
    private KieBase  kieBase;
    
    @Test
    public void test() {
        try {
            KieSession kieSession = kieBase.newKieSession();
            
            int ruleSize = kieSession.fireAllRules();
            System.out.println("命中" + ruleSize + "规则");
            
            kieSession.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
