package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class StrategyLogic2 implements Strategy {

    @Override
    public void call() {
        log.info("비즈니스 로직 2 실행");
    }
}
