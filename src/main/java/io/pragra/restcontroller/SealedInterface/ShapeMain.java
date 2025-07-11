package io.pragra.restcontroller.SealedInterface;

public class ShapeMain {
    public static void main(String[] args) {
        Shape s = new Circle(5);


        // Pattern Matching -> it not support in jDK 17, supported in jDK 21+
        //double area = switch (s){
           /* case Circle c -> Math.PI* c.radius()* c.radius();
            case Rectangle r -> r.height()*r.width();
            case Triangle t -> 0.5* t.height()*t.base();*/
        /*};
        System.out.println(area);
   */
    }
}
