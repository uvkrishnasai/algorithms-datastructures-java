package syntax;

import java.time.LocalDate;

public class DateAndTime {

    public static String getDay(String day, String month, String year) {
        return LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day))
                .getDayOfWeek()
                .name();
    }

    public static void main(String[] args) {
        System.out.println(getDay("25", "11", "1988"));

    }
}
