package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic realLogic;

    public TimeProxy(ConcreteLogic realLogic) {
        this.realLogic = realLogic;
    }

    @Override
    public String operation() {
        log.info("타임 데코레이터 실행");
        Long startTime = System.currentTimeMillis();

        String result = realLogic.operation();

        Long endTime = System.currentTimeMillis();
        Long resultTime = endTime - startTime;
        log.info("타임 데코레이터 종료 result time = {}", resultTime);
        return result;
    }
}
