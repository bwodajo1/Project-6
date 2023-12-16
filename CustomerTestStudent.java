import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTestStudent {

    @Test
    public void testConstructor() {
        // Test the constructor of the Customer class
        Customer customer = new Customer("John Doe", 25);
        assertEquals("John Doe", customer.getName());
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testToString() {
        // Test the toString method of the Customer class
        Customer customer = new Customer("Jane Smith", 30);
        assertEquals("Customer: Jane Smith (Age: 30)", customer.toString());
    }

}
