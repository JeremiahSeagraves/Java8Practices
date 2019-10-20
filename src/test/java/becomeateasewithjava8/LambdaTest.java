package becomeateasewithjava8;

import becomeateasewithjava8.lambda.Lambda;
import becomeateasewithjava8.lambda.TransactionLambda;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class LambdaTest {

    @Test
    public void shouldRemoveStringsWithMoreThanThreeCharacters() {
        List<String> input = asList("car", "monkey", "apple", "computer", "Java", "8", "this has more than 3 letters");
        input = Lambda.filter(input, (s) -> s.length() < 4);
        assertThat(input).containsExactlyInAnyOrder("car", "8");
    }

    @Test
    public void shouldBeExecutedWitingATransaction() {
        TransactionLambda lambda = new TransactionLambda();
        Lambda.processWithinTransaction(lambda);
        assertTrue(lambda.isConsumed());
    }

    @Test
    public void shouldCreateAString() {
        String bigString = Lambda.create((() -> "String created"));
        assertTrue(bigString.length() > 0);
    }

    @Test
    public void extractStringSize() {
        String myString = "This is great";
        int length = Lambda.getStringLength(myString, String::length);
        assertTrue(length == 13);
    }

    @Test
    public void multiply() {
        int a = 5;
        int b = 6;
        int result = Lambda.multiply(a, b, (c, d) -> c * d);
        assertTrue(result == 30);
    }

    @Test
    public void shouldSortStrings() throws Exception {
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        //Any of the following would work
        //List<String> result = Lambda.sortStrings(input, (o1, o2) -> o1.compareTo(o2));
        //List<String> result = Lambda.sortStrings(input, String::compareTo);
        //List<String> result = Lambda.sortStrings(input, Comparator.naturalOrder());
        //List<String> result = Lambda.sortStrings(input, Comparator.comparing(s -> s));
        List<String> result = Lambda.sortStrings(input, Comparator.comparing(Function.identity()));
        /**
         * Sort through compareTo
         * List<String> sortedList = new ArrayList<>(input);
         * sortedList.sort(String::compareTo);
         * System.out.println(sortedList);
         */
        List<String> sortedList = Arrays.asList("A", "B", "C", "D", "E", "F");
        assertThat(result).isEqualTo(sortedList);
    }

    @Test
    public void shouldReverseSortStrings() throws Exception {
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        //The compiler is not able to infer the generic type parameters to comparing() when you add the .reversed()
        // chain call, so you have to explicitly give them. (String s) -> s
        //List<String> result = Lambda.sortStrings(input, Comparator.comparing((String s) -> s).reversed());
        //List<String> result = Lambda.sortStrings(input, (o1, o2) -> o1.compareTo(o2)*-1);
        List<String> result = Lambda.sortStrings(input, Comparator.reverseOrder());

        /**
         * List<String> reversedList = new ArrayList<>(input);
         * reversedList.sort((o1, o2) -> o1.compareTo(o2) * -1);
         * System.out.println(reversedList);
         */
        List<String> reversedList = Arrays.asList("F", "E", "D", "C", "B", "A");
        assertThat(result).isEqualTo(reversedList);
    }

}
