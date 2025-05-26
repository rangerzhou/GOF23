package creational.builder;

public class Director {

    public Car build(CarBuilder carBuilder) {
        carBuilder.buildEngine();
        carBuilder.buildWheels();
        carBuilder.buildColor();
        carBuilder.buildSeats();
        return carBuilder.getCar();
    }
}
