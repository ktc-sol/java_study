package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV5(LogTrace trace) {
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void save(String itemdId) {
        traceTemplate.execute("OrderRepositoryV5.save()", ()-> {
            if(itemdId.equals("ex")) {
                throw new IllegalArgumentException();
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
