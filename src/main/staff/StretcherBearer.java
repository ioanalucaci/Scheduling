package main.staff;

public class StretcherBearer extends AuxStaff
{
  public StretcherBearer(int id)
  {
    super(id);
    this.nightshift = false;
    this.afternoonshift = false;
  }

  public String toString()
  {
    return "StretcherBearer ID: " + super.getID() + " shifts worked: " + shiftsworked;
  }
}
