package hello.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
public class Pointcuts {

    // hello.aop.order를 포함한 하위 패키지(..)를 지정하는 AspectJ 포인트컷 표현식
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder(){}

    // 클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
