package main.staff;

import java.util.ArrayList;

/**
 * This class implements the attributes of the Staff members.
 * @author Ioana Iulia Lucaci
 */
public class Staff
{
  private int id;

  public boolean dayshift;
  public boolean afternoonshift;
  public boolean nightshift;

  public int shiftsworked;
  public int lastnightshift;

  public ArrayList<Integer> shifts = new ArrayList<Integer>();

  /**
   * This function creates a new instance of Staff
   * @param id this creates a new Staff instance based on the id
   */
  public Staff(int id)
  {
    this.id = id;

    this.dayshift = true;
    this.afternoonshift = true;
    this.nightshift = true;

    shiftsworked = 0;
    lastnightshift = 40;
  }

  /**
   * This function is a getter for the private id
   * @return int id
   */
  public int getID()
  {
    return this.id;
  }

  /**
   * This function returns whether or not the given date is too close to the last night shift the staff worked
   * @param date this shows the date to be checked
   * @return true if the date is too close ot the last night shift
   */
  public boolean notclosetonightshift(int date)
  {
    if (lastnightshift + 1 == date || lastnightshift + 2 == date)
      return false;
    else return true;
  }

  public String toString()
  {
    return "Staff ID: " + this.getID() + " shifts worked: " + shifts.toString();
  }
}
