package com.wez.drools.carboncopy.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.wez.drools.carboncopy.entity.CarbonCopyRole;

public class CarbonCopyTest {

    @Test
    public void testCarbonCopy() {
        
        // 读取配置文件
        // 项目名称（模拟从配置文件读取项目名称）
        String projectName = "山西";
        // 读取抄送角色名称（模拟从配置文件读取抄送角色名称）
        String carbonCopyRoleName = "DWZHS";
        
        // 封装抄送角色对象
        CarbonCopyRole role = new CarbonCopyRole();
        role.setProjectName(projectName);
        
        List<String> roleNames = new ArrayList<String>();
        roleNames.add(carbonCopyRoleName);
        role.setRoleNames(roleNames);
        
        this.executeRuleEnginee("ksession-carbon-copy-role", role);
    }
    
    public void executeRuleEnginee(String kieSessionName, Object obj) {
        // 获取KieServices
        KieServices kieServices = KieServices.Factory.get();
        // 获取KieContainer
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        
        // 会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession("ksession-carbon-copy-role");
        
        // 将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(obj);
        
        // 激活规则引擎，如果规则匹配成功则执行规则
        int ruleSize = kieSession.fireAllRules();
        System.out.println("命中" + ruleSize + "规则");
        
        // 关闭会话
        kieSession.dispose();
    }
    
}
