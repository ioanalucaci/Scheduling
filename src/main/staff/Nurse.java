package main.staff;

public class Nurse extends AuxStaff
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
