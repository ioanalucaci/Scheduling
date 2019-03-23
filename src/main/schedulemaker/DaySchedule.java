package main.schedulemaker;
import java.util.Arrays;
import main.staff.*;

/**
 * This class is created to store the information for all shifts
 */
public class DaySchedule
{
  public String name;
  public int date;
  public boolean weekday;

  public Staff[] morningstaff;
  public Staff[] afternoonstaff;
  public Staff[] nightstaff;

  public int maxmorningstaff;
  public int maxafternoonstaff;
  public int maxnightstaff;

  /**
   * This is a setter for DaySchedule
   * @param name this records the day of the week
   * @param date this shows the day of the month
   * @param maxmorningstaff this records how many people have to be in the morning shift
   * @param maxafternoonstaff this records how many people have to be in the afternoon shift
   * @param maxnightstaff this records how many people have to be in the night shift
   */
  public DaySchedule(String name, int date, int maxmorningstaff, int maxafternoonstaff, int maxnightstaff)
  {

    this.maxmorningstaff = maxmorningstaff;
    this.maxafternoonstaff = maxafternoonstaff;
    this.maxnightstaff = maxnightstaff;

    this.name = name;
    this.date = date;

    this.morningstaff = new Staff[maxmorningstaff];
    this.nightstaff = new Staff[maxnightstaff];

    this.weekday = true;

    if(this.name.equals("Saturday") || this.name.equals("Sunday")) this.weekday = false;
    else this.afternoonstaff = new Staff[maxafternoonstaff];
  }

  /**
   * This function adds the staff member to a specific shift
   * @param staff this is the staff to be added
   * @param time this shows whether the shift is the morning, afternoon or night shift
   * @return the function returns true if the staff was successfully added to the shift; false otherwise
   */
  public boolean addStaff(Staff staff, String time)
  {
    if(checkifstaffinday(staff)) return false;
    if(!staff.notclosetonightshift(this.date)) return false;

    boolean check = false;

    switch(time)
    {
      case "day":
        if(staff.dayshift)
        {
          int pos = checkpos("day");
          if(pos >= this.morningstaff.length) break;
          this.morningstaff[pos] = staff;
          staff.shifts.add(this.date);
          check = true;
        }
        break;

      case "afternoon":
        if(staff.afternoonshift)
        {
          if (weekday)
          {
            int pos = checkpos("afternoon");
            if(pos >= this.afternoonstaff.length) break;
            this.afternoonstaff[pos] = staff;
            staff.shifts.add(this.date);
            check = true;
          }
        }
        break;

      case "night":
        if(staff.nightshift)
        {
          int pos = checkpos("night");
          if(pos >= this.nightstaff.length) break;
          this.nightstaff[pos] = staff;
          staff.shifts.add(this.date);
          staff.lastnightshift = date;
          check = true;
        }
        break;
    }
    return check;
  }

  /**
   * This function checks whether the staff member is already scheduled for the day, no matter which shift
   * @param staff the staff member to be checked
   * @return true if the staff member is already in the shift, false otherwise
   */
  public boolean checkifstaffinday(Staff staff)
  {
    if(this.weekday)
      return Arrays.asList(morningstaff).contains(staff) || Arrays.asList(afternoonstaff).contains(staff) || Arrays.asList(nightstaff).contains(staff);
      else return Arrays.asList(morningstaff).contains(staff) || Arrays.asList(nightstaff).contains(staff);
  }

  /**
   * This returns the first empty slot in a specific shift
   * @param time this shows which shift to check
   * @return the first empty slot of a shift
   */
  public int checkpos(String time)
  {
    int i = 0;
    switch(time)
    {
      case "day":
        for(i = 0; i < morningstaff.length; i++) if(morningstaff[i] == null) break;
        break;
      case "afternoon":
        if(weekday == true) for(i = 0; i < afternoonstaff.length; i++) if(afternoonstaff[i] == null) break;
        break;
      case "night":
       for(i = 0; i<nightstaff.length; i++) if(nightstaff[i] == null) break;
    }
    return i;
  }

  public String toString()
  {
    String str = "\n Morning main.staff: ";
    for (Staff staff : morningstaff) {
      if (staff != null)
        str += " " + staff.getID() + " ///";
      else str += " null ///";
    }
    if(this.weekday )
    {
      str += "\n Afternoon main.staff: ";
      for (Staff staff : afternoonstaff) {
        if (staff != null)
          str += " " + staff.getID() + " ///";
        else str += " null ///";
      }
    }
    str += "\n Night main.staff: ";
    for (Staff staff : nightstaff) {
      if (staff != null)
        str += " " + staff.getID() + " ///";
      else str += " null ///";
    }
    return name + ", " + date + str;
  }
}
