package hello.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    @Test
    void templateMethodV1(){
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2(){
        AbstractTemplate template1 = new SubClassLogic2(){
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        };
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2(){
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        };
        template2.execute();

    }

    private void logic1(){
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultime = endTime - startTime;
        log.info("resultTime = {}", resultime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        log.info("비즈니스 로직 2 실행");
        // 비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultime = endTime - startTime;
        log.info("resultTime = {}", resultime);
    }
}
