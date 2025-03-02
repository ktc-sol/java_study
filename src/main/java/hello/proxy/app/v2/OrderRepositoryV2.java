package hello.proxy.app.v2;

import hello.proxy.app.v1.OrderRepositoryV1;
import org.springframework.stereotype.Repository;

public class OrderRepositoryV2 {

    public void save(String itemdId) {
        // 저장 로직
        if(itemdId.equals("ex")) {
            throw new IllegalArgumentException();
        }
        sleep(1000);
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
