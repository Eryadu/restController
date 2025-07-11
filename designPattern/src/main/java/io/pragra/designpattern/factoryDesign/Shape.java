package io.pragra.designpattern.factoryDesign;

// With Abstract Class and Abstract method
public abstract class Shape {
    abstract void draw();
    public static class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Circle");
        }
    }
    public static class Square extends Shape {
        @Override
        void draw() {
            System.out.println("Square");
        }
    }

    public static class ShapeFactory {
        public static Shape getShape(String shapeType) {
            if (shapeType.equalsIgnoreCase("Circle")) {
                return new Circle();
            }
            else if (shapeType.equalsIgnoreCase("Square")) {
                return new Square();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("Circle");
        shape1.draw();
        Shape shape2 = factory.getShape("Square");
        shape2.draw();

    }
}
