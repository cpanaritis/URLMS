/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-f40f105-3613 modeling language!*/

package ca.mcgill.ecse321.urlms.model;

// line 54 "../../../../../URLMS.ump"
public class ProgressUpdate
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgressUpdate Attributes
  private String title;
  private String report;

  //Autounique Attributes
  private int id;

  //ProgressUpdate Associations
  private Laboratory laboratory;
  private Staff staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ProgressUpdate(String aTitle, String aReport, Laboratory aLaboratory, Staff aStaff)
  {
    title = aTitle;
    report = aReport;
    id = nextId++;
    boolean didAddLaboratory = setLaboratory(aLaboratory);
    if (!didAddLaboratory)
    {
      throw new RuntimeException("Unable to create progressUpdate due to laboratory");
    }
    boolean didAddStaff = setStaff(aStaff);
    if (!didAddStaff)
    {
      throw new RuntimeException("Unable to create progressUpdate due to staff");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setReport(String aReport)
  {
    boolean wasSet = false;
    report = aReport;
    wasSet = true;
    return wasSet;
  }

  public String getTitle()
  {
    return title;
  }

  public String getReport()
  {
    return report;
  }

  public int getId()
  {
    return id;
  }

  public Laboratory getLaboratory()
  {
    return laboratory;
  }

  public Staff getStaff()
  {
    return staff;
  }

  public boolean setLaboratory(Laboratory aLaboratory)
  {
    boolean wasSet = false;
    if (aLaboratory == null)
    {
      return wasSet;
    }

    Laboratory existingLaboratory = laboratory;
    laboratory = aLaboratory;
    if (existingLaboratory != null && !existingLaboratory.equals(aLaboratory))
    {
      existingLaboratory.removeProgressUpdate(this);
    }
    laboratory.addProgressUpdate(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setStaff(Staff aStaff)
  {
    boolean wasSet = false;
    if (aStaff == null)
    {
      return wasSet;
    }

    Staff existingStaff = staff;
    staff = aStaff;
    if (existingStaff != null && !existingStaff.equals(aStaff))
    {
      existingStaff.removeProgressUpdate(this);
    }
    staff.addProgressUpdate(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Laboratory placeholderLaboratory = laboratory;
    this.laboratory = null;
    placeholderLaboratory.removeProgressUpdate(this);
    Staff placeholderStaff = staff;
    this.staff = null;
    placeholderStaff.removeProgressUpdate(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "title" + ":" + getTitle()+ "," +
            "report" + ":" + getReport()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "laboratory = "+(getLaboratory()!=null?Integer.toHexString(System.identityHashCode(getLaboratory())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "staff = "+(getStaff()!=null?Integer.toHexString(System.identityHashCode(getStaff())):"null");
  }
}