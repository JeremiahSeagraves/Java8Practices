package basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Jeremiah Seagraves on oct, 09, 2019
 */
public class BasicTest {

    BasicClass tester;

    @BeforeEach
    public void testSetup() {
        this.tester = new BasicClass();
    }

    @AfterEach
    public void testCleanup() {
        // Do your cleanup here like close URL connection , releasing resources etc
    }

    @Test
    public void shouldNotDivideByZero() {
        assertThrows(ArithmeticException.class, () -> this.tester.divide(1000, 0));
    }

    @Test
    public void shouldReturn50() {
        assertEquals(50, this.tester.multiply(10, 5), "Resultado");
    }
}
