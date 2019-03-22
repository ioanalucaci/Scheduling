package test;

import main.schedulemaker.*;
import main.staff.AuxStaff;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests related to the DaySchedules")
class ScheduleMakerTest
{
    ArrayList<AuxStaff> staff = new ArrayList<AuxStaff>();
    ScheduleMaker schedulemaker;

    int maxmorningstaff = 5;
    int maxafternoonstaff = 3;
    int maxnightstaff = 1;

    int date = 1;
    String day = "Monday";


    DaySchedule schedule = new DaySchedule(day, date, maxmorningstaff, maxafternoonstaff, maxnightstaff);
    @Test
    @DisplayName("Test addStaff and if staff is updated")
    void testAddStaff()
    {
        for(int i = 0; i < 10; i ++)
        {
            staff.add(new AuxStaff(i));
        }

        ScheduleMaker schedulemaker = new ScheduleMaker();
        schedulemaker.addStaff(schedule, "day", 5, staff);

        int counter = 0;

        for(int i = 0; i < 5; i ++)
            if(schedule.morningstaff[i] == null)
                counter++;
            else
            {
                assertNotEquals(0, schedule.morningstaff[i].shiftsworked);
                assertEquals(schedule.date, schedule.morningstaff[i].shifts.get(0));
            }

         assertEquals(0, counter);

    }
}
