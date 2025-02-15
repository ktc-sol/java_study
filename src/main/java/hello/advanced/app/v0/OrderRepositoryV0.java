package hello.advanced.app.v0;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV0 {

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
