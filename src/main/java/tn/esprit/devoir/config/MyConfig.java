package tn.esprit.devoir.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyConfig {
    // @Around("execution(* tn.esprit.devoir.service.*.*(..)")
    // public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    //     log.info("Before method:" + joinPoint.getSignature());
    //     joinPoint.proceed();
    //     log.info("After method:" + joinPoint.getSignature());
    // }
    @After("execution(* tn.esprit.devoir.service.*.*(..)) && args(String)")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method : " + name);
    }
}
