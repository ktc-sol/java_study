package hello.advanced.app.v2;

import hello.advanced.trace.logtrace.HelloTraceV2;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId traceId){
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderServiceV2.orderItem()");
            orderRepository.save(itemId, status.getTraceId());
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}
