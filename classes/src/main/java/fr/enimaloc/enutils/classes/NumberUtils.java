package fr.enimaloc.enutils.classes;

import java.util.Optional;

public class NumberUtils {

    /**
     * Converts a {@link String} into its numerical value. If the provided {@link String} does not represent a number,
     * an empty {@link Optional} is returned
     *
     * @param value       {@link String} to parse
     * @param targetClazz used to define the return type
     * @param <T>         target class defined with {@code value} parameter, need to {@code extends} {@link Number} {@link Class}
     * @return an {@link Optional} which can be empty if the {@link String value} cannot be parsed in
     * the target {@link Number class} else the {@link String value} parsed in the {@link Number targeted}
     * {@link Class}
     */
    public static <T extends Number> Optional<T> getSafe(String value, Class<T> targetClazz) {
        try {
            if (Byte.class == targetClazz) {
                return Optional.of(targetClazz.cast(Byte.valueOf(value)));
            }
            if (Double.class == targetClazz) {
                return Optional.of(targetClazz.cast(Double.valueOf(value)));
            }
            if (Float.class == targetClazz) {
                return Optional.of(targetClazz.cast(Float.valueOf(value)));
            }
            if (Integer.class == targetClazz) {
                return Optional.of(targetClazz.cast(Integer.valueOf(value)));
            }
            if (Long.class == targetClazz) {
                return Optional.of(targetClazz.cast(Long.valueOf(value)));
            }
            if (Short.class == targetClazz) {
                return Optional.of(targetClazz.cast(Short.valueOf(value)));
            }
            throw new IllegalArgumentException(
                    String.format("Class %s is not currently supported", targetClazz.getName()));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }
}
