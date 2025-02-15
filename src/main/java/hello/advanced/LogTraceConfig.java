package hello.advanced;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Configuration
public class LogTraceConfig {

//    @Bean
//    public LogTrace logTrace(){
//        return new FieldLogTrace();
//    }
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
