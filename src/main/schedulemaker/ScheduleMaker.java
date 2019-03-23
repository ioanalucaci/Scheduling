package main.schedulemaker;

import java.util.Random;
import java.util.ArrayList;
import main.staff.*;

/**
 * This class creates the schedules of the staff
 */
public class ScheduleMaker
{
  /**
   * This function creates the schedule
   * @param staff this is the list of staff members to be added in the schedule
   * @param month this is the month schedule that the staff has to be added to
   */
  public void staffSchedule(ArrayList<Staff> staff, MonthSchedule month)
  {
    DaySchedule[] schedule = month.schedule;

    int maxmorningstaff = 5;
    int maxafternoonstaff = 4;
    int maxnightstaff = 2;

    for(DaySchedule day : schedule)
    {
      addStaff(day, "day", maxmorningstaff, staff);
      addStaff(day, "night", maxnightstaff, staff);
      //on Saturday and Sunday, there are 2 shifts of 12 hours instead of 3 shifts of 8 hours
      if(day.weekday) addStaff(day, "afternoon", maxafternoonstaff, staff);
    }
  }

  /**
   * This adds staff members to a specific day
   * @param day the day that the staff member has to be added to
   * @param time the specific shift to be added to
   * @param max the number of personnel a shift can have
   * @param staff the list of staff from where the selection will be made
   */
  public void addStaff(DaySchedule day, String time, int max, ArrayList<Staff> staff)
  {
    Random randomGenerator = new Random();
    int i = 0;
    boolean check = false;
    while(i < max)
    {
      int index = randomGenerator.nextInt(staff.size());
      Staff personell = staff.get(index);
      check = day.addStaff(personell, time);
      if(check)
      {
        i++;
        personell.shiftsworked ++;
      }
    }
  }
}