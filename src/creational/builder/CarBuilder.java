package creational.builder;

public interface CarBuilder {
    void buildEngine();

    void buildWheels();

    void buildColor();

    void buildSeats();

    Car getCar();
}
