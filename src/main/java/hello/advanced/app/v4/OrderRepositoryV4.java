package hello.advanced.app.v4;


import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemdId) {
        AbstractTemplate template = new AbstractTemplate(trace) {
            @Override
            protected Void call() {
                if(itemdId.equals("ex")) {
                    throw new IllegalArgumentException();
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepositoryV4.save()");
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
