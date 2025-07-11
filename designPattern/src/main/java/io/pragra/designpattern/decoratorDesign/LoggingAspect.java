package io.pragra.designpattern.decoratorDesign;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution (* io.pragra.designpattern.decoratorDesign.NotificationService.send(..))")
    public void sendMethod() {}

    @Before("sendMethod()")
    public void logBefore() {
        System.out.println("Logs before method");
    }
    @After("sendMethod()")
    public void logAfter() {
        System.out.println("Logs after method");
    }
}
