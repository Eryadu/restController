package io.pragra.designpattern.prototypeDesign;

interface Prototype  {
    Prototype clone();

     class Car1 implements Prototype{
    private String brand;
    private String engine;

        public Car1(String brand, String engine) {
            this.brand = brand;
            this.engine = engine;
        }

        @Override
        public Car1 clone() {
            return new Car1(this.brand, this.engine);
        }

         @Override
         public String toString() {
             return "Car1{" +
                     "brand='" + brand + '\'' +
                     ", engine='" + engine + '\'' +
                     '}';
         }
     }

    static void main(String[] args) {
        Car1 car1 = new Car1("Volvo", "Gaint");
        Car1 car1Clone = car1.clone();
        System.out.println("Cloned Car is : " + car1Clone);

    }
}
