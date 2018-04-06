/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.27.0.3728.d139ed893 modeling language!*/

package ca.mcgill.ecse681.lts.model;
import java.sql.Date;
import java.util.*;

// line 114 "../../../../../LTS.ump"
public class CreditCard
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CreditCard Attributes
  private int ccnumber;
  private Date expirydate;
  private String ccname;
  private int securityCode;

  //CreditCard Associations
  private List<Transaction> transactions;
  private LTS lTS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CreditCard(int aCcnumber, Date aExpirydate, String aCcname, int aSecurityCode, LTS aLTS)
  {
    // line 121 "../../../../../LTS.ump"
    if (!aExpirydate.after(new Date((Calendar.getInstance().getTime()).getTime()))) {
    			throw new RuntimeException("The expiry date of a credit card cannot be in the past or the present day.");
    		}
    // END OF UMPLE BEFORE INJECTION
    // line 134 "../../../../../LTS.ump"
    if (aCcname == null || aCcname.length() == 0) {
    	    	throw new RuntimeException("The name on the credit card cannot be empty.");
    	    }
    // END OF UMPLE BEFORE INJECTION
    ccnumber = aCcnumber;
    expirydate = aExpirydate;
    ccname = aCcname;
    securityCode = aSecurityCode;
    transactions = new ArrayList<Transaction>();
    boolean didAddLTS = setLTS(aLTS);
    if (!didAddLTS)
    {
      throw new RuntimeException("Unable to create creditCard due to lTS");
    }
    if (aSecurityCode<=0)
    {
      throw new RuntimeException("Please provide a valid ccnumber and securityCode");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCcnumber(int aCcnumber)
  {
    boolean wasSet = false;
    if (aCcnumber>0)
    {
    ccnumber = aCcnumber;
    wasSet = true;
    }
    return wasSet;
  }

  public boolean setExpirydate(Date aExpirydate)
  {
    boolean wasSet = false;
    // line 126 "../../../../../LTS.ump"
    if (!aExpirydate.after(new Date((Calendar.getInstance().getTime()).getTime()))) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    expirydate = aExpirydate;
    wasSet = true;
    return wasSet;
  }

  public boolean setCcname(String aCcname)
  {
    boolean wasSet = false;
    // line 139 "../../../../../LTS.ump"
    if (aCcname == null || aCcname.length() == 0) {
    			return false;
    		}
    // END OF UMPLE BEFORE INJECTION
    ccname = aCcname;
    wasSet = true;
    return wasSet;
  }

  public boolean setSecurityCode(int aSecurityCode)
  {
    boolean wasSet = false;
    if (aSecurityCode>0)
    {
    securityCode = aSecurityCode;
    wasSet = true;
    }
    return wasSet;
  }

  public int getCcnumber()
  {
    return ccnumber;
  }

  public Date getExpirydate()
  {
    return expirydate;
  }

  public String getCcname()
  {
    return ccname;
  }

  public int getSecurityCode()
  {
    return securityCode;
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

  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(float aAmount, boolean aPaid, Date aTransactiondate, LTS aLTS, Passenger aPassenger)
  {
    return new Transaction(aAmount, aPaid, aTransactiondate, aLTS, aPassenger, this);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    CreditCard existingCreditCard = aTransaction.getCreditCard();
    boolean isNewCreditCard = existingCreditCard != null && !this.equals(existingCreditCard);
    if (isNewCreditCard)
    {
      aTransaction.setCreditCard(this);
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
    //Unable to remove aTransaction, as it must always have a creditCard
    if (!this.equals(aTransaction.getCreditCard()))
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
      existingLTS.removeCreditCard(this);
    }
    lTS.addCreditCard(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    LTS placeholderLTS = lTS;
    this.lTS = null;
    if(placeholderLTS != null)
    {
      placeholderLTS.removeCreditCard(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "ccnumber" + ":" + getCcnumber()+ "," +
            "ccname" + ":" + getCcname()+ "," +
            "securityCode" + ":" + getSecurityCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "expirydate" + "=" + (getExpirydate() != null ? !getExpirydate().equals(this)  ? getExpirydate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "lTS = "+(getLTS()!=null?Integer.toHexString(System.identityHashCode(getLTS())):"null");
  }
}