package hello.advanced.app.v3;


import hello.advanced.trace.logtrace.LogTrace;
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
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemdId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepositoryV3.save()");
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
