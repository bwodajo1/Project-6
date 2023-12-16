/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Subclass of Beverage to process Alcohol orders
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
public class Alcohol extends Beverage {
    private boolean weekendOffer;
    private static final double WEEKEND_PRICE = 0.6;

    public Alcohol(String name, Size size, boolean weekendOffer) {
        super(name, Type.ALCOHOL, size);
        this.weekendOffer = weekendOffer;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + SIZE_PRICE * (size.ordinal() + 1);
        if (weekendOffer) price += WEEKEND_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - Weekend Offer: %s", weekendOffer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Alcohol alcohol = (Alcohol) obj;
        return weekendOffer == alcohol.weekendOffer;
    }

    // getters and setters
    public boolean isWeekendOffer() {
        return weekendOffer;
    }

    public void setWeekendOffer(boolean weekendOffer) {
        this.weekendOffer = weekendOffer;
    }
}
