package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace threadLocalLogTrace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus status1 = threadLocalLogTrace.begin("hello1");
        TraceStatus status2 = threadLocalLogTrace.begin("hello2");
        threadLocalLogTrace.end(status2);
        threadLocalLogTrace.end(status1);
    }

    @Test
    void begin_exeption_level2(){
        TraceStatus status1 = threadLocalLogTrace.begin("hello1");
        TraceStatus status2 = threadLocalLogTrace.begin("hello2");
        threadLocalLogTrace.exception(status2, new IllegalArgumentException());
        threadLocalLogTrace.exception(status1, new IllegalArgumentException());
    }
}
