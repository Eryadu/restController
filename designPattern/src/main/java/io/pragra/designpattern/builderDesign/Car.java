package io.pragra.designpattern.builderDesign;

public class Car {
    private String model;
    private String engine;
    private String gear;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.engine = builder.engine;
        this.gear = builder.gear;
    }

    public static class CarBuilder {
        public String model;
        public String engine;
        public String gear;

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }
        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }
        public CarBuilder setGear(String gear) {
            this.gear = gear;
            return this;
        }
        public Car build() {
            return new Car(this);
        }


    }
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", gear='" + gear + '\'' +
                '}';
    }
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setGear("4")
                .setEngine("Toyota")
                .build();
        System.out.println(car);
    }
}
