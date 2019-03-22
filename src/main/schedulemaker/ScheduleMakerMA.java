package main.schedulemaker;

import java.util.Random;
import java.util.ArrayList;
import main.staff.*;

public class ScheduleMakerMA
{
    public void scheduleMA(ArrayList<MedicalAssistant> mastaff, MonthSchedule month)
  {
    DaySchedule[] schedule = month.schedulema;

    int maxmorningma = 7;
    int maxafternoonma = 5;
    int maxnightma = 2;

    Random randomGenerator = new Random();

    boolean check = false;
    //nurses must each have 3 nights and 3 afternoons, and this loop ensures each nurse will have that.
    for(MedicalAssistant ma : mastaff)
    {
      //the loop assigns them to 3 random nights
      while(ma.nightsworked < 3)
      {
        check = false;
        int index = randomGenerator.nextInt(schedule.length);
        DaySchedule day = schedule[index];
        check = day.addStaff(ma, "night");

        if(check)
        {
          ma.lastnightshift= day.date;
          ma.nightsworked++;
        }
        if(ma.nightsworked == 3)
          break;
      }

      //this loop assigns them to 3 random afternoons
      while(ma.afternoonsworked < 3)
      {
        check = false;
        int index = randomGenerator.nextInt(schedule.length);
        DaySchedule day = schedule[index];
        check = day.addStaff(ma, "afternoon");
        if(check) ma.afternoonsworked++;
        if(ma.afternoonsworked == 3)
          break;
      }
    }

    //all is left is to fill all the other days randomly
    for(DaySchedule day : schedule)
    {
      addMA(day, "day", maxmorningma, mastaff);
      addMA(day, "night", maxnightma, mastaff);
      //on Saturday and Sunday, there are 2 shifts of 12 hours instead of 3 shifts of 8 hours
      if(day.weekday) addMA(day, "afternoon", maxafternoonma, mastaff);
    }
  }

    public void addMA(DaySchedule day, String time, int max, ArrayList<MedicalAssistant> mas)
  {
    Random randomGenerator = new Random();

    int i = 0;
    boolean check = false;
    int lastpos = day.checkpos(time);

    while (lastpos < max && i < max)
      {
        int index = randomGenerator.nextInt(mas.size());
        MedicalAssistant personell = mas.get(index);

        check = day.addStaff(personell, time);
        if(check)
        {
          i++;
          personell.shiftsworked ++;
        }
        lastpos = day.checkpos(time);
      }
  }
}
