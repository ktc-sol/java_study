package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId){
        log.info("[OrderService] 실행");
        orderRepository.save(itemId);
    }
}
