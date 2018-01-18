package ru.fab;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UtilClass {
    /**
     * [startDate или текущая дата, если startDate = null или меньше текущей даты] + 5 рабочих дней + 1 календарный день + 1 год.
     * classifier - справочник содержащий даты выходных и праздничных дней
     */
    public static Date getDatePlus5WorkDaysPlus1DayPlus1Year(Date startDate, List<InsuranceHoliday> classifier) {
        Calendar calendar = Calendar.getInstance();

        if (startDate != null && startDate.compareTo(calendar.getTime()) < 0) {
            calendar.setTime(startDate);
        }

        int workingDays = 0;
        while (workingDays < 5) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            boolean weekend = false;
            for (InsuranceHoliday holiday : classifier) {
                if (holiday.getTheDate().getYear() == calendar.getTime().getYear()
                        && holiday.getTheDate().getMonth() == calendar.getTime().getMonth()
                        && holiday.getTheDate().getDay() == calendar.getTime().getDay()) {
                    weekend = true;
                    break;
                }
            }
            if (!weekend)
                workingDays++;
        }
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

}
