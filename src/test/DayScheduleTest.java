package test;

import main.schedulemaker.*;
import main.staff.Staff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests related to the DaySchedules")
public class DayScheduleTest
{
    Staff stafftest = new Staff(0);

    int maxmorningstaff = 5;
    int maxafternoonstaff = 3;
    int maxnightstaff = 1;

    int date = 0;
    String day = "Monday";


    DaySchedule schedule = new DaySchedule(day, date, maxmorningstaff, maxafternoonstaff, maxnightstaff);

    @Test
    @DisplayName("Test Creation")
    void testCreation()
    {
        assertEquals(day, schedule.name);
        assertEquals(maxmorningstaff, schedule.morningstaff.length);
        assertEquals(maxafternoonstaff, schedule.afternoonstaff.length);
        assertEquals(maxnightstaff, schedule.nightstaff.length);
    }

    @Test
    @DisplayName("Test addStaff")
    void testAdd()
    {
        schedule.addStaff(stafftest, "night");
        assertSame(stafftest, schedule.nightstaff[0]);
        assertEquals(schedule.date, stafftest.shifts.get(0));
    }

    @Test
    @DisplayName("Test checkifstaffinday")
    void testCheck()
    {
        schedule.addStaff(stafftest, "afternoon");
        assertTrue(schedule.checkifstaffinday(stafftest));
    }

    @Test
    @DisplayName("Test checkpos")
    void testCheckPos()
    {
        schedule.addStaff(stafftest, "day");
        assertEquals(1, schedule.checkpos("day"));
    }

}
