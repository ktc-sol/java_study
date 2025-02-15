package hello.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Getter
@AllArgsConstructor
public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;
}
