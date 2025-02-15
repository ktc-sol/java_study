package hello.advanced.trace.hellotrace;

import hello.advanced.trace.logtrace.FieldLogTrace;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public class HelloTraceV3Test {
    @Test
    void begin_end_level2(){
        FieldLogTrace trace = new FieldLogTrace();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exeption_level2(){
        FieldLogTrace trace = new FieldLogTrace();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());
    }

}
