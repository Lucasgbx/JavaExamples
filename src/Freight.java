/**
 * The Freight class provides a template for handling freight information, including the address to send the freight
 * and the date it was sent. This abstract class requires implementing classes to provide their own implementation of
 * createQuote from the PriceQuoter interface.
 * 
 * @author Lucas Brand
 * @version 23rd March 2024
 */
public abstract class Freight implements PriceQuoter
{
    private String address; //the address to send the freight to
    private String dateSent; //the date the freight was sent

    /**
     * @param anAddress the address the freight is to be sent to
     */
    public Freight(String anAddress)
    {
        address = anAddress;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @return the dateSent
     */
    public String getDateSent()
    {
        return dateSent;
    }

    /**
     * @param aPostDate the dateSent to set
     */
    public void setDateSent(String aPostDate)
    {
        dateSent = aPostDate;
    }
}
