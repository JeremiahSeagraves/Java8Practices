package becomeateasewithjava8;

import becomeateasewithjava8.builders.EmployeeBuilder;
import becomeateasewithjava8.enums.Department;
import becomeateasewithjava8.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class EmployeeTest {

    @Test
    public void shouldReturnMaleEmployees() {
        List<Employee> employees = asList(
                EmployeeBuilder.builder()
                        .name("John")
                        .age(20)
                        .department(Department.DEVELOPMENT)
                        .salary(9999d)
                        .gender('M')
                        .build(),
                EmployeeBuilder.builder()
                        .name("Mary")
                        .age(22)
                        .department(Department.DEVELOPMENT)
                        .salary(9999d)
                        .gender('F')
                        .build(),
                EmployeeBuilder.builder()
                        .name("Laura")
                        .age(21)
                        .department(Department.DEVELOPMENT)
                        .salary(9999d)
                        .gender('F')
                        .build(),
                EmployeeBuilder.builder()
                        .name("Frank")
                        .age(20)
                        .department(Department.DEVELOPMENT)
                        .salary(9999d)
                        .gender('F')
                        .build()
        );

    }
}
