package hello.proxy.config.v4_postprocessor;

import hello.proxy.LogTraceConfig;
import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.proxy.config.v4_postprocessor.postprocessor.PackageLogTraceProxyPostProcessor;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Configuration
@Slf4j
@Import({AppV1Config.class, AppV2Config.class, LogTraceConfig.class})
public class BeanPostProcessorConfig {

    @Bean
    public static PackageLogTraceProxyPostProcessor logTraceProxyPostProcessor(LogTrace logTrace) {
        return new PackageLogTraceProxyPostProcessor("hello.proxy.app", getAdvisor(logTrace));
    }

    private static Advisor getAdvisor(LogTrace logTrace) {
        // PointCut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        // Advice
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        // Advisor
        return new DefaultPointcutAdvisor(Pointcut.TRUE, advice);
    }
}
