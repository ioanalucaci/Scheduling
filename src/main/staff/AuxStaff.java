package main.staff;

public class AuxStaff extends Staff
{

  public AuxStaff(int id)
  {
    super(id);
  }

  public int getID()
  {
    return super.getID();
  }

  public String toString()
  {
    return "Auxiliary Staff ID: " + this.getID() + " shifts worked: " + shiftsworked;
  }
}
