package test;

import main.schedulemaker.*;
import main.staff.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests related to the DaySchedules")
class ScheduleMakerTest
{
    ArrayList<Staff> staff = new ArrayList<Staff>();

    int maxmorningstaff = 5;
    int maxafternoonstaff = 3;
    int maxnightstaff = 2;

    int date = 1;
    String day = "Monday";


    DaySchedule schedule = new DaySchedule(day, date, maxmorningstaff, maxafternoonstaff, maxnightstaff);
    ScheduleMaker schedulemaker = new ScheduleMaker();


    @Test
    @DisplayName("Test addStaff and if staff is updated")
    void testAddStaff()
    {
        for(int i = 0; i < 10; i ++)
            staff.add(new Staff(i));

        schedulemaker.addStaff(schedule, "day", 5, staff);

        int counter = 0;

        for(Staff aux : schedule.morningstaff)
            if(aux == null)
                counter++;
            else
            {
                assertNotEquals(0, aux.shiftsworked);
                assertEquals(schedule.date, aux.shifts.get(0));
            }

         assertEquals(0, counter);

    }
}
