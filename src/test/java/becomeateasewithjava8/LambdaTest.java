package becomeateasewithjava8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Jeremiah Seagraves on oct, 10, 2019
 */
public class LambdaTest {

    @Test
    public void shouldRemoveStringsWithMoreThanThreeCharacters() {
        List<String> input = asList("car", "monkey", "apple", "computer", "Java", "8", "this has more than 3 letters");
        input = Lambda.filter(input, (s) -> s.length() < 4);
    }
}
