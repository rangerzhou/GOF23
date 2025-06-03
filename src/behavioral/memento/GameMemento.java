package behavioral.memento;

import java.sql.Timestamp;

/**
 * 1. 备忘录 (Memento) 接口 - 窄接口
 * 对看管者来说，它只是一个标记，不暴露内部状态
 */
public interface GameMemento {
    // 这是一个标记接口，或者可以有更通用的方法，如 getTimestamp() 等
    Timestamp getTimestamp();
}
