package lsieun.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate() {
        Date now = new Date();
        return df.format(now);
    }
}
