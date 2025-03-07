package hello.aop.trace;

import lombok.Getter;

import java.util.UUID;

/**
 * (설명)
 * Created by xxx@kt.com
 * Date : 2025-02-15
 */
@Getter
public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    public Boolean isFirstLevel() {
        return level == 0;
    }
}
