package main.staff;

public class Janitor extends AuxStaff
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
