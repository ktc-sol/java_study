package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-03-03
 */
@Slf4j
@Repository
public class OrderRepository {

    public String save(String itemId){
        log.info("[OrderRepository] 실행");
        if(itemId.equals("ex")) {
            throw new IllegalArgumentException("예외 발생");
        }
//        sleep(1000);
        return "ok";
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
