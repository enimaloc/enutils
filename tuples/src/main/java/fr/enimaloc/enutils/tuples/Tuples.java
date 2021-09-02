package fr.enimaloc.enutils.tuples;

import java.io.Serializable;
import java.util.*;
import org.jetbrains.annotations.*;

public interface Tuples extends Iterable<Object>, Serializable {

    @Contract("_, _ -> new")
    static <A, B> @NotNull Tuple2<A, B> of(A a, B b) {
        return new Tuple2<>(a, b);
    }

    @Contract("_, _, _ -> new")
    static <A, B, C> @NotNull Tuple3<A, B, C> of(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    int size();

    default boolean isEmpty(int index) {
        return getOptional(index).isEmpty();
    }

    default @Nullable Object get(int index) {
        return toArray()[index];
    }

    default Optional<Object> getOptional(int index) {
        return Optional.ofNullable(get(index));
    }

    Object[] toArray();

    default List<Object> toList() {
        return Arrays.asList(toArray());
    }

    @NotNull
    @Override
    default Iterator<Object> iterator() {
        return Collections.unmodifiableList(toList()).iterator();
    }

    boolean equals(Object o);

    int hashCode();
}
