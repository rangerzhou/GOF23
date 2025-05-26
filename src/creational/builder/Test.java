package creational.builder;

public class Test {
    public static void main(String[] args) {
        CarBuilder sportsCarBuilder = new SportsCarBuilder();
        CarBuilder suvCarBuilder = new SuvCarBuilder();

        Director director = new Director();

        Car sportsCar = director.build(sportsCarBuilder);
        Car suvCar = director.build(suvCarBuilder);

        System.out.println("Sports Car: " + sportsCar.toString());
        System.out.println("Suv Car: " + suvCar.toString());

    }
}
