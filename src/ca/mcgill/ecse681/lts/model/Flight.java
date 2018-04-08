/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.sql.Date;
import java.util.*;

// line 70 "../../../../../LTS.ump"
public class Flight
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Flight Attributes
  private String source;
  private String destination;
  private Date flightdate;
  private String airline;
  private String number;

  //Flight Associations
  private List<Tag> tags;
  private LTS lTS;
  private List<Passenger> passengers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Flight(String aSource, String aDestination, Date aFlightdate, String aAirline, String aNumber, LTS aLTS)
  {
    // line 81 "../../../../../LTS.ump"
    if (aSource == null || aSource.length() == 0) {
    	    	throw new RuntimeException("The source cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    // line 92 "../../../../../LTS.ump"
    if (aDestination == null || aDestination.length() == 0) {
    	    	throw new RuntimeException("The destination cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    // line 103 "../../../../../LTS.ump"
    if (aAirline == null || aAirline.length() == 0) {
    	    	throw new RuntimeException("The airline cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    // line 114 "../../../../../LTS.ump"
    if (aNumber == null || aNumber.length() == 0) {
    	    	throw new RuntimeException("The flight number cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    source = aSource;
    destination = aDestination;
    flightdate = aFlightdate;
    airline = aAirline;
    number = aNumber;
    tags = new ArrayList<Tag>();
    boolean didAddLTS = setLTS(aLTS);
    if (!didAddLTS)
    {
      throw new RuntimeException("Unable to create flight due to lTS");
    }
    passengers = new ArrayList<Passenger>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSource(String aSource)
  {
    boolean wasSet = false;
    // line 86 "../../../../../LTS.ump"
    if (aSource == null || aSource.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    source = aSource;
    wasSet = true;
    return wasSet;
  }

  public boolean setDestination(String aDestination)
  {
    boolean wasSet = false;
    // line 97 "../../../../../LTS.ump"
    if (aDestination == null || aDestination.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    destination = aDestination;
    wasSet = true;
    return wasSet;
  }

  public boolean setFlightdate(Date aFlightdate)
  {
    boolean wasSet = false;
    flightdate = aFlightdate;
    wasSet = true;
    return wasSet;
  }

  public boolean setAirline(String aAirline)
  {
    boolean wasSet = false;
    // line 108 "../../../../../LTS.ump"
    if (aAirline == null || aAirline.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    airline = aAirline;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    // line 119 "../../../../../LTS.ump"
    if (aNumber == null || aNumber.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public String getSource()
  {
    return source;
  }

  public String getDestination()
  {
    return destination;
  }

  public Date getFlightdate()
  {
    return flightdate;
  }

  public String getAirline()
  {
    return airline;
  }

  public String getNumber()
  {
    return number;
  }

  public Tag getTag(int index)
  {
    Tag aTag = tags.get(index);
    return aTag;
  }

  public List<Tag> getTags()
  {
    List<Tag> newTags = Collections.unmodifiableList(tags);
    return newTags;
  }

  public int numberOfTags()
  {
    int number = tags.size();
    return number;
  }

  public boolean hasTags()
  {
    boolean has = tags.size() > 0;
    return has;
  }

  public int indexOfTag(Tag aTag)
  {
    int index = tags.indexOf(aTag);
    return index;
  }

  public LTS getLTS()
  {
    return lTS;
  }

  public Passenger getPassenger(int index)
  {
    Passenger aPassenger = passengers.get(index);
    return aPassenger;
  }

  public List<Passenger> getPassengers()
  {
    List<Passenger> newPassengers = Collections.unmodifiableList(passengers);
    return newPassengers;
  }

  public int numberOfPassengers()
  {
    int number = passengers.size();
    return number;
  }

  public boolean hasPassengers()
  {
    boolean has = passengers.size() > 0;
    return has;
  }

  public int indexOfPassenger(Passenger aPassenger)
  {
    int index = passengers.indexOf(aPassenger);
    return index;
  }

  public static int minimumNumberOfTags()
  {
    return 0;
  }

  public boolean addTag(Tag aTag)
  {
    boolean wasAdded = false;
    if (tags.contains(aTag)) { return false; }
    tags.add(aTag);
    if (aTag.indexOfFlight(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTag.addFlight(this);
      if (!wasAdded)
      {
        tags.remove(aTag);
      }
    }
    return wasAdded;
  }

  public boolean removeTag(Tag aTag)
  {
    boolean wasRemoved = false;
    if (!tags.contains(aTag))
    {
      return wasRemoved;
    }

    int oldIndex = tags.indexOf(aTag);
    tags.remove(oldIndex);
    if (aTag.indexOfFlight(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTag.removeFlight(this);
      if (!wasRemoved)
      {
        tags.add(oldIndex,aTag);
      }
    }
    return wasRemoved;
  }

  public boolean addTagAt(Tag aTag, int index)
  {  
    boolean wasAdded = false;
    if(addTag(aTag))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTags()) { index = numberOfTags() - 1; }
      tags.remove(aTag);
      tags.add(index, aTag);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTagAt(Tag aTag, int index)
  {
    boolean wasAdded = false;
    if(tags.contains(aTag))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTags()) { index = numberOfTags() - 1; }
      tags.remove(aTag);
      tags.add(index, aTag);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTagAt(aTag, index);
    }
    return wasAdded;
  }

  public boolean setLTS(LTS aLTS)
  {
    boolean wasSet = false;
    if (aLTS == null)
    {
      return wasSet;
    }

    LTS existingLTS = lTS;
    lTS = aLTS;
    if (existingLTS != null && !existingLTS.equals(aLTS))
    {
      existingLTS.removeFlight(this);
    }
    lTS.addFlight(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfPassengers()
  {
    return 0;
  }

  public boolean addPassenger(Passenger aPassenger)
  {
    boolean wasAdded = false;
    if (passengers.contains(aPassenger)) { return false; }
    passengers.add(aPassenger);
    if (aPassenger.indexOfFlight(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPassenger.addFlight(this);
      if (!wasAdded)
      {
        passengers.remove(aPassenger);
      }
    }
    return wasAdded;
  }

  public boolean removePassenger(Passenger aPassenger)
  {
    boolean wasRemoved = false;
    if (!passengers.contains(aPassenger))
    {
      return wasRemoved;
    }

    int oldIndex = passengers.indexOf(aPassenger);
    passengers.remove(oldIndex);
    if (aPassenger.indexOfFlight(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPassenger.removeFlight(this);
      if (!wasRemoved)
      {
        passengers.add(oldIndex,aPassenger);
      }
    }
    return wasRemoved;
  }

  public boolean addPassengerAt(Passenger aPassenger, int index)
  {  
    boolean wasAdded = false;
    if(addPassenger(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePassengerAt(Passenger aPassenger, int index)
  {
    boolean wasAdded = false;
    if(passengers.contains(aPassenger))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPassengers()) { index = numberOfPassengers() - 1; }
      passengers.remove(aPassenger);
      passengers.add(index, aPassenger);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPassengerAt(aPassenger, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Tag> copyOfTags = new ArrayList<Tag>(tags);
    tags.clear();
    for(Tag aTag : copyOfTags)
    {
      aTag.removeFlight(this);
    }
    LTS placeholderLTS = lTS;
    this.lTS = null;
    if(placeholderLTS != null)
    {
      placeholderLTS.removeFlight(this);
    }
    ArrayList<Passenger> copyOfPassengers = new ArrayList<Passenger>(passengers);
    passengers.clear();
    for(Passenger aPassenger : copyOfPassengers)
    {
      aPassenger.removeFlight(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "source" + ":" + getSource()+ "," +
            "destination" + ":" + getDestination()+ "," +
            "airline" + ":" + getAirline()+ "," +
            "number" + ":" + getNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "flightdate" + "=" + (getFlightdate() != null ? !getFlightdate().equals(this)  ? getFlightdate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lTS = "+(getLTS()!=null?Integer.toHexString(System.identityHashCode(getLTS())):"null");
  }
}