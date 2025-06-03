package behavioral.memento;

/**
 * 游戏角色状态的内部类或数据结构 (通常是发起人内部的私有类或数据结构)
 */
public record GameState(int health, int score, int level, String position) {
    @Override
    public String toString() {
        return "GameState{" +
                "health=" + health +
                ", score=" + score +
                ", level=" + level +
                ", position='" + position + '\'' +
                '}';
    }
}
