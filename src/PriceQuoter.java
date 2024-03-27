/**
 * The PriceQuoter interface defines a contract for creating price quotes based on unit prices.
 * Implementing classes are expected to provide their own implementation of the createQuote method.
 *
 * @author Lucas Brand
 * @version 23rd March 2024
 */
public interface PriceQuoter
{
    /**
     * Creates a price quote based on the given unit price.
     *
     * @param unitPrice The unit price.
     * @return The price quote based on the given unit price, returned as a double.
     */
    public double createQuote(int unitPrice);
}
