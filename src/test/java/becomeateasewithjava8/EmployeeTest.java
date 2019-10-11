package becomeateasewithjava8;

import becomeateasewithjava8.builders.EmployeeBuilder;
import becomeateasewithjava8.enums.Department;
import becomeateasewithjava8.model.Employee;
import becomeateasewithjava8.predicates.EmployeePredicates;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class EmployeeTest {

    @Test
    public void shouldReturnMaleEmployees() {
        List<Employee> employees = asList(
                EmployeeBuilder.builder().name("John").age(20).department(Department.DEVELOPMENT).salary(9999d).gender('M').build(),
                new Employee("Mary", 22, Department.DEVELOPMENT, 9999d, 'F'),
                new Employee("Laura", 21, Department.DEVELOPMENT, 9999d, 'F'),
                new Employee("Frank", 20, Department.DEVELOPMENT, 9999d, 'M'),
                new Employee("Peter", 24, Department.DESIGN, 3000d, 'M')
        );
        employees = employees.stream().filter(EmployeePredicates.isMale()).collect(Collectors.toList());

        assertThat(employees)
                .extracting(Employee::getName, Employee::getGender)
                .containsExactlyInAnyOrder(
                        tuple("John", Optional.of('M')),
                        tuple("Frank", Optional.of('M')),
                        tuple("Peter", Optional.of('M'))
                );
    }
}
