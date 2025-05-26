package creational.builder;

public class SportsCarBuilder implements CarBuilder {
    private Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("八缸发动机");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Sports Wheels");
    }

    @Override
    public void buildColor() {
        car.setColor("红色");
    }

    @Override
    public void buildSeats() {
        car.setSeats(2);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
