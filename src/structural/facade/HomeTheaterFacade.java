package structural.facade;

public class HomeTheaterFacade {
    private final Projector projector;
    private final SoundSystem soundSystem;
    private final Lights lights;
    private final Player player;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, Lights lights, Player player) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
        this.player = player;
    }

    public void watchMovie(String movieTitle) {
        projector.turnOn();
        projector.setInputSource("HDMI");
        soundSystem.turnOn();
        soundSystem.setVolume(40);
        soundSystem.setMode("电影模式");
        lights.setMode("观影模式");
        player.play(movieTitle);
    }

    public void endMovie() {
        player.stop();
        lights.setMode("睡觉模式");
        soundSystem.turnOff();
        projector.turnOff();
    }
}
