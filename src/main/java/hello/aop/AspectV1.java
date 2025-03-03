package hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
@Aspect
public class AspectV1 {

    // hello.aop.order를 포함한 하위 패키지(..)를 지정하는 AspectJ 포인트컷 표현식
    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
