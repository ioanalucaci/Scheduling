package test;

import main.schedulemaker.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Tests for the creation of MonthSchedule")
class MonthTest
{
    int start = 0;
    int numofdays = 31;
    MonthSchedule month = new MonthSchedule(start, numofdays);

    @Test
    @DisplayName("Test number of days")
    void testDaysCreation()
    {
        assertEquals(numofdays, month.schedule.length);
        assertEquals(numofdays, month.schedulema.length);
    }

    @Test
    @DisplayName("Test first day")
    void testFirstDay()
    {
        String day = "Monday";

        assertEquals(day, month.schedule[0].name);
        assertEquals(day, month.schedulema[0].name);
    }
}