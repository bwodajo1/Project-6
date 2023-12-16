import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTestStudent {

    @Test
    public void testConstructor() {
        // Test the constructor of the Smoothie class
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        assertEquals("Berry Blast", smoothie.getName());
        assertEquals(Size.MEDIUM, smoothie.getSize());
        assertEquals(3, smoothie.getNumFruits());
    }

    @Test
    public void testCalcPrice() {
        // Test the calcPrice method of the Smoothie class
        Smoothie smoothie = new Smoothie("Tropical Delight", Size.LARGE, 2, false);
        double expectedPrice = Smoothie.BASE_PRICE + Smoothie.SIZE_PRICE * (Size.LARGE.ordinal() + 1)
                + 2 * Smoothie.FRUIT_PRICE;
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        // Test the toString method of the Smoothie class
        Smoothie smoothie = new Smoothie("Green Goodness", Size.SMALL, 1, true);
        assertEquals("Green Goodness - Size: SMALL, Fruits: 1, Protein Powder: true", smoothie.toString());
    }
}
