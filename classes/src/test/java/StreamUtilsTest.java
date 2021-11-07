import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

import static fr.enimaloc.enutils.classes.StreamUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class StreamUtilsTest {

    @Test
    void ifTest() {
        assertArrayEquals(new Integer[]{0, 1, 0, 3, 0, 5, 0, 7, 0, 9},
                          Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                                .map(i -> if_(i, in -> in % 2 == 0, in -> 0))
                                .toArray(Integer[]::new));
    }

    @Test
    void elseTest() {
        assertArrayEquals(new Integer[]{0, 0, 2, 0, 4, 0, 6, 0, 8, 0},
                          Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                                .map(i -> else_(i, in -> in % 2 == 0, in -> 0))
                                .toArray(Integer[]::new));
    }

    @Test
    void elifTest() {
        assertArrayEquals(new Integer[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                          Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                                .map(i -> elif_(i, in -> in % 2 == 0, in -> 0, in -> 1))
                                .toArray(Integer[]::new));
    }
}