package io.pragra.designpattern.compositeDesign;

import java.util.ArrayList;
import java.util.List;

public interface Employee {
    void showDetails();
}
class Developer implements Employee {
    private String name;
    private String role;
    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer name: " + name + "Role:" + role);
    }
}
class Manager implements Employee {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    public Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    @Override
    public void showDetails() {
        System.out.println("Manager name: " + name);
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }

    public static void main(String[] args) {
        Developer dev1 = new Developer("Alice" , "Java Developer");
        Developer dev2 = new Developer("Bob" , "Python Developer");

        Manager manager1 = new Manager("Smith");
        manager1.addEmployee(dev1);
        manager1.addEmployee(dev2);

        Manager ceo = new Manager("Joy");
        ceo.addEmployee(manager1);
        ceo.showDetails();
    }
}
