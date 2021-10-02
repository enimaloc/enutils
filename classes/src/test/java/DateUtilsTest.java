import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static fr.enimaloc.enutils.classes.DateUtils.*;

class DateUtilsTest {

    @Test
    void getWithValueBelowZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                                         () -> formatDateFromMillis(-1));
        assertEquals(exception.getMessage(), "Millisecond must be grater than or equals zero");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0;0 days, 00 hours, 00 minutes, 00 seconds, 000 milliseconds",
            "1;0 days, 00 hours, 00 minutes, 00 seconds, 001 milliseconds",
            "1000;0 days, 00 hours, 00 minutes, 01 seconds, 000 milliseconds",
            "100000;0 days, 00 hours, 01 minutes, 40 seconds, 000 milliseconds",
            "10000000;0 days, 02 hours, 46 minutes, 40 seconds, 000 milliseconds",
            "100000000;1 days, 03 hours, 46 minutes, 40 seconds, 000 milliseconds",
    }, delimiter = ';')
    void getWithDefaultFormat(long millis, String expected) {
        assertEquals(expected, formatDateFromMillis(millis));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0;0 days, 00:00:00:000",
            "1;0 days, 00:00:00:001",
            "1000;0 days, 00:00:01:000",
            "100000;0 days, 00:01:40:000",
            "10000000;0 days, 02:46:40:000",
            "100000000;1 days, 03:46:40:000",
    }, delimiter = ';')
    void getWithCustomFormat(long millis, String expected) {
        assertEquals(expected, formatDateFromMillis(millis, "%1$d days, %2$02d:%3$02d:%4$02d:%5$03d"));
    }
}