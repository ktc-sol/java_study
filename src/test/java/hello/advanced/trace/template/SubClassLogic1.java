package hello.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class SubClassLogic1 extends AbstractTemplate{

    @Override
    protected void call() {
        log.info("비즈니스 로직 1 실행");
    }
}
