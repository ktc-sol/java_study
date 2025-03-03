package hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
@Aspect
public class AspectV6 {

    @Around("hello.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e){
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }

    @Before("hello.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    @AfterReturning("hello.aop.Pointcuts.orderAndService()")
    public void doReturn(JoinPoint joinPoint) {
        log.info("[return] {}", joinPoint.getSignature());
    }

    @AfterThrowing("hello.aop.Pointcuts.orderAndService()")
    public void doThrow(JoinPoint joinPoint) {
        log.info("[throw] {}", joinPoint.getSignature());
    }

    @After("hello.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }

}
