package hello.advanced.app.v2;

import hello.advanced.trace.logtrace.HelloTraceV2;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(OrderControllerV2.class);
    public final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV2.request()");
            orderService.orderItem(itemId, status.getTraceId());
            trace.end(status);
            return "OK";
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
