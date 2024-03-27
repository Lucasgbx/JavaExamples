/**
 * Represents a removal service as a type of freight, detailing the volume of items to be moved 
 * and their destination address. It includes functionality to calculate quotes based on the 
 * volume of goods being removed.
 *
 * @author Lucas Brand
 * @version 23rd March 2024
 */
public class Removal extends Freight
{
    private int volume; //the volume of freight required to be transported

    /**
     * Constructor for objects of class Removals
     * 
     * @param anAddress the address the removal is to
     * @param aVolume the volume of the goods to be removed
     */
    public Removal(String anAddress, int aVolume)
    {
        super(anAddress);
        volume = aVolume;
    }

    /**
     * Calculates the price in pounds from the volume of the removal and the cost provided 
     * as an argumnet in pence per metres cubed.
     * 
     * @param pencePerKilo the cost in pence per kilo.
     * 
     * @return the price in pounds as a double.
     */
    @Override
    public double createQuote(int pencePerMetresCubed)
    {
        double price = (volume * pencePerMetresCubed);
        return Math.round(price) / 100.0;
    }

}
