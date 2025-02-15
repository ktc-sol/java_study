package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    @Test
    void strategyV1() {
        Strategy strategy1 = new StrategyLogic1();
        Strategy strategy2 = new StrategyLogic2();

        ContextV1 context1 = new ContextV1(strategy1);
        ContextV1 context2 = new ContextV1(strategy2);

        context1.execute();
        context2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategy1 = new StrategyLogic1(){
            @Override
            public void call(){
                log.info("비즈니스 로직 1 실행");
            }
        };
        Strategy strategy2 = new StrategyLogic2(){
            @Override
            public void call(){
                log.info("비즈니스 로직 2 실행");
            }
        };

        ContextV1 context1 = new ContextV1(strategy1);
        ContextV1 context2 = new ContextV1(strategy2);

        context1.execute();
        context2.execute();
    }

    @Test
    void strategyV3() {

        ContextV1 context1 = new ContextV1(new StrategyLogic1(){
            @Override
            public void call(){
                log.info("비즈니스 로직 1 실행");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(new StrategyLogic2(){
            @Override
            public void call(){
                log.info("비즈니스 로직 2 실행");
            }
        });
        context2.execute();

        ContextV1 context3 = new ContextV1(() -> log.info("비즈니스 로직 3 실행"));
        context3.execute();

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
