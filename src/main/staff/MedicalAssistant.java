package main.staff;

/**
 * This class extends Staff to create a specific type of Staff
 */
public class MedicalAssistant extends Staff
{
  public int nightsworked;
  public int afternoonsworked;
  public MedicalAssistant(int id)
  {
    super(id);
    this.nightsworked = 0;
    this.afternoonsworked = 0;
  }

  public String toString()
  {
    return "MedicalAssistant ID: " + super.getID() + " shifts worked: " + shiftsworked;
  }
}
