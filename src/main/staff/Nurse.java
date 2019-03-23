package main.staff;

/**
 * This class extends Auxiliary staff to create a specific type of auxiliary staff
 */
public class Nurse extends Staff
{
  public Nurse(int id)
  {
    super(id);
  }

  public String toString()
  {
    return "Nurse ID: " + super.getID() + " shifts worked: " + shiftsworked;
  }
}
