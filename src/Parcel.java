import java.util.ArrayList;
import java.util.Collections;
/**
 * Represents a parcel, extending the Freight class. 
 * Includes details such as weight, dimensions (width, length, height), and methods to 
 * assess parcel size, limits, and calculate quotes based on weight.
 * 
 * @author Lucas Brand
 * @version 23rd March 2024
 */
public class Parcel extends Freight
{    
    private double weight;  //The parcels weight in kilos  
    private int width; // the parcel's  width in cms    
    private int length; //the parcel's length in cms
    private int height; //The parcel's height in cms 
    /** the maximum permissible length of the parcel in cms */
    public static final int LENGTH_LIMIT = 120;
    /** the maximum permissible size of the parcel in cms */
    public static final int SIZE_LIMIT = 245;
    /** the maximum permissible size of the parcel in kilos */
    public static final int WEIGHT_LIMIT = 5;

    /**
     * Constructs a Parcel instance with specified address, weight, and dimensions. 
     * Initializes the parcel's properties and sets the date sent to an empty string.
     * 
     * @param address The delivery address for the parcel.
     * @param weight The weight of the parcel in kilograms.
     * @param width The width of the parcel in centimeters.
     * @param length The length of the parcel in centimeters.
     * @param height The height of the parcel in centimeters.
     */
    public Parcel(String address, double weight, int width, int length, int height)
    {   
        super(address);
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        setDateSent("");
    }

    /**
     * @return the weight as a double.
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Equals method for this object.
     * 
     * @return true if objects compared are same class or subclass and
     * have the same address and dateSent
     */
    public boolean equals(Object o)
    {
        if(o != null && o instanceof Parcel)
        {
            Parcel p = (Parcel) o;
            return getAddress().equals(p.getAddress()) && getDateSent().equals(p.getDateSent());
        }
        return false;
    }

    /**
     * @return a string representation of the parcel
     */
    public String toString()
    {
        String returnString = "A parcel for " + getAddress()  + "\nWeight " + weight + 
            "Kg, Width " + width + "cms,  Height " + height + "cms,  Length "  + length + "cms.";

        return returnString;
    } 

    /**
     * Returns the dimensions of a parcel (width, length, height) sorted in ascending order.
     * 
     * @param width  the width of the parcel
     * @param length the length of the parcel
     * @param height the height of the parcel
     * @return a sorted ArrayList<Integer> of the parcel's dimensions in ascending order..
     */
    public static ArrayList<Integer> getOrderedSides(int width, int length, int height)
    {
        ArrayList<Integer> sides = new ArrayList<>();

        sides.add(width);
        sides.add(length);
        sides.add(height);

        Collections.sort(sides);

        return sides;
    }

    /**
     * Retrieves the longest side of the parcel.
     * 
     * @return an integer for the longest side of the parcel in centimeters.
     */
    public int getLongestSide()
    {
        return getOrderedSides(width, length, height).get(2);
    }

    /**
     * Calculates the size of the parcel using the formula: 
     * (shortest side + next shortest side) x 2 + longest side.
     * 
     * @return an integer, the calculated size of the parcel.
     */
    public int getParcelSize()
    {
        ArrayList<Integer> sides = getOrderedSides(width, length, height);
        return ((sides.get(0) + sides.get(1)) * 2) + sides.get(2);
    }

    /**
     * Determines if the parcel meets predefined size and weight limits.
     * 
     * @return true if the longest side is within LENGTH_LIMIT, the overall parcel size is within SIZE_LIMIT,
     *         and the parcel's weight does not exceed WEIGHT_LIMIT; false otherwise.
     */
    public boolean isWithinLimits()
    {        
        return getLongestSide() <= LENGTH_LIMIT && getParcelSize() <= SIZE_LIMIT && weight <= WEIGHT_LIMIT;
    }   

    /**
     * Calculates the price in pounds from the weight of the parcel and the cost provided 
     * as an argumnet in pence per kilo.
     * 
     * @param pencePerKilo the cost in pence per kilo.
     * 
     * @return the price in pounds as a double.
     */
    @Override
    public double createQuote(int pencePerKilo)
    {
        double price = (weight * pencePerKilo);
        return Math.round(price) / 100.0;
    }

}
