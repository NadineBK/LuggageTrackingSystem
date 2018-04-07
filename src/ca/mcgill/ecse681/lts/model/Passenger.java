/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.util.*;
import java.sql.Date;

// line 33 "../../../../../LTS.ump"
public class Passenger
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Passenger Attributes
  private String passportID;
  private String lastName;
  private String firstName;
  private boolean expiredPassport;
  private float luggageWeightLimit;
  private boolean loungeAccess;
  private boolean overweightLuggagePrivilege;

  //Passenger Associations
  private List<Flight> flights;
  private List<Transaction> transactions;
  private LTS lTS;
  private List<Luggage> luggages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Passenger(String aPassportID, String aLastName, String aFirstName, boolean aExpiredPassport, float aLuggageWeightLimit, boolean aLoungeAccess, boolean aOverweightLuggagePrivilege, LTS aLTS)
  {
    // line 47 "../../../../../LTS.ump"
    if (aFirstName == null || aFirstName.length() == 0) {
    	    	throw new RuntimeException("The name of a passenger cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    // line 58 "../../../../../LTS.ump"
    if (aLastName == null || aLastName.length() == 0) {
    	    	throw new RuntimeException("The name of a passenger cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    passportID = aPassportID;
    lastName = aLastName;
    firstName = aFirstName;
    expiredPassport = aExpiredPassport;
    luggageWeightLimit = aLuggageWeightLimit;
    loungeAccess = aLoungeAccess;
    overweightLuggagePrivilege = aOverweightLuggagePrivilege;
    flights = new ArrayList<Flight>();
    transactions = new ArrayList<Transaction>();
    boolean didAddLTS = setLTS(aLTS);
    if (!didAddLTS)
    {
      throw new RuntimeException("Unable to create passenger due to lTS");
    }
    luggages = new ArrayList<Luggage>();
    if (aLuggageWeightLimit<=0)
    {
      throw new RuntimeException("Please provide a valid luggageWeightLimit");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPassportID(String aPassportID)
  {
    boolean wasSet = false;
    passportID = aPassportID;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    // line 63 "../../../../../LTS.ump"
    if (aLastName == null || aLastName.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    // line 52 "../../../../../LTS.ump"
    if (aFirstName == null || aFirstName.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpiredPassport(boolean aExpiredPassport)
  {
    boolean wasSet = false;
    expiredPassport = aExpiredPassport;
    wasSet = true;
    return wasSet;
  }

  public boolean setLuggageWeightLimit(float aLuggageWeightLimit)
  {
    boolean wasSet = false;
    if (aLuggageWeightLimit>0)
    {
    luggageWeightLimit = aLuggageWeightLimit;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setLoungeAccess(boolean aLoungeAccess)
  {
    boolean wasSet = false;
    loungeAccess = aLoungeAccess;
    wasSet = true;
    return wasSet;
  }

  public boolean setOverweightLuggagePrivilege(boolean aOverweightLuggagePrivilege)
  {
    boolean wasSet = false;
    overweightLuggagePrivilege = aOverweightLuggagePrivilege;
    wasSet = true;
    return wasSet;
  }

  public String getPassportID()
  {
    return passportID;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public boolean getExpiredPassport()
  {
    return expiredPassport;
  }

  public float getLuggageWeightLimit()
  {
    return luggageWeightLimit;
  }

  public boolean getLoungeAccess()
  {
    return loungeAccess;
  }

  public boolean getOverweightLuggagePrivilege()
  {
    return overweightLuggagePrivilege;
  }

  public boolean isExpiredPassport()
  {
    return expiredPassport;
  }

  public boolean isLoungeAccess()
  {
    return loungeAccess;
  }

  public boolean isOverweightLuggagePrivilege()
  {
    return overweightLuggagePrivilege;
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

  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }

  public LTS getLTS()
  {
    return lTS;
  }

  public Luggage getLuggage(int index)
  {
    Luggage aLuggage = luggages.get(index);
    return aLuggage;
  }

  public List<Luggage> getLuggages()
  {
    List<Luggage> newLuggages = Collections.unmodifiableList(luggages);
    return newLuggages;
  }

  public int numberOfLuggages()
  {
    int number = luggages.size();
    return number;
  }

  public boolean hasLuggages()
  {
    boolean has = luggages.size() > 0;
    return has;
  }

  public int indexOfLuggage(Luggage aLuggage)
  {
    int index = luggages.indexOf(aLuggage);
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
    if (aFlight.indexOfPassenger(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFlight.addPassenger(this);
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
    if (aFlight.indexOfPassenger(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFlight.removePassenger(this);
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

  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(float aAmount, boolean aPaid, Date aTransactiondate, LTS aLTS, CreditCard aCreditCard)
  {
    return new Transaction(aAmount, aPaid, aTransactiondate, aLTS, this, aCreditCard);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    Passenger existingPassenger = aTransaction.getPassenger();
    boolean isNewPassenger = existingPassenger != null && !this.equals(existingPassenger);
    if (isNewPassenger)
    {
      aTransaction.setPassenger(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a passenger
    if (!this.equals(aTransaction.getPassenger()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
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
      existingLTS.removePassenger(this);
    }
    lTS.addPassenger(this);
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfLuggages()
  {
    return 0;
  }

  public static int maximumNumberOfLuggages()
  {
    return 2;
  }

  public Luggage addLuggage(float aWeight, boolean aPriority, boolean aFragile, String aLocation, Tag aTag)
  {
    if (numberOfLuggages() >= maximumNumberOfLuggages())
    {
      return null;
    }
    else
    {
      return new Luggage(aWeight, aPriority, aFragile, aLocation, this, aTag);
    }
  }

  public boolean addLuggage(Luggage aLuggage)
  {
    boolean wasAdded = false;
    if (luggages.contains(aLuggage)) { return false; }
    if (numberOfLuggages() >= maximumNumberOfLuggages())
    {
      return wasAdded;
    }

    Passenger existingPassenger = aLuggage.getPassenger();
    boolean isNewPassenger = existingPassenger != null && !this.equals(existingPassenger);
    if (isNewPassenger)
    {
      aLuggage.setPassenger(this);
    }
    else
    {
      luggages.add(aLuggage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLuggage(Luggage aLuggage)
  {
    boolean wasRemoved = false;
    //Unable to remove aLuggage, as it must always have a passenger
    if (!this.equals(aLuggage.getPassenger()))
    {
      luggages.remove(aLuggage);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLuggageAt(Luggage aLuggage, int index)
  {  
    boolean wasAdded = false;
    if(addLuggage(aLuggage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLuggages()) { index = numberOfLuggages() - 1; }
      luggages.remove(aLuggage);
      luggages.add(index, aLuggage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLuggageAt(Luggage aLuggage, int index)
  {
    boolean wasAdded = false;
    if(luggages.contains(aLuggage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLuggages()) { index = numberOfLuggages() - 1; }
      luggages.remove(aLuggage);
      luggages.add(index, aLuggage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLuggageAt(aLuggage, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Flight> copyOfFlights = new ArrayList<Flight>(flights);
    flights.clear();
    for(Flight aFlight : copyOfFlights)
    {
      aFlight.removePassenger(this);
    }
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    LTS placeholderLTS = lTS;
    this.lTS = null;
    if(placeholderLTS != null)
    {
      placeholderLTS.removePassenger(this);
    }
    while (luggages.size() > 0)
    {
      Luggage aLuggage = luggages.get(luggages.size() - 1);
      aLuggage.delete();
      luggages.remove(aLuggage);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "passportID" + ":" + getPassportID()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "expiredPassport" + ":" + getExpiredPassport()+ "," +
            "luggageWeightLimit" + ":" + getLuggageWeightLimit()+ "," +
            "loungeAccess" + ":" + getLoungeAccess()+ "," +
            "overweightLuggagePrivilege" + ":" + getOverweightLuggagePrivilege()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "lTS = "+(getLTS()!=null?Integer.toHexString(System.identityHashCode(getLTS())):"null");
  }
}