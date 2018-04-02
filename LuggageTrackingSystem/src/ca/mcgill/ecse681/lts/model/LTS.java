/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.util.*;

// line 3 "../../../../../LTS.ump"
public class LTS
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LTS Associations
  private List<Passenger> passengers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LTS()
  {
    passengers = new ArrayList<Passenger>();
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public static int minimumNumberOfPassengers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Passenger addPassenger(String aPassportID, String aLastName, String aFirstName, boolean aExpiredPassport, float aLuggageWeightLimit, boolean aLoungeAccess, boolean aOverweightLuggagePrivilege)
  {
    return new Passenger(aPassportID, aLastName, aFirstName, aExpiredPassport, aLuggageWeightLimit, aLoungeAccess, aOverweightLuggagePrivilege, this);
  }

  public boolean addPassenger(Passenger aPassenger)
  {
    boolean wasAdded = false;
    if (passengers.contains(aPassenger)) { return false; }
    LTS existingLTS = aPassenger.getLTS();
    boolean isNewLTS = existingLTS != null && !this.equals(existingLTS);
    if (isNewLTS)
    {
      aPassenger.setLTS(this);
    }
    else
    {
      passengers.add(aPassenger);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePassenger(Passenger aPassenger)
  {
    boolean wasRemoved = false;
    //Unable to remove aPassenger, as it must always have a lTS
    if (!this.equals(aPassenger.getLTS()))
    {
      passengers.remove(aPassenger);
      wasRemoved = true;
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
    for(int i=passengers.size(); i > 0; i--)
    {
      Passenger aPassenger = passengers.get(i - 1);
      aPassenger.delete();
    }
  }

}