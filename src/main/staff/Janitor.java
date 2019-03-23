package main.staff;

/**
 * This class extends Auxiliary staff to create a specific type of auxiliary staff
 */
public class Janitor extends Staff
{
  public Janitor(int id)
  {
    super(id);
  }

  public String toString()
  {
    return "Janitor ID: " + super.getID() + " shifts worked: " + shiftsworked;
  }
}
