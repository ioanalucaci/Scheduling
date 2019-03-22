package main.staff;

import java.util.ArrayList;

public class Staff
{
  private int id;

  public boolean dayshift;
  public boolean afternoonshift;
  public boolean nightshift;

  public int shiftsworked;
  public int lastnightshift;

  public ArrayList<Integer> shifts = new ArrayList<Integer>();

  public Staff(int id)
  {
    this.id = id;

    this.dayshift = true;
    this.afternoonshift = true;
    this.nightshift = true;

    shiftsworked = 0;
    lastnightshift = 40;
  }

  public int getID()
  {
    return this.id;
  }

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
