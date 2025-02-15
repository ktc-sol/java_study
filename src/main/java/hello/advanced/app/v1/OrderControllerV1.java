package hello.advanced.app.v1;

import hello.advanced.trace.logtrace.HelloTraceV1;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    public final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV1.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "OK";
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
