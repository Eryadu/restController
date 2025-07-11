package io.pragra.designpattern.factoryDesign;

//Implementation with simple interface
public class ShapeFactory {
    interface Shape {
        void draw();
    }
    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }
    public static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    public static class SFactory{
        public Shape getShape(String shapeName){
            if(shapeName.equalsIgnoreCase("Circle")){
                return new Circle();
            }
            else if(shapeName.equalsIgnoreCase("Rectangle")){
                return new Rectangle();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        SFactory sFactory = new SFactory();
        Shape shape = sFactory.getShape("rectangle");
        shape.draw();
    }
}
