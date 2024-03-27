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

        TrackedParcel p9 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        System.out.println(p9.toString());
        System.out.println("date sent: " + p9.getDateSent());
        p9.addItem("Clock");
        p9.addItem("Picture");
        System.out.println(p9.toString());

        TrackedParcel p10 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        p10.setDateAndTracking("0123456");
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> monthList = Arrays.asList(months);
        String theYear = p10.getDateSent().substring(3, 6);
        System.out.println(monthList.contains(theYear));
        int theDay = Integer.parseInt(p10.getDateSent().substring(0,2));
        System.out.println(0 < theDay && theDay < 32);
        System.out.println(p10.getTrackingNumber().equals("0123456"));
        System.out.println(p10.getDateSent().charAt(2) == ' ' && p10.getDateSent().charAt(6) == ' ');

        TrackedParcel p11 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        p11.setDateAndTracking("0123456");
        p11.setDateSent("01 Mar 2024");
        System.out.println(p11.toString());
        p11.addItem("Lion");
        p11.addItem("Elephant");
        System.out.println(p11.toString());

        TrackedParcel p12 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        p12.setDateAndTracking("0123456");
        p12.setDateSent("01 Mar 2024");
        TrackedParcel p13 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);

        p13.setDateAndTracking("0123456");
        p13.setDateSent("01 Mar 2024");
        System.out.println(p12.equals(p13));
        p13.setDateSent("");
        System.out.println(p12.equals(p13));
        p12.setDateAndTracking("0123458");
        p12.setDateSent("");
        System.out.println(p12.equals(p13));

        Parcel p14 = new Parcel("1 New Street", 2.0, 30, 35, 40);
        System.out.println(p13.equals(p14));

        TrackedParcel p15 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        p15.setDateAndTracking("0123456");
        p15.setDateSent("01May2024");
        System.out.println(p15.hashCode());

        TrackedParcel p17 = new TrackedParcel("1 New Street", 2.0, 30, 35, 40, 250);
        System.out.println(p17.createQuote(126));
    }
}
