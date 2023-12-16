import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice() {
        Alcohol alcohol = new Alcohol("Wine", Size.MEDIUM, true);

        // Assuming a base price for alcohol is $5.0
        double expectedPrice = 5.0;

        // If it's a weekend, an additional $2.0 is expected
        if (alcohol.isWeekendOffer()) {
            expectedPrice += 2.0;
        }

        double actualPrice = alcohol.calcPrice();

        assertEquals(expectedPrice, actualPrice, 0.01, "Calculation of alcohol price is incorrect");
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);

        String expectedString = "Beer - Size: SMALL, Weekend Offer: false";
        String actualString = alcohol.toString();

        assertEquals(expectedString, actualString, "String representation of alcohol is incorrect");
    }

    @Test
    public void testEquals() {
        Alcohol alcohol1 = new Alcohol("Vodka", Size.LARGE, true);
        Alcohol alcohol2 = new Alcohol("Vodka", Size.LARGE, true);
        Alcohol alcohol3 = new Alcohol("Whiskey", Size.MEDIUM, false);

        assertEquals(alcohol1, alcohol2, "Alcohol instances with the same properties should be equal");
        assertNotEquals(alcohol1, alcohol3, "Alcohol instances with different properties should not be equal");
    }
}
