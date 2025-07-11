package io.pragra.designpattern.singletonDesign;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Singleton implements Serializable {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Singleton is created");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
    // this method solve Serialization Violation
    private Object readResolve() {
        return instance;
    }

    static void useSingleton() {
        Singleton instance = Singleton.getInstance();
        System.out.println("HashCode of Singleton is: " + instance.hashCode());
    }
    public static void main(String[] args) throws Exception {
       /* Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance1 == instance2);*/

        // Multithread violate Singleton
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(Singleton::useSingleton);
        executorService.submit(Singleton::useSingleton);
        executorService.shutdown();

        // Serialization and Deserialization violate the Singleton pattern
        /*ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("./s2.ser"));
        oos.writeObject(instance1);
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream("./s2.ser"));
        Singleton instance3 = (Singleton) ios.readObject();
        System.out.println(instance3.hashCode());*/

    }
}
