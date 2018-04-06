/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.util.*;

// line 159 "../../../../../LTS.ump"
public class Tag
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextLuggageID = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int luggageID;

  //Tag Associations
  private Luggage luggage;
  private List<Flight> flights;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tag(Luggage aLuggage)
  {
    luggageID = nextLuggageID++;
    if (aLuggage == null || aLuggage.getTag() != null)
    {
      throw new RuntimeException("Unable to create Tag due to aLuggage");
    }
    luggage = aLuggage;
    flights = new ArrayList<Flight>();
  }

  public Tag(float aWeightForLuggage, boolean aPriorityForLuggage, boolean aFragileForLuggage, Passenger aPassengerForLuggage)
  {
    luggageID = nextLuggageID++;
    luggage = new Luggage(aWeightForLuggage, aPriorityForLuggage, aFragileForLuggage, aPassengerForLuggage, this);
    flights = new ArrayList<Flight>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getLuggageID()
  {
    return luggageID;
  }

  public Luggage getLuggage()
  {
    return luggage;
  }

  public Flight getFlight(int index)
  {
    Flight aFlight = flights.get(index);
    return aFlight;
  }

  public List<Flight> getFlights()
  {
    List<Flight> newFlights = Collections.unmodifiableList(flights);
    return newFlights;
  }

  public int numberOfFlights()
  {
    int number = flights.size();
    return number;
  }

  public boolean hasFlights()
  {
    boolean has = flights.size() > 0;
    return has;
  }

  public int indexOfFlight(Flight aFlight)
  {
    int index = flights.indexOf(aFlight);
    return index;
  }

  public static int minimumNumberOfFlights()
  {
    return 0;
  }

  public boolean addFlight(Flight aFlight)
  {
    boolean wasAdded = false;
    if (flights.contains(aFlight)) { return false; }
    flights.add(aFlight);
    if (aFlight.indexOfTag(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFlight.addTag(this);
      if (!wasAdded)
      {
        flights.remove(aFlight);
      }
    }
    return wasAdded;
  }

  public boolean removeFlight(Flight aFlight)
  {
    boolean wasRemoved = false;
    if (!flights.contains(aFlight))
    {
      return wasRemoved;
    }

    int oldIndex = flights.indexOf(aFlight);
    flights.remove(oldIndex);
    if (aFlight.indexOfTag(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFlight.removeTag(this);
      if (!wasRemoved)
      {
        flights.add(oldIndex,aFlight);
      }
    }
    return wasRemoved;
  }

  public boolean addFlightAt(Flight aFlight, int index)
  {  
    boolean wasAdded = false;
    if(addFlight(aFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFlights()) { index = numberOfFlights() - 1; }
      flights.remove(aFlight);
      flights.add(index, aFlight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFlightAt(Flight aFlight, int index)
  {
    boolean wasAdded = false;
    if(flights.contains(aFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFlights()) { index = numberOfFlights() - 1; }
      flights.remove(aFlight);
      flights.add(index, aFlight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFlightAt(aFlight, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Luggage existingLuggage = luggage;
    luggage = null;
    if (existingLuggage != null)
    {
      existingLuggage.delete();
    }
    ArrayList<Flight> copyOfFlights = new ArrayList<Flight>(flights);
    flights.clear();
    for(Flight aFlight : copyOfFlights)
    {
      aFlight.removeTag(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "luggageID" + ":" + getLuggageID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "luggage = "+(getLuggage()!=null?Integer.toHexString(System.identityHashCode(getLuggage())):"null");
  }
}