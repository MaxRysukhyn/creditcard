package com.magzim.creditcard.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by max on 7/1/15.
 */
public class TimeUtil {
    public static final DateTimeFormatter DATE_TME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "null" : ldt.format(DATE_TME_FORMATTER);
    }
}
