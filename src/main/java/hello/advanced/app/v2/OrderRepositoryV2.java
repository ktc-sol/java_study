package hello.advanced.app.v2;


import hello.advanced.trace.logtrace.HelloTraceV2;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(String itemdId, TraceId traceId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepositoryV2.save()");
            if(itemdId.equals("ex")) {
                throw new IllegalArgumentException();
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
