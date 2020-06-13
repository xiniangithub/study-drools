# Drools

## Drools maven
```xml
<dependency>
    <groupId>org.drools</groupId>
    <artifactId>drools-compiler</artifactId>
    <version>7.6.0.Final</version>
</dependency>
```

## Drools API

1. 获取KieServices
2. 获取KieContainer
3. KieSession
4. Insert fact
5. 出发规则
6. 关闭KieSession

## KieSession

- KieSession: 有状态的
  
  KieSession会在多次与规则引擎进行交互中，维护会话状态
  
- StatelessKieSession: 无状态的


