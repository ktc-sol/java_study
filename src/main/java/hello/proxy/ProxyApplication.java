package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.ConcreteProxyConfig;
import hello.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
//@Import({ConcreteProxyConfig.class, LogTraceConfig.class})
//@Import({DynamicProxyBasicConfig.class, LogTraceConfig.class})
//@Import({ProxyFactoryConfigV1.class, LogTraceConfig.class})
//@Import({DynamicProxyFilterConfig.class, LogTraceConfig.class})
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
