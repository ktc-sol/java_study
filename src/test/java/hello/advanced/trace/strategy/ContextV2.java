package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy){
        long startTimeMs = System.currentTimeMillis();
        // 비즈니스 로직 실행
        strategy.call();
        // 비즈니스 로직 종료
        long endTimeMs = System.currentTimeMillis();
        long resultMs = endTimeMs - startTimeMs;
        log.info(resultMs + "ms");
    }
}
