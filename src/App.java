public class App {
    public static void main(String[] args) throws Exception {
        Parcel p1 = new Parcel("1 New Street", 2.0, 30, 35, 40);
        System.out.println(p1.toString());
        System.out.println(p1.getDateSent().length());

        	
        System.out.println(Parcel.getOrderedSides(20,50,30));
        System.out.println(Parcel.getOrderedSides(20,30,30));
        System.out.println(Parcel.getOrderedSides(30,30,30));

        Parcel p2 = new Parcel("1 New Street", 2.0, 30, 35, 40);
        System.out.println(p2.getLongestSide());
        Parcel p3 = new Parcel("1 New Street", 2.0, 40, 35, 30);
        System.out.println(p3.getLongestSide());
        Parcel p4 = new Parcel("1 New Street", 2.0, 35, 40, 30);
        System.out.println(p4.getLongestSide());

        Parcel p5 = new Parcel("1 New Street", 2.0, 35, 40, 30);
        System.out.println(p5.getParcelSize());
        
        Parcel p6 = new Parcel("1 New Street", 2.0, 20, 30, 121);
        System.out.println(p6.isWithinLimits());

        Parcel p7 = new Parcel("1 New Street", 5.0, 15, 50, 115);
        System.out.println(p7.isWithinLimits());

        Parcel p8 = new Parcel("1 New Street", 5.1, 15, 50, 116);
        System.out.println(p8.isWithinLimits());

        Parcel p16 = new Parcel("1 New Street", 4.3, 30, 35, 40);
        System.out.println(p16.createQuote(126));
    }
}
