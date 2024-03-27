import java.util.HashSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;

/**
 * Extends the Parcel class to include tracking capabilities. This class adds a tracking number,
 * parcel value, and contents tracking, along with a tracking fee. It supports setting and 
 * retrieving tracking details, adding items to the parcel, and calculating the price quote 
 * including the tracking fee.
 * 
 * @author Lucas Brand
 * @version 23rd march 2024
 */
public class TrackedParcel extends Parcel
{
    private String trackingNumber; // The tracking number of the parcel.
    private int value; // The value of the parcel in pence.
    private HashSet<String> contents; // The contents of the parcel.
    /** The price in pounds sterling of the tracking fee. */
    public static final double TRACKING_FEE = 2.0;

    /**
     * Constructs a new TrackedParcel instance with specified parameters, initializing its contents set and tracking number.
     * 
     * @param address The delivery address for the parcel.
     * @param weight  The weight of the parcel in kilos.
     * @param width   The width of the parcel in centimeters.
     * @param length  The length of the parcel in centimeters.
     * @param height  The height of the parcel in centimeters.
     * @param value   The value of the parcel in pence.
     */
    public TrackedParcel(String address, double weight, int width, int length, int height, int value)
    {
        super(address, weight, width, length, height);
        this.value = value;
        contents = new HashSet<String>();
        trackingNumber = "";
    }

    /**
     * @return the tracking number of the parcel
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    /**
     * @param anItem Adds anItem to the contents set for the parcel
     */
    public void addItem(String anItem)
    {
        contents.add(anItem);
    }

    /**
     * Assigns a tracking number to the parcel and sets the date sent to the current date.
     * The date is formatted according to the "dd MMM yyyy" pattern.
     *
     * @param trackingNumber The tracking number to be set for the parcel.
     */
    public void setDateAndTracking(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formattedDate = now.format(formatter);

        setDateSent(formattedDate);
    }

    /**
     * @return a string representation of the TrackedParcel.
     */
    @Override
    public String toString()
    {
        StringBuilder returnString = new StringBuilder(super.toString());

        if (!contents.isEmpty()) {
            List<String> tempContents = new ArrayList<>(contents);
            Collections.sort(tempContents);
            String sortedContentsString = String.join(" ", tempContents);
            returnString.append("\nContents: ").append(sortedContentsString);
        }

        double valueInPounds = value / 100.0;
        returnString.append("\nValue: £").append(String.format("%.2f", valueInPounds));

        String dateSent = getDateSent();

        if (!dateSent.isEmpty()) {
            returnString.append("\nDate Sent: ").append(dateSent);
        }

        if (!trackingNumber.isEmpty()) {
            returnString.append("\nTracking Number: ").append(trackingNumber);
        }

        return returnString.toString();
    } 

    /**
     * Equals method for this object.
     * 
     * @return true if objects compared are same class or subclass and
     * have the same address and dateSent
     */
    @Override
    public boolean equals(Object o)
    {
        if(o != null && o instanceof TrackedParcel)
        {
            TrackedParcel p = (TrackedParcel) o;
            return getAddress().equals(p.getAddress()) && getDateSent().equals(p.getDateSent()) && trackingNumber.equals(p.getTrackingNumber());
        }
        return false;
    }

    /**
     * Calculates the hash code for this TrackedParcel instance.
     * Derived from the address, date sent, and tracking number.
     *
     * @return an int, the hash code for this TrackedParcel instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getDateSent(), trackingNumber);
    }

    /**
     * Calculates the price in pounds from the weight of the parcel and the cost provided 
     * as an argumnet in pence per kilo, also adding the tracking fee.
     * 
     * @param pencePerKilo the cost in pence per kilo.
     * 
     * @return the price in pounds as a double.
     */
    @Override
    public double createQuote(int pencePerKilo)
    {
        return super.createQuote(pencePerKilo) + TRACKING_FEE;
    }
}
