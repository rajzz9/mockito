package com.hubberspot.designpattern.creational.singleton._static_block_initialization;

public class Employee {

    static {
        try {
            employee = new Employee();
        } catch(Exception e) {
            throw new RuntimeException("Exception occurred in creating " +
                    "Employee instance");
        }
    }

    private static Employee employee;

    private Employee() {
        // private constructor
    }

    public static Employee getEmployee() {
        return employee;
    }

    public void printEmployee() {
        System.out.println("Welcome to ABC Company !!! - " +
                this.getClass().getSimpleName() + " - " +
                this.hashCode());
    }
}
