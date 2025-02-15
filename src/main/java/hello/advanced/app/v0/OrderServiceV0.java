package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepository = new OrderRepositoryV0();

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    }
}
