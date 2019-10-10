package becomeateasewithjava8.predicates;

import becomeateasewithjava8.model.Employee;

import java.util.function.Predicate;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class EmployeePredicates {

    public static Predicate<Employee> isUderage() {
        return employee -> employee.getAge() < 18;
    }

    public static Predicate<Employee> isMale() {
        return employee -> employee.getGender().orElse('-') == 'M' || employee.getGender().orElse('-') == 'm';
    }

    public static Predicate<Employee> isFemale() {
        return employee -> employee.getGender().orElse('-') == 'F' || employee.getGender().orElse('-') == 'f';
    }

    public static Predicate<Employee> isAdultMale() {
        return employee -> isUderage().negate().test(employee) && isMale().test(employee);
    }

    public static Predicate<Employee> isAdultFemale() {
        return employee -> isUderage().negate().test(employee) && isFemale().test(employee);
    }

    public static Predicate<Employee> earnsMoreThan10k() {
        return employee -> employee.getSalary() > 10000d;
    }

    public static Predicate<Employee> isAdultMaleAndEarnsMoreThan10k() {
        return employee -> isUderage().negate().test(employee) && isMale().test(employee) && earnsMoreThan10k().test(employee);
    }
}
