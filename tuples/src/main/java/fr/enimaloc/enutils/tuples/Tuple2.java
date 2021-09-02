package fr.enimaloc.enutils.tuples;

import java.io.Serial;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Tuple2<A, B>(@Nullable A a, @Nullable B b) implements Tuples {

    @Serial
    private static final long serialVersionUID = 8200168152691172816L;

    public @Nullable
    A getA() {
        return a;
    }

    public Optional<A> getOptionalA() {
        return Optional.ofNullable(getA());
    }

    public @Nullable
    B getB() {
        return b;
    }

    public Optional<B> getOptionalB() {
        return Optional.ofNullable(getB());
    }

    @Override
    public int size() {
        return 2;
    }

    @Contract(value = " -> new", pure = true)
    @Override
    public Object @NotNull [] toArray() {
        return new Object[]{a, b};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
        return Objects.equals(a, tuple2.a) && Objects.equals(b, tuple2.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + "]";
    }
}
