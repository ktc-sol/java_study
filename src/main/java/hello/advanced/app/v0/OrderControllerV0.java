package hello.advanced.app.v0;

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
public class OrderControllerV0 {

    public final OrderServiceV0 orderService;

    @GetMapping("/v0/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "OK";
    }

}
