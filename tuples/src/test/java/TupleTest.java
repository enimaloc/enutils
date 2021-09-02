import fr.enimaloc.enutils.tuples.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Test tuples")
class TupleTest {

    @Nested
    @DisplayName("with 2 values")
    class Tuple2Test implements TupleGTest {
        Tuple2<String, String> tuple;

        @Override
        public Tuple2<String, String> getTuple() {
            return tuple;
        }

        @BeforeEach
        void setUp() {
            tuple = Tuples.of("a", "b");
        }

        @Override
        @Test
        public void creationWithNonNullValue() {
            assertDoesNotThrow(() -> Tuples.of("a", "b"));
        }

        @Override
        @ParameterizedTest
        @ValueSource(strings = {
                "a,null",
                "null,b",
                "null,null"
        })
        public void creationWithNullValue(String input) {
            String[] value = Arrays.stream(input.split(","))
                                   .map(in -> in.equals("null") ? null : in)
                                   .toArray(String[]::new);
            assumeTrue(value.length == 2, "value size not equals to assumed size of tuple");
            assertDoesNotThrow(
                    () -> Tuples.of(value[0], value[1]),
                    "Null value fail on new Tuple instance"
            );
        }

        @Override
        @Test
        public void variableGetter() {
            assertEquals("a", tuple.getA(), "a is not equals to \"a\"");
            assertEquals("b", tuple.getB(), "b is not equals to \"b\"");
        }

        @Override
        @ParameterizedTest
        @CsvSource({
                "a,0",
                "b,1"
        })
        public void getter(String expected, int index) {
            TupleGTest.super.getter(expected, index);
        }

        @Override
        @Test
        public void conversionToList() {
            TupleGTest.super.conversionToList(Arrays.asList("a", "b"));
        }

        @Override
        @Test
        public void equalityBetweenTupleAndAnotherTupleWithDifferentValue() {
            TupleGTest.super.equalityBetweenTupleAndAnotherTupleWithDifferentValue(Tuples.of("b", "a"));
        }

        @Override
        @Test
        public void equalityBetweenTupleAndAnotherTupleWithSameValue() {
            TupleGTest.super.equalityBetweenTupleAndAnotherTupleWithSameValue(Tuples.of("a", "b"));
        }

        @Override
        @Test
        public void size() {
            size(2);
        }

        @Override
        @Test
        public void hashCodeCorrespondence() {
            TupleGTest.super.hashCodeCorrespondence(Objects.hash("a", "b"));
        }

        @Override
        @Test
        public void toStringCorrespondence() {
            TupleGTest.super.toStringCorrespondence("[a, b]");
        }
    }

    @Nested
    @DisplayName("with 3 values")
    class Tuple3Test implements TupleGTest {
        Tuple3<String, String, String> tuple;

        @Override
        public Tuple3<String, String, String> getTuple() {
            return tuple;
        }

        @BeforeEach
        void setUp() {
            tuple = Tuples.of("a", "b", "c");
        }

        @Override
        @Test
        public void creationWithNonNullValue() {
            assertDoesNotThrow(() -> Tuples.of("a", "b", "c"));
        }

        @Override
        @ParameterizedTest
        @ValueSource(strings = {
                "a,null,null",
                "null,b,null",
                "null,null,c",
                "a,b,null",
                "null,b,c",
                "a,null,c",
                "null,null,null"
        })
        public void creationWithNullValue(String input) {
            String[] value = Arrays.stream(input.split(","))
                                   .map(in -> in.equals("null") ? null : in)
                                   .toArray(String[]::new);
            assumeTrue(value.length == 3, "value size not equals to assumed size of tuple");
            assertDoesNotThrow(
                    () -> Tuples.of(value[0], value[1], value[2]),
                    "Null value fail on new Tuple instance"
            );
        }

        @Override
        @Test
        public void variableGetter() {
            assertEquals("a", tuple.getA(), "a is not equals to \"a\"");
            assertEquals("b", tuple.getB(), "b is not equals to \"n\"");
            assertEquals("c", tuple.getC(), "c is not equals to \"c\"");
        }

        @Override
        @ParameterizedTest
        @CsvSource({
                "a,0",
                "b,1",
                "c,2"
        })
        public void getter(String expected, int index) {
            TupleGTest.super.getter(expected, index);
        }

        @Override
        @Test
        public void conversionToList() {
            conversionToList(Arrays.asList("a", "b", "c"));
        }

        @Override
        @Test
        public void equalityBetweenTupleAndAnotherTupleWithDifferentValue() {
            TupleGTest.super.equalityBetweenTupleAndAnotherTupleWithDifferentValue(Tuples.of("c", "b", "a"));
        }

        @Override
        @Test
        public void equalityBetweenTupleAndAnotherTupleWithSameValue() {
            TupleGTest.super.equalityBetweenTupleAndAnotherTupleWithSameValue(Tuples.of("a", "b", "c"));
        }

        @Override
        @Test
        public void size() {
            TupleGTest.super.size(3);
        }

        @Override
        @Test
        public void hashCodeCorrespondence() {
            TupleGTest.super.hashCodeCorrespondence(Objects.hash("a", "b", "c"));
        }

        @Override
        @Test
        public void toStringCorrespondence() {
            TupleGTest.super.toStringCorrespondence("[a, b, c]");
        }
    }

    @SuppressWarnings("Junit5MalformedParameterized")
    interface TupleGTest {

        Tuples getTuple();

        @Test
        void creationWithNonNullValue();

        @ParameterizedTest
        void creationWithNullValue(String input);

        @Test
        void variableGetter();

        @ParameterizedTest
        default void getter(String expected, int index) {
            assertEquals(expected, getTuple().get(index), "get(" + index + ") is not equals to \"" + expected + "\"");
        }

        @Test
        default void getterIOOB() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> getTuple().get(getTuple().size()),
                         "get("+getTuple().size()+") is not null but the size of Tuple is equals to "+getTuple().size());
        }

        @Test
        void conversionToList();

        default void conversionToList(List<String> expected) {
            assertEquals(expected, getTuple().toList(), "List content is not equals to expected");
        }

        @Test
        default void equalityBetweenTupleAndNotTuple() {
            assertNotEquals(new Object(), getTuple(), "Tuple and Object need to be not equals");
        }

        @Test
        void equalityBetweenTupleAndAnotherTupleWithDifferentValue();

        default void equalityBetweenTupleAndAnotherTupleWithDifferentValue(Tuples differentTuple) {
            assertNotEquals(differentTuple, getTuple(), "Tuple have different value, it can't be equals");
        }

        @Test
        void equalityBetweenTupleAndAnotherTupleWithSameValue();

        default void equalityBetweenTupleAndAnotherTupleWithSameValue(Tuples sameValueTuple) {
            assertEquals(sameValueTuple, getTuple(), "Tuple have same values, it need to be equals");
        }

        @Test
        default void equalityBetweenTupleAndSameTuple() {
            assertEquals(getTuple(), getTuple(), "Tuple are the same instance, what's wrong ?");
        }

        @Test
        void size();

        default void size(int expected) {
            assertEquals(expected, getTuple().size(), "Tuple have only "+expected+" elements");
        }

        @Test
        void hashCodeCorrespondence();

        default void hashCodeCorrespondence(int expected) {
            assertEquals(expected, getTuple().hashCode(),
                         "hashCode not corresponding");
        }

        @Test
        void toStringCorrespondence();

        default void toStringCorrespondence(String expected) {
            assertEquals(expected, getTuple().toString(), "toString not corresponding");
        }
    }
}