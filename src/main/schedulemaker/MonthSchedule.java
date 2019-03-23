package main.schedulemaker;

/**
 *This class creates a month of day schedules to store all the information
 *
 */
public class MonthSchedule
{
  public DaySchedule[] schedule;
  public DaySchedule[] schedulema;

  /**
   * This function creates the month schedule and populates the two arrays with the correct DaySchedules
   * @param counter the day of the week the month starts with
   * @param numofdays the number of days the month has
   */
  public MonthSchedule(int counter, int numofdays)
  {
    int maxmorningaux = 5;
    int maxafternoonaux = 4;
    int maxnightaux = 2;

    int maxmorningma = 7;
    int maxafternoonma = 5;
    int maxnightma = 2;

    String [] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    DaySchedule[] schedule = new DaySchedule[numofdays];
    DaySchedule[] schedulema = new DaySchedule[numofdays];

    for(int i = 1; i <= numofdays; i++)
    {
      DaySchedule temp = new DaySchedule(week[counter], i, maxmorningaux, maxafternoonaux, maxnightaux);
      DaySchedule tempma = new DaySchedule(week[counter], i, maxmorningma, maxafternoonma, maxnightma);
      schedule[i-1] = temp;
      schedulema[i-1] = tempma;
      counter ++;
      if (counter == 7)
        counter = 0;
    }
    this.schedule = schedule;
    this.schedulema = schedulema;
  }

  /**
   * This function is used to format the staff schedule nicely
   * @return a string containing all the information regarding the staff schedule
   */
  public String staffString()
  {
    String str = "\n\nSTAFF SCHEDULE---\n";
    for (DaySchedule daySchedule : schedule) {
      str += daySchedule.toString() + " \n ---\n";
    }
    return str;
  }

  /**
   * This function is used to format the medical assistant schedule nicely
   * @return a string containing all information regarding the medical assistant schedule
   */
  public String maString()
  {
    String str = "\n\nMEDICAL ASSISTANT SCHEDULE---\n";
    for (DaySchedule DaySchedule : schedulema) {
      str += DaySchedule.toString() + " \n ---\n";
    }
    return str;
  }

  public String toString()
  {
    return staffString() + maString();
  }
}
