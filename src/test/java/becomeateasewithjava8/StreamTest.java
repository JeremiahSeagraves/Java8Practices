package becomeateasewithjava8;

import becomeateasewithjava8.builders.EmployeeBuilder;
import becomeateasewithjava8.enums.Department;
import becomeateasewithjava8.model.Employee;
import becomeateasewithjava8.stream.CharacterToStringCollector;
import becomeateasewithjava8.stream.Stream8;
import becomeateasewithjava8.stream.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jeremiah Seagraves on oct, 11, 2019
 */
public class StreamTest {

    private final static Logger logger = LoggerFactory.getLogger(StreamTest.class);

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
    @Disabled
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

    @Test
    public void shouldRemoveAllNotStartingWithLAndReturnItSortedInUpperCase() {
        List<String> list = asList("Monkey", "Java", "Lion", "Log", "Test", "NotL", "l", "Louise");
        list = list.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("L"))
                .sorted()
                .collect(Collectors.toList());
        logger.debug(list.toString());
        assertThat(list).containsExactly("L", "LION", "LOG", "LOUISE");
    }

    @Test
    public void shouldMapStringsToUpperCase() {
        List<String> input = asList("This", "is", "java", "8");
        List<String> result = Stream8.mapToUpperCase(input);
        logger.debug(result.toString());
        assertThat(result).contains("THIS", "IS", "JAVA", "8");
    }

    @Test
    public void shouldReturnSquareRoot() {
        List<Integer> numbers = Arrays.asList(1, 4, 16, 256);
        List<Integer> squares = Stream8.returnSquareRoot(numbers);
        logger.debug(squares.toString());
        assertThat(squares).isEqualTo(Arrays.asList(1, 2, 4, 16));
    }

    @Test
    public void shouldReturnAgeFromUser() {
        List<User> users = User.getUsersWithAge(18, 20);
        List<Integer> ageFromUsers = Stream8.getAgeFromUsers(users);
        logger.debug(ageFromUsers.toString());
        assertThat(ageFromUsers).isEqualTo(Arrays.asList(18, 20));
    }

    @Test
    public void shouldReturnFirstTwo() {
        List<User> users = User.getUsersWithAge(18, 20, 21, 22, 23);
        users = Stream8.getLimitedUserList(users, 2);
        logger.debug(users.toString());
        assertThat(users).isEqualTo(Arrays.asList(users.get(0), users.get(1)));
    }

    @Test
    public void shouldReturnNumberOfUsersOlderThen25() {
        List<User> users = User.getUsersWithAge(18, 20, 21, 22, 23, 24, 25, 26);
        Integer count = Stream8.countUsersOlderThen25(users);
        logger.debug(count.toString());
        assertThat(count == 1).isTrue();
    }

    @Test
    public void shouldReturnDistinctAges() {
        List<User> users = User.getUsersWithAge(18, 20, 20, 21, 22, 22, 23, 24, 25, 26);
        List<Integer> distinctAges = Stream8.getDistinctAges(users);
        logger.debug(distinctAges.toString());
        assertThat(distinctAges).isEqualTo(Arrays.asList(18, 20, 21, 22, 23, 24, 25, 26));
    }

    @Test
    public void shouldSumIntegersInCollection() {
        List<Integer> integers = asList(1, 2, 3, 4, 5);
        Integer result = Stream8.sum(integers);
        logger.debug(result.toString());
        assertThat(result).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    public void shouldSkipInCollection() {
        List<Integer> integers = asList(1, 2, 3, 4, 5);
        List<Integer> result = Stream8.skip(integers, 2);
        logger.debug(result.toString());
        assertThat(result).isEqualTo(Arrays.asList(3, 4, 5));
    }

    @Test
    public void shouldReturnFirstNames() {
        List<String> names = asList("Homer Simpson", "Marge Simpson", "Bart Simpson", "Kent Brockman");
        List<String> result = Stream8.getFirstNames(names);
        logger.debug(result.toString());
        assertThat(result).isEqualTo(Arrays.asList("Homer", "Marge", "Bart", "Kent"));
    }

    @Test
    public void shouldReturnDistinctLetters() {
        List<String> names = asList("Homer Simpson", "Marge Simpson", "Bart Simpson", "Kent Brockman");
        List<String> result = Stream8.getDistinctLetters(names);
        logger.debug(result.toString());
        assertThat(result).isEqualTo(Arrays.asList("H", "o", "m", "e", "r", " ", "S", "i", "p", "s", "n", "M", "a", "g", "B", "t", "K", "c", "k"));
    }

    @Test
    @Disabled
    public void shouldSeparateNamesByComma() {
        List<User> input = asList(
                new User("Homer"),
                new User("Maggie"),
                new User("Bart"));
        String result = Stream8.separateNamesByComma(input);
        logger.debug(result);
        assertThat(result).isEqualTo("Homer, Maggie, Bart");
    }

    @Test
    @Disabled
    public void shouldPerformCalculations() {
        List<User> users = User.getUsersWithAge(10, 20, 30);
        assertThat(Stream8.getMinAge(users)).isEqualTo(10);
        assertThat(Stream8.getMaxAge(users)).isEqualTo(30);
        assertThat(Stream8.getAverageAge(users)).isEqualTo((double) (10 + 20 + 30) / 3);
    }

    @Test
    @Disabled
    public void shouldPartitionByGender() {
        User homer = new User("Homer", true);
        User bart = new User("Bart", true);
        User maggie = new User("Maggie", false);
        User lisa = new User("Lisa", false);
        List<User> input = asList(homer, bart, maggie, lisa);
        Map<Boolean, List<User>> result = Stream8.partionUsersByGender(input);
        assertThat(result.get(true)).containsExactlyInAnyOrder(homer, bart);
        assertThat(result.get(false)).containsExactlyInAnyOrder(maggie, lisa);
    }

    @Test
    @Disabled
    public void shouldGroupByAge() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> input = asList(homer, bart, maggie, lisa);
        Map<Integer, List<User>> result = Stream8.groupByAge(input);
        assertThat(result.get(50)).containsExactlyInAnyOrder(homer);
        assertThat(result.get(12)).containsExactlyInAnyOrder(homer);
        assertThat(result.get(8)).containsExactlyInAnyOrder(homer);
        assertThat(result.get(2)).containsExactlyInAnyOrder(homer);
    }

    @Test
    @Disabled
    public void shouldGroupByGenderAndAge() {
        User homer = new User("Homer", 50, true);
        User bart = new User("Bart", 12, true);
        User maggie = new User("Maggie", 2, false);
        User lisa = new User("Lisa", 8, false);
        List<User> input = asList(homer, bart, maggie, lisa);
        Map<Boolean, Map<Integer, List<User>>> result = Stream8.groupByGenderAndAge(input);
        assertThat(result.get(true).get(50)).containsExactlyInAnyOrder(homer);
        assertThat(result.get(true).get(12)).containsExactlyInAnyOrder(bart);
        assertThat(result.get(true).get(8)).containsExactlyInAnyOrder(lisa);
        assertThat(result.get(true).get(2)).containsExactlyInAnyOrder(maggie);
    }

    @Test
    @Disabled
    public void shouldCountGender() {
        User homer = new User("Homer", 50, true);
        User bart = new User("Bart", 12, true);
        User maggie = new User("Maggie", 2, false);
        User lisa = new User("Lisa", 8, false);
        List<User> input = asList(homer, bart, maggie, lisa);
        Map<Boolean, Long> result = Stream8.countGender(input);
        assertThat(result.get(true)).isEqualTo(2L);
        assertThat(result.get(false)).isEqualTo(2L);
    }

    @Test
    @Disabled
    public void shouldMatchAge() {
        List<User> users = User.getUsersWithAge(10, 20, 30);
        assertThat(Stream8.anyMatch(users, 10)).isTrue();
    }

    @Test
    @Disabled
    public void shouldNoneMatchAge() {
        List<User> users = User.getUsersWithAge(10, 20, 30);
        assertThat(Stream8.noneMatch(users, 40)).isTrue();
    }

    @Test
    @Disabled
    public void shouldFindAnyUser() {
        User homer = new User("Homer", true);
        User bart = new User("Bart", true);
        User maggie = new User("Maggie", false);
        User lisa = new User("Lisa", true);
        List<User> users = asList(homer, bart, maggie, lisa);
        Optional<User> user = Stream8.findAny(users, "Homer");
        assertThat(user.isPresent()).isTrue();
    }

    @Test
    @Disabled
    public void shouldSortByAge() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);
        List<User> sorted = Stream8.sortByAge(users);
        assertThat(sorted).contains(maggie, lisa, bart, homer);
    }

    @Test
    @Disabled
    public void shouldFindOldest() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);
        User oldest = Stream8.findOldest(users);
        assertThat(oldest).isEqualTo(homer);
    }

    @Test
    @Disabled
    public void shouldSumAgeAsInt() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);
        int sumAge = Stream8.sumAge(users);
        assertThat(sumAge).isEqualTo(50 + 12 + 2 + 8);
    }

    @Test
    @Disabled
    public void shouldGenerateAgeSummaryStatistics() {
        User homer = new User("Homer", 50);
        User bart = new User("Bart", 12);
        User maggie = new User("Maggie", 2);
        User lisa = new User("Lisa", 8);
        List<User> users = asList(homer, bart, maggie, lisa);
        IntSummaryStatistics statistics = Stream8.ageSummaryStatistics(users);
        assertThat(statistics.getAverage()).isEqualTo((double) (50 + 12 + 2 + 8) / 4);
        assertThat(statistics.getCount()).isEqualTo(4L);
        assertThat(statistics.getMax()).isEqualTo(50);
        assertThat(statistics.getMin()).isEqualTo(2);
    }

    @Test
    @Disabled
    public void shouldConvertToBoxedStream() {
        List<Integer> numbers = asList(1, 2, 3);
        IntStream intStream = numbers.stream().mapToInt(value -> value);
        Stream<Integer> boxedStream = Stream8.getBoxedStream(intStream);
        assertThat(boxedStream.count() == 3).isTrue();
    }

    @Test
    @Disabled
    public void shouldBeEmptyStream() {
        Stream<Integer> numberStream = null; //create empty stream
        assertThat(numberStream).isNotNull();
    }

    @Test
    @Disabled
    public void shouldGenerateFirstPrimeNumbers() {
        List<Integer> primeNumbers = Stream8.generateFirst10PrimeNumbers();
        assertThat(primeNumbers).contains(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    }

    @Test
    @Disabled
    public void shouldGenerate10RandomNumbers() {
        List<Integer> randomNumbers = Stream8.generate10RandomNumbers();
        assertThat(randomNumbers.size() == 10).isTrue();
    }

    @Test
    @Disabled
    public void shouldCollectToString() {
        String sample = "Working with Java8 Streams";
        String result = sample.chars().mapToObj(a -> ((char) a)).collect(new CharacterToStringCollector());
        assertThat(sample).isEqualTo(result);
    }
}
