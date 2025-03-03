package hello.proxy.app.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV2 {

    public final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v2/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "OK";
    }
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "OK";
    }
}
