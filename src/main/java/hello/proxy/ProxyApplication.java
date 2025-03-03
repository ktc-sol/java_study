package hello.proxy;

import hello.proxy.config.v6_aop.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import({ConcreteProxyConfig.class, LogTraceConfig.class})
//@Import({DynamicProxyBasicConfig.class, LogTraceConfig.class})
//@Import({ProxyFactoryConfigV2.class, LogTraceConfig.class})
//@Import({DynamicProxyFilterConfig.class, LogTraceConfig.class})
//@Import({BeanPostProcessorConfig.class, LogTraceConfig.class})
//@Import({AutoProxyConfig.class, LogTraceConfig.class})
@Import({AopConfig.class, LogTraceConfig.class})
@SpringBootApplication(scanBasePackages = "hello.proxy.app")
public class ProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

//    @Bean
//    public LogTrace logTrace(){
//        return new ThreadLocalLogTrace();
//    }
}
