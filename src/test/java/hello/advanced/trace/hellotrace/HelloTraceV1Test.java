package hello.advanced.trace.hellotrace;

import hello.advanced.trace.logtrace.HelloTraceV1;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public class HelloTraceV1Test {

    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exeption(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException("oops"));
    }
}
