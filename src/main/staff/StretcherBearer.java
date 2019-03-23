package main.staff;

/**
 * This class extends Auxiliary staff to create a specific type of auxiliary staff
 */
public class StretcherBearer extends Staff
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
