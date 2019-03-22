package main.schedulemaker;

public class MonthSchedule
{
  public DaySchedule[] schedule;
  public DaySchedule[] schedulema;

  //this function initially creates the month-like array
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

    //this creates an array of days that correspond to a specific month
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

  public String staffString()
  {
    String str = "\n\nSTAFF SCHEDULE---\n";
    for (DaySchedule daySchedule : schedule) {
      str += daySchedule.toString() + " \n ---\n";
    }
    return str;
  }

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
