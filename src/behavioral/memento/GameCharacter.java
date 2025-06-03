package behavioral.memento;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 3. 发起人 (Originator) - 游戏角色
 */
public class GameCharacter {
    private GameState currentState;

    public GameCharacter(int health, int score, int level, String position) {
        currentState = new GameState(health, score, level, position);
    }

    public void playGame(String actions) {
        switch (actions) {
            case "run":
                System.out.println("开始跑步");
                currentState = new GameState(currentState.health() - 10, currentState.score(), currentState.level(),
                        "run 区域");
                break;
            case "jump":
                System.out.println("开始跳高");
                currentState = new GameState(currentState.health(), currentState.score() + 10, currentState.level(),
                        "jump 区域");
                break;
            case "levelUp":
                System.out.println("升级啦");
                currentState = new GameState(currentState.health(), currentState.score(), currentState.level() + 1,
                        "升级区域");
                break;
            default:
                System.out.println("无效动作");
        }
    }

    // 创建备忘录，保存当前状态
    public GameMemento createMemento() {
        return new GameMementoImpl(new GameState(currentState.health(), currentState.score(), currentState.level(),
                currentState.position()), new Timestamp(new Date().getTime()));
    }

    // 从备忘录中恢复状态
    public void restoreMemento(GameMemento memento) {
        if (memento instanceof GameMementoImpl gameMemento) {
            currentState = gameMemento.getSavedState();
        } else {
            System.out.println("无效存档，无法恢复状态");
        }
    }

    public void printCurrentState() {
        System.out.println("当前游戏状态: " + currentState);
    }
}
