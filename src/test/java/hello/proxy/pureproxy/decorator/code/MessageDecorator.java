package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private final Component target;

    public MessageDecorator(Component target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 호출");
        String result = target.operation();
        String decoResult = "++++++++" + result + "++++++++";
        log.info("MessageDecorator 적용 전={}, 후={}", result, decoResult);
        return decoResult;
    }
}
