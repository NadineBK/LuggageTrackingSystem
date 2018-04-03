/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.ecse681.lts.model;

// line 12 "../../../../../LTS.ump"
public class Luggage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Luggage Attributes
  private float weight;
  private boolean priority;
  private boolean fragile;

  //Luggage Associations
  private Passenger passenger;
  private Tag tag;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Luggage(float aWeight, boolean aPriority, boolean aFragile, Passenger aPassenger, Tag aTag)
  {
    weight = aWeight;
    priority = aPriority;
    fragile = aFragile;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create luggage due to passenger");
    }
    if (aTag == null || aTag.getLuggage() != null)
    {
      throw new RuntimeException("Unable to create Luggage due to aTag");
    }
    tag = aTag;
    if (aWeight<=0)
    {
      throw new RuntimeException("Please provide a valid weight");
    }
  }

  public Luggage(float aWeight, boolean aPriority, boolean aFragile, Passenger aPassenger)
  {
    weight = aWeight;
    priority = aPriority;
    fragile = aFragile;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create luggage due to passenger");
    }
    tag = new Tag(this);
    if (aWeight<=0)
    {
      throw new RuntimeException("Please provide a valid weight");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWeight(float aWeight)
  {
    boolean wasSet = false;
    if (aWeight>0)
    {
    weight = aWeight;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setPriority(boolean aPriority)
  {
    boolean wasSet = false;
    priority = aPriority;
    wasSet = true;
    return wasSet;
  }

  public boolean setFragile(boolean aFragile)
  {
    boolean wasSet = false;
    fragile = aFragile;
    wasSet = true;
    return wasSet;
  }

  public float getWeight()
  {
    return weight;
  }

  public boolean getPriority()
  {
    return priority;
  }

  public boolean getFragile()
  {
    return fragile;
  }

  public boolean isPriority()
  {
    return priority;
  }

  public boolean isFragile()
  {
    return fragile;
  }

  public Passenger getPassenger()
  {
    return passenger;
  }

  public Tag getTag()
  {
    return tag;
  }

  public boolean setPassenger(Passenger aPassenger)
  {
    boolean wasSet = false;
    //Must provide passenger to luggage
    if (aPassenger == null)
    {
      return wasSet;
    }

    //passenger already at maximum (2)
    if (aPassenger.numberOfLuggages() >= Passenger.maximumNumberOfLuggages())
    {
      return wasSet;
    }
    
    Passenger existingPassenger = passenger;
    passenger = aPassenger;
    if (existingPassenger != null && !existingPassenger.equals(aPassenger))
    {
      boolean didRemove = existingPassenger.removeLuggage(this);
      if (!didRemove)
      {
        passenger = existingPassenger;
        return wasSet;
      }
    }
    passenger.addLuggage(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Passenger placeholderPassenger = passenger;
    this.passenger = null;
    placeholderPassenger.removeLuggage(this);
    Tag existingTag = tag;
    tag = null;
    if (existingTag != null)
    {
      existingTag.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "weight" + ":" + getWeight()+ "," +
            "priority" + ":" + getPriority()+ "," +
            "fragile" + ":" + getFragile()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tag = "+(getTag()!=null?Integer.toHexString(System.identityHashCode(getTag())):"null");
  }
}