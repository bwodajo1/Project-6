import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice() {
        // Create a Coffee object for testing
        Coffee coffee = new Coffee("TestCoffee", Size.MEDIUM, true, false);

        // Test the calcPrice method
        assertEquals(2.5, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        // Create a Coffee object for testing
        Coffee coffee = new Coffee("TestCoffee", Size.LARGE, false, true);

        // Test the toString method
        assertEquals("TestCoffee - Type: COFFEE, Size: LARGE - Extra Shot: false, Extra Syrup: true", coffee.toString());
    }

}
