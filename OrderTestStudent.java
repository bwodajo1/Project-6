import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {

    @Test
    public void testConstructor() {
        // Test the constructor of the Order class
        Customer customer = new Customer("John Doe", 25);
        Order order = new Order(customer, 10, Day.MONDAY);

        assertNotNull(order.getBeverages());
        assertEquals(customer, order.getCustomer());
        assertEquals(10, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
    }

    @Test
    public void testAddNewBeverage() {
        // Test the addNewBeverage method of the Order class
        Customer customer = new Customer("Jane Smith", 30);
        Order order = new Order(customer, 15, Day.WEDNESDAY);

        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        order.addNewBeverage(coffee);

        assertEquals(1, order.getBeverages().size());
        assertEquals(coffee, order.getBeverages().get(0));
    }

    @Test
    public void testCalcOrderTotal() {
        // Test the calcOrderTotal method of the Order class
        Customer customer = new Customer("Alice Johnson", 22);
        Order order = new Order(customer, 18, Day.FRIDAY);

        Coffee coffee = new Coffee("Latte", Size.MEDIUM, false, true);
        Smoothie smoothie = new Smoothie("Berry Burst", Size.LARGE, 2, true);

        order.addNewBeverage(coffee);
        order.addNewBeverage(smoothie);

        double expectedTotal = coffee.calcPrice() + smoothie.calcPrice();
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.01);
    }

}
