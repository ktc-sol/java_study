package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 비즈니스 로직 호출
            T result = callback.call();
            // 비즈니스 로직 종료

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
