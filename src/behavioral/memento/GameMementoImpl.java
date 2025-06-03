package behavioral.memento;

import java.sql.Timestamp;

/**
 * 2. 具体备忘录 (Concrete Memento)
 * 存储发起人的具体状态，只供发起人内部访问
 */
public class GameMementoImpl implements GameMemento {
    private final GameState savedState; // 实际存储的游戏状态
    private final Timestamp timestamp; // 备忘录的创建时间

    public GameMementoImpl(GameState savedState, Timestamp timestamp) {
        this.savedState = savedState;
        this.timestamp = timestamp;
    }

    // 这些 getter 方法通常只应被发起人（Originator）访问
    // 在实际复杂系统中，可以通过内部类或更严格的访问控制来实现
    public GameState getSavedState() {
        return savedState;
    }

    @Override
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "GameMementoImpl{" +
                "savedState=" + savedState +
                ", timestamp=" + timestamp +
                '}';
    }
}
