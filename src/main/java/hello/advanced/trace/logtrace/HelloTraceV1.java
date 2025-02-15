package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
@Component
public class HelloTraceV1 {
    private static final String START_PREIX = "-->";
    private static final String COMPLETE_PREIX = "<--";
    private static final String EX_PREFIX = "X-";

    public TraceStatus begin(String message){
        TraceId traceId = new TraceId();
        Long startTime = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId, message, addSpace(START_PREIX, traceId.getLevel()));
        return new TraceStatus(traceId, startTime, message);
    }

    public void end(TraceStatus Status){
        complete(Status, null);
    };

    public void exception(TraceStatus Status, Exception e){
        complete(Status, e);
    }

    public void complete(TraceStatus status, Exception exception){
        Long endTimeMs = System.currentTimeMillis();
        long resultTimeMs = endTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if(exception == null){
            log.info("[{}] {}{} time={}ms", traceId, addSpace(COMPLETE_PREIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId, addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, exception);
        }

    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level; i++) {
            sb.append(( i == level -1) ? "|" + prefix : "|  " );
        }
        return sb.toString();
    }


}
