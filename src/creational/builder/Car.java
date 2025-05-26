package creational.builder;

public class Car {
    private String engine;
    private String wheels;
    private String color;
    private int seats;


    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels='" + wheels + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                '}';
    }
}
