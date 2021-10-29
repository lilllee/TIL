package javaclass;

public class Car {

    private int carNumber;
    private String carName;

    public Car(){
        carNumber = 20;
        carName = "Test2";
    }

    public Car(int carNumber, String carName) {
        this.carName = carName;
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public static void main(String[] args) {
        Car car = new Car(10, "Test");
        Car car2 = new Car();
        System.out.println(car.getCarName() + car.getCarNumber());
        System.out.println(car2.carName+ car2.carNumber);
    }
}