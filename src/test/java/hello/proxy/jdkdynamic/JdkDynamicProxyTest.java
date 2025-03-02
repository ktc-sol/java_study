package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicCallA(){
        AInterface target = new AImpl();
        TimeInvactionHandler handler = new TimeInvactionHandler(target);
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                new Class[]{AInterface.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicCallB(){
        BInterfacee target = new BImpl();
        TimeInvactionHandler handler = new TimeInvactionHandler(target);
        BInterfacee proxy = (BInterfacee) Proxy.newProxyInstance(BInterfacee.class.getClassLoader(),
                new Class[]{BInterfacee.class}, handler);
        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
