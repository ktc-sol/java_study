package hello.advanced.app.v3;

import hello.advanced.trace.logtrace.LogTrace;
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
public class OrderControllerV3 {

    public final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderControllerV3.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "OK";
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
