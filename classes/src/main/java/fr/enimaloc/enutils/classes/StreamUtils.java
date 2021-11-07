package fr.enimaloc.enutils.classes;

import java.util.function.Consumer;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

public class StreamUtils {

    public static <T> T if_(T input, Function<T, Boolean> condition, Function<T, T> do_) {
        return elif_(input, condition, do_, in -> in);
    }

    public static <T> T else_(T input, Function<T, Boolean> condition, Function<T, T> do_) {
        return elif_(input, condition, in -> in, do_);
    }

    public static <T, R> R elif_(T input, Function<T, Boolean> condition, Function<T, R> if_, Function<T, R> else_) {
        return condition.apply(input) ? if_.apply(input) : else_.apply(input);
    }

}
