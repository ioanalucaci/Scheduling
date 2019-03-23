package main.schedulemaker;

import java.util.Random;
import java.util.ArrayList;
import main.staff.*;

/**
 * This class creates the schedule for the Medical Assistants
 */
public class ScheduleMakerMA
{
  /**
   * This class creates the schedule, making sure first to give every medical assistant at least 3 night shifts and 3 afternoon shifts. Afterwards, it populates the rest of the days randomly.
   * @param mastaff the list of medical assistants to be added
   * @param month the month schedule to be populated
   */
    public void scheduleMA(ArrayList<MedicalAssistant> mastaff, MonthSchedule month)
  {
    DaySchedule[] schedule = month.schedulema;

    int maxmorningma = 7;
    int maxafternoonma = 5;
    int maxnightma = 2;

    Random randomGenerator = new Random();

    boolean check = false;
    for(MedicalAssistant ma : mastaff)
    {
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
    for(DaySchedule day : schedule)
    {
      addMA(day, "day", maxmorningma, mastaff);
      addMA(day, "night", maxnightma, mastaff);
      if(day.weekday) addMA(day, "afternoon", maxafternoonma, mastaff);
    }
  }

  /**
   * This function fills a certain shift with randomly picked medical assistants
   * @param day the day schedule from where the shift is picked
   * @param time the shift to be filled
   * @param max the number of staff members needed on that shift
   * @param mas the medical assistants available to be picked for the shift
   */
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
