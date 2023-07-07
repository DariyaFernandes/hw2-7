package entity;

import java.util.Objects;

public class Employee {

    public final String firstName;
    public final String lastName;

    private final Integer departmentId;
    private final double salary;

    public Employee(String firstName, String lastName, Integer departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = 0;
        this.salary = 0;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    }