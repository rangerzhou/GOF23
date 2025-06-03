package behavioral.strategy;

public class TVContext {
    private TVState currentState;

    public void pressPowerButton() {
        this.currentState.pressPowerButton(this);
    }

    public void setState(TVState state) {
        this.currentState = state;
    }
}
