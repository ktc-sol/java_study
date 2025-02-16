package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private final Component target;

    public TimeDecorator(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("타임 데코레이터 실행");
        Long startTime = System.currentTimeMillis();
        String result = target.operation();
        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("타임 데코레이터 종료 result time = {}", resultTime);
        return result;
    }
}
