package fr.enimaloc.enutils.tuples;

import java.io.Serial;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Tuple3<A, B, C>(@Nullable A a, @Nullable B b, @Nullable C c) implements Tuples {

    @Serial
    private static final long serialVersionUID = 753803793015340294L;

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

    public @Nullable
    C getC() {
        return c;
    }

    public Optional<C> getOptionalC() {
        return Optional.ofNullable(getC());
    }

    @Override
    public int size() {
        return 3;
    }

    @Contract(value = " -> new", pure = true)
    @Override
    public Object @NotNull [] toArray() {
        return new Object[]{a, b, c};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(a, tuple3.a) && Objects.equals(b, tuple3.b) && Objects.equals(c,
                                                                                            tuple3.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "[" + a + ", " + b + ", " + c + "]";
    }
}
