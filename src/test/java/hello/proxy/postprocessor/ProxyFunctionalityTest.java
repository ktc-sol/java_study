package hello.proxy.postprocessor;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
public class ProxyFunctionalityTest {

    @Test
    public void testProxyFunctionality() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
        OrderControllerV2 orderControllerV2 = context.getBean(OrderControllerV2.class);
        OrderServiceV2 serviceV2 = context.getBean(OrderServiceV2.class);
        OrderRepositoryV2 repositoryV2 = context.getBean(OrderRepositoryV2.class);
        log.info("Actual Class of OrderControllerV2: {}", orderControllerV2.getClass().getName());
        log.info("Actual Class of OrderRepositoryV2: {}", serviceV2.getClass().getName());
        log.info("Actual Class of OrderServiceV2: {}", repositoryV2.getClass().getName());

        orderControllerV2.request("hello");
        serviceV2.orderItem("hello");
        repositoryV2.save("hello");
    }
}
