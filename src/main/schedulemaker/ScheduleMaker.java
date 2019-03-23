package main.schedulemaker;

import java.util.Random;
import java.util.ArrayList;
import main.staff.*;

public class ScheduleMaker
{
  public void staffSchedule(ArrayList<Staff> staff, MonthSchedule month)
  {
    DaySchedule[] schedule = month.schedule;

    int maxmorningstaff = 5;
    int maxafternoonstaff = 4;
    int maxnightstaff = 2;

    //this calls the function 'addStaff' for every single shift
    for(DaySchedule day : schedule)
    {
      addStaff(day, "day", maxmorningstaff, staff);
      addStaff(day, "night", maxnightstaff, staff);
      //on Saturday and Sunday, there are 2 shifts of 12 hours instead of 3 shifts of 8 hours
      if(day.weekday) addStaff(day, "afternoon", maxafternoonstaff, staff);
    }
  }

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