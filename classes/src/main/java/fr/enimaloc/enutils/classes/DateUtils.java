package fr.enimaloc.enutils.classes;

import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static String defaultFormat = "%1$d days, %2$02d hours, %3$02d minutes, %4$02d seconds, %5$03d milliseconds";

    /**
     * Format millisecond to readable human time, format used is {@link #defaultFormat}
     * @param millis Duration
     * @return Formatted string
     */
    public static String formatDateFromMillis(long millis) {
        return formatDateFromMillis(millis, defaultFormat);
    }

    /**
     * Format millisecond to readable human time
     * @param millis Duration
     * @param format Format, with positions: 1 for days, 2 for hours, 3 for minutes, 4 for seconds, 5 for milliseconds
     * @return Formatted string
     */
    public static String formatDateFromMillis(long millis, String format) {
        if (millis < 0) {
            throw new IllegalArgumentException("Millisecond must be grater than or equals zero");
        }

        long days         = TimeUnit.MILLISECONDS.toDays(millis);
        long hours        = TimeUnit.MILLISECONDS.toHours(millis) % 24;
        long minutes      = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds      = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        long milliseconds = millis % 1000;

        return format.formatted(days, hours, minutes, seconds, milliseconds);
    }

}
