package becomeateasewithjava8;

import becomeateasewithjava8.builders.EmployeeBuilder;
import becomeateasewithjava8.enums.Department;
import becomeateasewithjava8.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jeremiah Seagraves on oct, 11, 2019
 */
public class StreamTest {

    private static Employee getRandomEmployee() {
        Random random = new Random();
        List<String> names = asList("John", "Peter", "Louise", "Mary", "Luke", "Jerry", "Mark", "Cassandra", "Katty");
        return EmployeeBuilder
                .builder()
                .name(names.get(random.nextInt(names.size())))
                .age(random.nextInt(40))
                .department(Department.values()[random.nextInt(Department.values().length)])
                .salary(random.nextDouble())
                .gender(random.nextInt(10) % 2 == 0 ? 'M' : 'F')
                .build();
    }

    @Test
    public void parallelStreamShouldBeFasterThanSequential() {
        int amount = 10000000;//10 millones de registros
        List<Employee> values = new ArrayList<>(amount);
        while (amount-- > 0) {
            values.add(getRandomEmployee());
        }
        //Sequential
        long startSequential = System.nanoTime();
        long count = values.stream().sorted(Comparator.comparing(Employee::getName)).count();
        System.out.println(count);
        long endSequential = System.nanoTime();
        long sequentialTime = TimeUnit.NANOSECONDS.toMillis(endSequential - startSequential);
        System.out.println(String.format("sequential sort took: %d ms", sequentialTime));

        //Parallel
        long startParallel = System.nanoTime();
        long count2 = values.parallelStream().sorted(Comparator.comparing(Employee::getName)).count();
        System.out.println(count2);
        long endParallel = System.nanoTime();
        long parallelTime = TimeUnit.NANOSECONDS.toMillis(endParallel - startParallel);
        System.out.println(String.format("parallel sort took: %d ms", parallelTime));

        assertThat(sequentialTime).isGreaterThan(parallelTime);
    }
}
