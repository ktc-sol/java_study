package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Slf4j
public class FieldLogTrace implements LogTrace {
    private static final String START_PREIX = "-->";
    private static final String COMPLETE_PREIX = "<--";
    private static final String EX_PREFIX = "X-";

    private TraceId traceIdHolder;

    public TraceStatus begin(String message){
        syncTraceId();
        TraceId traceId = traceIdHolder;
        Long startTime = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTime, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception exception){
        Long endTimeMs = System.currentTimeMillis();
        long resultTimeMs = endTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if(exception == null){
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, exception);
        }
        releaseTraceId();
    }

    private void syncTraceId(){
        if (traceIdHolder == null){
            traceIdHolder = new TraceId();
        } else {
            traceIdHolder = traceIdHolder.createNextId();
        }
    }

    private void releaseTraceId(){
        if (traceIdHolder.isFirstLevel()){
            traceIdHolder = null;
        } else {
            traceIdHolder = traceIdHolder.createPreviousId();
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
