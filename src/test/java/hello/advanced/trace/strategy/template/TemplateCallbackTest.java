package hello.advanced.trace.strategy.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class TemplateCallbackTest {
    @Test
    void callbackV1(){
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new Callback() {
            @Override
            public void callback() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        template.execute(() -> log.info("비즈니스 로직 실행 2"));
    }
}
