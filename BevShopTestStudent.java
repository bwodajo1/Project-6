import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BevShopTestStudent {

    @Test
    public void testIsValidTime() {
        BevShop bevShop = new BevShop();

        // Test when time is within the valid range
        assertTrue(bevShop.isValidTime(12));

        // Test when time is below the valid range
        assertFalse(bevShop.isValidTime(6));

        // Test when time is above the valid range
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        BevShop bevShop = new BevShop();

        // Test the getMaxNumOfFruits method
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        BevShop bevShop = new BevShop();

        // Test the getMinAgeForAlcohol method
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        BevShop bevShop = new BevShop();

        // Test when the number of fruits is within the limit
        assertFalse(bevShop.isMaxFruit(3));

        // Test when the number of fruits exceeds the limit
        assertTrue(bevShop.isMaxFruit(6));
    }
}
