package hello.advanced.trace.callback;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
public interface TraceCallback<T> {
    T call();
}
