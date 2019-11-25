package net.karatas.altay.tracknumerator.core.aspect;


import java.util.concurrent.TimeUnit;
import lombok.extern.log4j.Log4j2;
import net.karatas.altay.tracknumerator.core.context.Context;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Log4j2
public class AppLogger {

  @Around("execution(public * net.karatas.altay.tracknumerator.controller.*.*(..))")
  public Object logMethods(ProceedingJoinPoint pjp) throws Throwable {
    long start = System.currentTimeMillis();
    MethodSignature signature = (MethodSignature) pjp.getSignature();
    log.info("{}.{} -> txt: {}",
        signature.getDeclaringType()::getSimpleName,
        signature.getMethod()::getName,
        Context::getTx);
    Object returnValue = pjp.proceed();
    long totalCost = TimeUnit.SECONDS.convert(
        System.currentTimeMillis() - start, TimeUnit.MILLISECONDS);
    log.info("{}.{} > txt: {} // total: {}",
        signature.getDeclaringType()::getSimpleName,
        signature.getMethod()::getName,
        Context::getTx,
        () -> totalCost);
    return returnValue;
  }

}
