package hello.proxy.trace.logtrace;


import hello.proxy.trace.TraceStatus;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
