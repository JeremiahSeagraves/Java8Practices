package becomeateasewithjava8;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    @Disabled
    public void shouldBeExecutedWitingATransaction() {
        TransactionLambda lambda = new TransactionLambda();
        //Lambda.processWithinTransaction(lambda);
        assertTrue(lambda.isConsumed());
    }

    @Test
    @Disabled
    public void shouldCreateAString() {
        String bigString = Lambda.create();
        assertTrue(bigString.length() > 0);
    }

    @Test
    @Disabled
    public void extractStringSize() {
        String myString = "This is great";
        int length = Lambda.getStringLength(myString/* get string length*/);
        assertTrue(length == 13);
    }

    @Test
    @Disabled
    public void multiply() {
        int a = 5;
        int b = 6;
        int result = Lambda.multiply(a, b);
        assertTrue(result == 30);
    }

    @Test
    @Disabled
    public void shouldSortStrings() throws Exception {
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        List<String> result = Lambda.sortStrings(input);
        assertThat(result).isEqualTo(Arrays.asList("A", "B", "C", "D", "E", "F"));
    }

}
