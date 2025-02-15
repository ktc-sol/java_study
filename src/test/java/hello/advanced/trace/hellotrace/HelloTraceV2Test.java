package hello.advanced.trace.hellotrace;

import hello.advanced.trace.logtrace.HelloTraceV2;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public class HelloTraceV2Test {

    @Test
    void begin_end_level2(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exeption_level2(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalStateException());
    }
}
