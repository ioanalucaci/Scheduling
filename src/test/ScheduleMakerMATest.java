package test;

import main.schedulemaker.*;
import main.staff.*;

import main.staff.MedicalAssistant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests related to the DaySchedulesMA")
class ScheduleMakerMATest
{
    ArrayList<MedicalAssistant> staff = new ArrayList<>();

    int maxmorningstaff = 5;
    int maxafternoonstaff = 4;
    int maxnightstaff = 2;

    int date = 1;
    String day = "Monday";


    DaySchedule schedule = new DaySchedule(day, date, maxmorningstaff, maxafternoonstaff, maxnightstaff);
    ScheduleMakerMA schedulemaker = new ScheduleMakerMA();


    @Test
    @DisplayName("Test addMA and if staff is updated")
    void testAddStaff()
    {
        for(int i = 0; i < 5; i ++)
            staff.add(new MedicalAssistant(i));

        schedulemaker.addMA(schedule, "night", 2, staff);

        int counter = 0;

        for(Staff ma : schedule.nightstaff)
            if(ma == null)
                counter++;
            else
            {
                assertNotEquals(0, ma.shiftsworked);
                assertEquals(schedule.date, ma.shifts.get(0));
                assertEquals(ma.lastnightshift, schedule.date);
            }

        assertEquals(0, counter);

    }
}