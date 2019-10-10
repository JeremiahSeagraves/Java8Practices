package becomeateasewithjava8.model;

import becomeateasewithjava8.enums.Department;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public final class Employee {

    private final String name;
    private final int age;
    private final Department department;
    private final double salary;
    private final Character gender;

    public Employee(String name, Integer age, Department department, Double salary, char gender) {
        this.name = requireNonNull(name, "name cannot be null");
        this.department = requireNonNull(department, "department cannot be null");
        this.age = requireNonNull(age, "age cannot be null");
        this.salary = requireNonNull(salary, "salary cannot be null");
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Optional<Character> getGender() {
        return Optional.ofNullable(gender);
    }

}
