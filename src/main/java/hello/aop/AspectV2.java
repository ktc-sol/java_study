package hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
@Aspect
public class AspectV2 {

    // 포인트컷 표현식 분리
    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder(){}

    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
