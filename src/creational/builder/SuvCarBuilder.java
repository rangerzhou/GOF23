package creational.builder;

public class SuvCarBuilder implements CarBuilder {
    private Car car;
    public SuvCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("四缸发动机");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Suv Wheels");
    }

    @Override
    public void buildColor() {
        car.setColor("灰色");
    }

    @Override
    public void buildSeats() {
        car.setSeats(4);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
