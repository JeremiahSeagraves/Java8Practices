package becomeateasewithjava8.builders;

import becomeateasewithjava8.enums.Department;
import becomeateasewithjava8.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class EmployeeBuilder {
    private final static Logger log = LoggerFactory.getLogger(EmployeeBuilder.class);

    private final String name;
    private final int age;
    private final Department department;
    private final double salary;

    private Character gender;

    private EmployeeBuilder(String name, int age, Department department, double salary, Character gender) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
    }

    public Employee build() {
        log.info("Building new Employee");
        return new Employee(name, age, department, salary, gender);
    }


    @FunctionalInterface
    public interface NameBuilder {
        AgeBuilder name(String name);
    }

    @FunctionalInterface
    public interface AgeBuilder {
        DepartmentBuilder age(Integer age);
    }

    @FunctionalInterface
    public interface DepartmentBuilder {
        SalaryBuilder department(Department department);
    }

    @FunctionalInterface
    public interface SalaryBuilder {
        GenderBuilder salary(Double salary);
    }

    @FunctionalInterface
    public interface GenderBuilder {
        EmployeeBuilder gender(Character gender);
    }

    public static NameBuilder builder() {
        return name -> age -> department -> salary -> gender -> new EmployeeBuilder(name, age, department, salary, gender);
    }

}
