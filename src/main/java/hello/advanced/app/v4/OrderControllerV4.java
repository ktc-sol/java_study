package hello.advanced.app.v4;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
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
public class OrderControllerV4 {

    public final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId){

        AbstractTemplate template = new AbstractTemplate(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "OK";
            }
        };
        return template.execute("OrderControllerV4.request()");
    }
}
