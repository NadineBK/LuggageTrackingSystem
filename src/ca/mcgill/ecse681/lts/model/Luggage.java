/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

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
  private String location;

  //Luggage Associations
  private Passenger passenger;
  private Tag tag;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Luggage(float aWeight, boolean aPriority, boolean aFragile, String aLocation, Passenger aPassenger, Tag aTag)
  {
    // line 20 "../../../../../LTS.ump"
    if (aLocation == null || aLocation.length() == 0) {
    	    	throw new RuntimeException("The name of a passenger cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    weight = aWeight;
    priority = aPriority;
    fragile = aFragile;
    location = aLocation;
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

  public Luggage(float aWeight, boolean aPriority, boolean aFragile, String aLocation, Passenger aPassenger)
  {
    // line 20 "../../../../../LTS.ump"
    if (aLocation == null || aLocation.length() == 0) {
    	    	throw new RuntimeException("The name of a passenger cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    weight = aWeight;
    priority = aPriority;
    fragile = aFragile;
    location = aLocation;
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

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    // line 25 "../../../../../LTS.ump"
    if (aLocation == null || aLocation.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    location = aLocation;
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

  public String getLocation()
  {
    return location;
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
    if(placeholderPassenger != null)
    {
      placeholderPassenger.removeLuggage(this);
    }
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
            "fragile" + ":" + getFragile()+ "," +
            "location" + ":" + getLocation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tag = "+(getTag()!=null?Integer.toHexString(System.identityHashCode(getTag())):"null");
  }
}