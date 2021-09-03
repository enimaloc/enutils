import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static fr.enimaloc.enutils.classes.NumberUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @Nested
    class SafeMethod {
        @ParameterizedTest
        @ValueSource(bytes = {
                Byte.MIN_VALUE, -100, -50, 0, 50, 100, Byte.MAX_VALUE
        })
        void getByte(byte b) {
            Optional<Byte> opt = getSafe(b + "", Byte.class);
            assertTrue(opt.isPresent());
            assertEquals(b, opt.get());
        }

        @Test
        void invalidByte() {
            Optional<Byte> opt = getSafe("byte", Byte.class);
            assertTrue(opt.isEmpty());
        }

        @ParameterizedTest
        @ValueSource(doubles = {
                Double.MIN_VALUE, -100.5, -50.5, -0.5, 0, 0.5, 50.5, 100.5, Double.MAX_VALUE
        })
        void getDouble(double d) {
            Optional<Double> opt = getSafe(d + "", Double.class);
            assertTrue(opt.isPresent());
            assertEquals(d, opt.get());
        }

        @Test
        void invalidDouble() {
            Optional<Double> opt = getSafe("double", Double.class);
            assertTrue(opt.isEmpty());
        }

        @ParameterizedTest
        @ValueSource(floats = {
                Float.MIN_VALUE, -100.5f, -50.5f, -0.5f, 0f, 0.5f, 50.5f, 100.5f, Float.MAX_VALUE
        })
        void getFloat(float f) {
            Optional<Float> opt = getSafe(f + "", Float.class);
            assertTrue(opt.isPresent());
            assertEquals(f, opt.get());
        }

        @Test
        void invalidFloat() {
            Optional<Float> opt = getSafe("float", Float.class);
            assertTrue(opt.isEmpty());
        }

        @ParameterizedTest
        @ValueSource(ints = {
                Integer.MIN_VALUE, -100, -50, 0, 50, 100, Integer.MAX_VALUE
        })
        void getInteger(int i) {
            Optional<Integer> opt = getSafe(i + "", Integer.class);
            assertTrue(opt.isPresent());
            assertEquals(i, opt.get());
        }

        @Test
        void invalidInteger() {
            Optional<Integer> opt = getSafe("integer", Integer.class);
            assertTrue(opt.isEmpty());
        }

        @ParameterizedTest
        @ValueSource(longs = {
                Long.MIN_VALUE, -100, -50, 0, 50, 100, Long.MAX_VALUE
        })
        void getLong(long l) {
            Optional<Long> opt = getSafe(l + "", Long.class);
            assertTrue(opt.isPresent());
            assertEquals(l, opt.get());
        }

        @Test
        void invalidLong() {
            Optional<Long> opt = getSafe("long", Long.class);
            assertTrue(opt.isEmpty());
        }

        @ParameterizedTest
        @ValueSource(shorts = {
                Short.MIN_VALUE, -50, 0, 50, 100, Short.MAX_VALUE
        })
        void getShort(short s) {
            Optional<Short> opt = getSafe(s + "", Short.class);
            assertTrue(opt.isPresent());
            assertEquals(s, opt.get());
        }

        @Test
        void invalidShort() {
            Optional<Short> opt = getSafe("short", Short.class);
            assertTrue(opt.isEmpty());
        }

        @Test
        void invalidType() {
            assertThrows(IllegalArgumentException.class, () -> getSafe("fake", FakeNumber.class));
        }

        private abstract class FakeNumber extends Number {}
    }
}
