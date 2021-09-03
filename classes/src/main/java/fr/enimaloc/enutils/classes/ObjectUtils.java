package fr.enimaloc.enutils.classes;

import java.util.function.Supplier;

public class ObjectUtils {

    /**
     * Safely get an object
     *
     * @param supplier Supplier where an exception can be thrown
     * @param or       Object to return if supplier thrown an error
     * @param <T>      Return type
     * @return Supplier return, if an exception was thrown or supplier return is null, return `or`
     */
    public static <T> T getOr(Supplier<T> supplier, T or) {
        try {
            return getOr(supplier.get(), or);
        } catch (Exception e) {
            return or;
        }
    }

    /**
     * Safely get an object
     *
     * @param t   Object returned if not null
     * @param or  Returned if `t` is null
     * @param <T> return type
     * @return Return `t` if not null else return `or`
     */
    public static <T> T getOr(T t, T or) {
        return t != null ? t : or;
    }
}
