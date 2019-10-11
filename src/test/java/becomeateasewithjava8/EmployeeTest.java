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
                EmployeeBuilder.builder().name("Mary").age(22).department(Department.DEVELOPMENT).salary(9999d).gender('F').build(),
                EmployeeBuilder.builder().name("Laura").age(21).department(Department.DEVELOPMENT).salary(9999d).gender('F').build(),
                EmployeeBuilder.builder().name("Frank").age(20).department(Department.DEVELOPMENT).salary(9999d).gender('M').build(),
                EmployeeBuilder.builder().name("Peter").age(24).department(Department.DESIGN).salary(3000d).gender('M').build()
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
