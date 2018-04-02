/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;

// line 8 "../../../../../LTS.ump"
public class Luggage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Luggage Attributes
  private float weight;
  private float width;
  private float height;
  private float length;
  private boolean priority;
  private boolean fragile;
  private boolean checkedIn;
  private String location;

  //Luggage Associations
  private Passenger passenger;
  private Tag tag;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Luggage(float aWeight, float aWidth, float aHeight, float aLength, boolean aPriority, boolean aFragile, boolean aCheckedIn, String aLocation, Passenger aPassenger, Tag aTag)
  {
    // line 24 "../../../../../LTS.ump"
    if (aLocation == null || aLocation.length() == 0) {
    	    	throw new RuntimeException("The location cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    weight = aWeight;
    width = aWidth;
    height = aHeight;
    length = aLength;
    priority = aPriority;
    fragile = aFragile;
    checkedIn = aCheckedIn;
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
    if (aLength<=0)
    {
      throw new RuntimeException("Please provide a valid height, length, weight, and width");
    }
  }

  public Luggage(float aWeight, float aWidth, float aHeight, float aLength, boolean aPriority, boolean aFragile, boolean aCheckedIn, String aLocation, Passenger aPassenger)
  {
    // line 24 "../../../../../LTS.ump"
    if (aLocation == null || aLocation.length() == 0) {
    	    	throw new RuntimeException("The location cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    weight = aWeight;
    width = aWidth;
    height = aHeight;
    length = aLength;
    priority = aPriority;
    fragile = aFragile;
    checkedIn = aCheckedIn;
    location = aLocation;
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create luggage due to passenger");
    }
    tag = new Tag(this);
    if (aLength<=0)
    {
      throw new RuntimeException("Please provide a valid height, length, weight, and width");
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

  public boolean setWidth(float aWidth)
  {
    boolean wasSet = false;
    if (aWidth>0)
    {
    width = aWidth;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setHeight(float aHeight)
  {
    boolean wasSet = false;
    if (aHeight>0)
    {
    height = aHeight;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setLength(float aLength)
  {
    boolean wasSet = false;
    if (aLength>0)
    {
    length = aLength;
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

  public boolean setCheckedIn(boolean aCheckedIn)
  {
    boolean wasSet = false;
    checkedIn = aCheckedIn;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    // line 29 "../../../../../LTS.ump"
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

  public float getWidth()
  {
    return width;
  }

  public float getHeight()
  {
    return height;
  }

  public float getLength()
  {
    return length;
  }

  public boolean getPriority()
  {
    return priority;
  }

  public boolean getFragile()
  {
    return fragile;
  }

  public boolean getCheckedIn()
  {
    return checkedIn;
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

  public boolean isCheckedIn()
  {
    return checkedIn;
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
            "width" + ":" + getWidth()+ "," +
            "height" + ":" + getHeight()+ "," +
            "length" + ":" + getLength()+ "," +
            "priority" + ":" + getPriority()+ "," +
            "fragile" + ":" + getFragile()+ "," +
            "checkedIn" + ":" + getCheckedIn()+ "," +
            "location" + ":" + getLocation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tag = "+(getTag()!=null?Integer.toHexString(System.identityHashCode(getTag())):"null");
  }
}