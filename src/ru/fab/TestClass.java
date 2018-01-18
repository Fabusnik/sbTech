package ru.fab;

import java.util.*;

public class TestClass {

    private static boolean isHoliday(Calendar date) {
        boolean test;
        test = (date.DAY_OF_WEEK == 7) || (date.DAY_OF_WEEK == 1);
        return test;
    }

    public static void main(String[] args) {
        List<InsuranceHoliday> holidayList = new ArrayList<>();

        Calendar startDate = Calendar.getInstance();
        startDate.set(2018, 0, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 31);

        while (startDate.before(endDate)) {
            if (startDate.get(Calendar.DAY_OF_WEEK) == 7 || startDate.get(Calendar.DAY_OF_WEEK) == 1) {
                holidayList.add(new InsuranceHoliday(startDate.getTime()));
            }
            startDate.add(Calendar.DAY_OF_YEAR, 1);
        }

//        for (InsuranceHoliday iter : holidayList){
//            System.out.println(iter.getHoliday().toString());
//        }

        Calendar date = Calendar.getInstance();
        date.set(2018,0,5);
        System.out.println(UtilClass.getDatePlus5WorkDaysPlus1DayPlus1Year(date.getTime(), holidayList));

        System.out.println(UtilClass.getDatePlus5WorkDaysPlus1DayPlus1Year(null, holidayList));
    }
}
