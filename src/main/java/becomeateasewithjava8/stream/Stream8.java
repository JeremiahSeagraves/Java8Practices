package becomeateasewithjava8.stream;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        //return numbers.stream().map(value -> (int) Math.sqrt(value)).collect(Collectors.toList());
        return numbers.stream().map(Math::sqrt).map(Double::intValue).collect(Collectors.toList());

    }

    public static List<Integer> getAgeFromUsers(List<User> users) {
        return users.stream().map(User::getAge).collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        return users.stream().map(User::getAge).distinct().collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users.stream().limit(limit).collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        return users.stream().filter(user -> user.getAge() > 25).mapToInt(value -> 1).sum();
    }

    public static List<String> mapToUpperCase(List<String> strings) {
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        return names.stream().map(s -> s.split(" ")).map(strings -> strings[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names) {
        //flatMap es necesario, porque split devuelve un arreglo de Strings, haciendo .flatMap
        //se obtiene un stream con las Strings del arreglo, si se hiciera un map a Stream, se obtendría
        //un stream de arreglo de strings
        //return names.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        return names.stream().map(s -> s.split("")).flatMap(Stream::of).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users) {
        throw new NotImplementedException();
    }

    public static double getAverageAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Integer getMaxAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Integer getMinAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        throw new NotImplementedException();
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Map<Boolean, Long> countGender(List<User> users) {
        throw new NotImplementedException();
    }

    public static boolean anyMatch(List<User> users, int age) {
        throw new NotImplementedException();
    }

    public static boolean noneMatch(List<User> users, int age) {
        throw new NotImplementedException();
    }

    public static Optional<User> findAny(List<User> users, String name) {
        throw new NotImplementedException();
    }

    public static List<User> sortByAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        throw new NotImplementedException();
    }

    public static List<Integer> generateFirst10PrimeNumbers() {
        throw new NotImplementedException();
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers() {
        throw new NotImplementedException();
    }

    public static User findOldest(List<User> users) {
        throw new NotImplementedException();
    }

    public static int sumAge(List<User> users) {
        throw new NotImplementedException();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        throw new NotImplementedException();
    }

}
