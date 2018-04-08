/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.sql.Date;

// line 147 "../../../../../LTS.ump"
public class Transaction
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextTransactionID = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private float amount;
  private boolean paid;
  private Date transactiondate;

  //Autounique Attributes
  private int transactionID;

  //Transaction Associations
  private LTS lTS;
  private Passenger passenger;
  private CreditCard creditCard;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(float aAmount, boolean aPaid, Date aTransactiondate, LTS aLTS, Passenger aPassenger, CreditCard aCreditCard)
  {
    amount = aAmount;
    paid = aPaid;
    transactiondate = aTransactiondate;
    transactionID = nextTransactionID++;
    boolean didAddLTS = setLTS(aLTS);
    if (!didAddLTS)
    {
      throw new RuntimeException("Unable to create transaction due to lTS");
    }
    boolean didAddPassenger = setPassenger(aPassenger);
    if (!didAddPassenger)
    {
      throw new RuntimeException("Unable to create transaction due to passenger");
    }
    boolean didAddCreditCard = setCreditCard(aCreditCard);
    if (!didAddCreditCard)
    {
      throw new RuntimeException("Unable to create transaction due to creditCard");
    }
    if (aAmount<=0)
    {
      throw new RuntimeException("Please provide a valid amount");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAmount(float aAmount)
  {
    boolean wasSet = false;
    if (aAmount>0)
    {
    amount = aAmount;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setPaid(boolean aPaid)
  {
    boolean wasSet = false;
    paid = aPaid;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransactiondate(Date aTransactiondate)
  {
    boolean wasSet = false;
    transactiondate = aTransactiondate;
    wasSet = true;
    return wasSet;
  }

  public float getAmount()
  {
    return amount;
  }

  public boolean getPaid()
  {
    return paid;
  }

  public Date getTransactiondate()
  {
    return transactiondate;
  }

  public int getTransactionID()
  {
    return transactionID;
  }

  public boolean isPaid()
  {
    return paid;
  }

  public LTS getLTS()
  {
    return lTS;
  }

  public Passenger getPassenger()
  {
    return passenger;
  }

  public CreditCard getCreditCard()
  {
    return creditCard;
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
      existingLTS.removeTransaction(this);
    }
    lTS.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setPassenger(Passenger aPassenger)
  {
    boolean wasSet = false;
    if (aPassenger == null)
    {
      return wasSet;
    }

    Passenger existingPassenger = passenger;
    passenger = aPassenger;
    if (existingPassenger != null && !existingPassenger.equals(aPassenger))
    {
      existingPassenger.removeTransaction(this);
    }
    passenger.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCard(CreditCard aCreditCard)
  {
    boolean wasSet = false;
    if (aCreditCard == null)
    {
      return wasSet;
    }

    CreditCard existingCreditCard = creditCard;
    creditCard = aCreditCard;
    if (existingCreditCard != null && !existingCreditCard.equals(aCreditCard))
    {
      existingCreditCard.removeTransaction(this);
    }
    creditCard.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    LTS placeholderLTS = lTS;
    this.lTS = null;
    if(placeholderLTS != null)
    {
      placeholderLTS.removeTransaction(this);
    }
    Passenger placeholderPassenger = passenger;
    this.passenger = null;
    if(placeholderPassenger != null)
    {
      placeholderPassenger.removeTransaction(this);
    }
    CreditCard placeholderCreditCard = creditCard;
    this.creditCard = null;
    if(placeholderCreditCard != null)
    {
      placeholderCreditCard.removeTransaction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "transactionID" + ":" + getTransactionID()+ "," +
            "amount" + ":" + getAmount()+ "," +
            "paid" + ":" + getPaid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transactiondate" + "=" + (getTransactiondate() != null ? !getTransactiondate().equals(this)  ? getTransactiondate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lTS = "+(getLTS()!=null?Integer.toHexString(System.identityHashCode(getLTS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "passenger = "+(getPassenger()!=null?Integer.toHexString(System.identityHashCode(getPassenger())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "creditCard = "+(getCreditCard()!=null?Integer.toHexString(System.identityHashCode(getCreditCard())):"null");
  }
}