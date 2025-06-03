package behavioral.state;

public class TVContext {
    private TVState currentState;

    public TVContext() {
        this.currentState = new TVOffState();
    }

    public void pressPowerButton() {
        this.currentState.pressPowerButton(this);
    }

    public void setState(TVState state) {
        this.currentState = state;
    }
}
