package basic;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jeremiah Seagraves on oct, 15, 2019
 */
public class ExtraTest {

    private static final Logger log = LoggerFactory.getLogger(ExtraTest.class);

    private static final int ALPHABET_QUANTITY = 26;

    private int getIntValue(String column) {
        final char[] charColumns = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        final String stringColumns = new String(charColumns);

        int stringLengthWithoutLastCharacter = column.length() - 1;
        int firstCharacterValue = stringColumns.indexOf(column.charAt(0)) + 1;
        int lastCharacterValue = stringColumns.indexOf(column.charAt(column.length() - 1)) + 1;

        return stringLengthWithoutLastCharacter >= 1 ?
                stringLengthWithoutLastCharacter * ALPHABET_QUANTITY + lastCharacterValue :
                firstCharacterValue;
    }

    @Test
    public void shouldReturnColumnIntValueGivenColumnStringValue() {
        final String d = "D";
        final int expectedValueD = 4;
        final int obtainedValueD = getIntValue(d);
        log.debug("D");
        log.debug("Expected: " + expectedValueD + " Obtained: " + obtainedValueD);
        assertThat(obtainedValueD).isEqualTo(expectedValueD);

        final String w = "W";
        final int expectedValueW = 23;
        final int obtainedValueW = getIntValue(w);
        log.debug("W");
        log.debug("Expected: " + expectedValueW + " Obtained: " + obtainedValueW);
        assertThat(obtainedValueW).isEqualTo(expectedValueW);

        final String aa = "AA";
        final int expectedValueAA = 27;
        final int obtainedValueAA = getIntValue(aa);
        log.debug("AA");
        log.debug("Expected: " + expectedValueAA + " Obtained: " + obtainedValueAA);
        assertThat(obtainedValueAA).isEqualTo(expectedValueAA);

        final String aax = "AAX";
        final int expectedValueAAX = 76;
        final int obtainedValueAAX = getIntValue(aax);
        log.debug("AAX");
        log.debug("Expected: " + expectedValueAAX + " Obtained: " + obtainedValueAAX);
        assertThat(obtainedValueAAX).isEqualTo(expectedValueAAX);

        final String aaaaaak = "AAAAAAK";
        final int expectedValueAAAAAAK = 167;
        final int obtainedValueAAAAAAK = getIntValue(aaaaaak);
        log.debug("AAAAAAK");
        log.debug("Expected: " + expectedValueAAAAAAK + " Obtained: " + obtainedValueAAAAAAK);
        assertThat(obtainedValueAAAAAAK).isEqualTo(expectedValueAAAAAAK);

    }
}
