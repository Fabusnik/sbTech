package ru.fab;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aleks on 18.01.2018.
 */
public class InsuranceHoliday {
    private Date holiday;

    public InsuranceHoliday(Date holiday) {
        this.holiday = holiday;
    }

    public Date getHoliday() {
        return holiday;
    }

    public Date getTheDate(){
        return holiday;
    }
}
