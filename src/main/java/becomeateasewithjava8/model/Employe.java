package becomeateasewithjava8.model;

import becomeateasewithjava8.enums.Department;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class Employe {
    private int age;
    private String name;
    private Department department;
    private double salary;

    public Employe(int age, String name, Department department, double salary) {
        this.age = age;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
