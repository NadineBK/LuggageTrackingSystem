/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.util.*;
import java.sql.Date;

// line 3 "../../../../../LTS.ump"
public class LTS
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static LTS theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LTS Associations
  private List<Passenger> passengers;
  private List<Flight> flights;
  private List<Transaction> transactions;
  private List<CreditCard> creditCards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private LTS()
  {
    passengers = new ArrayList<Passenger>();
    flights = new ArrayList<Flight>();
    transactions = new ArrayList<Transaction>();
    creditCards = new ArrayList<CreditCard>();
  }

  public static LTS getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new LTS();
    }
    return theInstance;
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

  public CreditCard getCreditCard(int index)
  {
    CreditCard aCreditCard = creditCards.get(index);
    return aCreditCard;
  }

  public List<CreditCard> getCreditCards()
  {
    List<CreditCard> newCreditCards = Collections.unmodifiableList(creditCards);
    return newCreditCards;
  }

  public int numberOfCreditCards()
  {
    int number = creditCards.size();
    return number;
  }

  public boolean hasCreditCards()
  {
    boolean has = creditCards.size() > 0;
    return has;
  }

  public int indexOfCreditCard(CreditCard aCreditCard)
  {
    int index = creditCards.indexOf(aCreditCard);
    return index;
  }

  public static int minimumNumberOfPassengers()
  {
    return 0;
  }

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

  public static int minimumNumberOfFlights()
  {
    return 0;
  }

  public Flight addFlight(String aSource, String aDestination, Date aFlightdate, String aAirline, String aNumber)
  {
    return new Flight(aSource, aDestination, aFlightdate, aAirline, aNumber, this);
  }

  public boolean addFlight(Flight aFlight)
  {
    boolean wasAdded = false;
    if (flights.contains(aFlight)) { return false; }
    LTS existingLTS = aFlight.getLTS();
    boolean isNewLTS = existingLTS != null && !this.equals(existingLTS);
    if (isNewLTS)
    {
      aFlight.setLTS(this);
    }
    else
    {
      flights.add(aFlight);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFlight(Flight aFlight)
  {
    boolean wasRemoved = false;
    //Unable to remove aFlight, as it must always have a lTS
    if (!this.equals(aFlight.getLTS()))
    {
      flights.remove(aFlight);
      wasRemoved = true;
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

  public Transaction addTransaction(float aAmount, boolean aPaid, Date aTransactiondate, Passenger aPassenger, CreditCard aCreditCard)
  {
    return new Transaction(aAmount, aPaid, aTransactiondate, this, aPassenger, aCreditCard);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    LTS existingLTS = aTransaction.getLTS();
    boolean isNewLTS = existingLTS != null && !this.equals(existingLTS);
    if (isNewLTS)
    {
      aTransaction.setLTS(this);
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
    //Unable to remove aTransaction, as it must always have a lTS
    if (!this.equals(aTransaction.getLTS()))
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

  public static int minimumNumberOfCreditCards()
  {
    return 0;
  }

  public CreditCard addCreditCard(int aCcnumber, Date aExpirydate, String aCcname, int aSecurityCode)
  {
    return new CreditCard(aCcnumber, aExpirydate, aCcname, aSecurityCode, this);
  }

  public boolean addCreditCard(CreditCard aCreditCard)
  {
    boolean wasAdded = false;
    if (creditCards.contains(aCreditCard)) { return false; }
    LTS existingLTS = aCreditCard.getLTS();
    boolean isNewLTS = existingLTS != null && !this.equals(existingLTS);
    if (isNewLTS)
    {
      aCreditCard.setLTS(this);
    }
    else
    {
      creditCards.add(aCreditCard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCreditCard(CreditCard aCreditCard)
  {
    boolean wasRemoved = false;
    //Unable to remove aCreditCard, as it must always have a lTS
    if (!this.equals(aCreditCard.getLTS()))
    {
      creditCards.remove(aCreditCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCreditCardAt(CreditCard aCreditCard, int index)
  {  
    boolean wasAdded = false;
    if(addCreditCard(aCreditCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCreditCards()) { index = numberOfCreditCards() - 1; }
      creditCards.remove(aCreditCard);
      creditCards.add(index, aCreditCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCreditCardAt(CreditCard aCreditCard, int index)
  {
    boolean wasAdded = false;
    if(creditCards.contains(aCreditCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCreditCards()) { index = numberOfCreditCards() - 1; }
      creditCards.remove(aCreditCard);
      creditCards.add(index, aCreditCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCreditCardAt(aCreditCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (passengers.size() > 0)
    {
      Passenger aPassenger = passengers.get(passengers.size() - 1);
      aPassenger.delete();
      passengers.remove(aPassenger);
    }
    
    while (flights.size() > 0)
    {
      Flight aFlight = flights.get(flights.size() - 1);
      aFlight.delete();
      flights.remove(aFlight);
    }
    
    while (transactions.size() > 0)
    {
      Transaction aTransaction = transactions.get(transactions.size() - 1);
      aTransaction.delete();
      transactions.remove(aTransaction);
    }
    
    while (creditCards.size() > 0)
    {
      CreditCard aCreditCard = creditCards.get(creditCards.size() - 1);
      aCreditCard.delete();
      creditCards.remove(aCreditCard);
    }
    
  }

}