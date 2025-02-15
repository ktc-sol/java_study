package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public abstract class AbstractTemplate {
    private final LogTrace trace;


    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 비즈니스 로직 호출
            T result = call();
            // 비즈니스 로직 종료

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract <T> T call();
}
