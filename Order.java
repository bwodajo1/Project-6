/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Order class implemented from an interface to process orders
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface, Comparable<Order> {
    private static final int MAX_ALCOHOL_DRINKS = 3;

    private int orderNumber;
    private String orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    public Order(Customer customer, int orderTime, Day orderDay) {
        this.orderNumber = getOrderNumber();
        this.orderTime = getCurrentTime(); // Implement getCurrentTime() method
        this.orderDay = getCurrentDay(); // Implement getCurrentDay() method
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    public int getOrderNumber() {
        return (int) (Math.random() * 80000) + 10000;
    }

    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append(String.format("Order #%d - %s %s%n", orderNumber, orderTime, orderDay));
        orderDetails.append(String.format("Customer: %s%n", customer));
        orderDetails.append("Beverages:\n");
        for (Beverage beverage : beverages) {
            orderDetails.append(String.format("- %s%n", beverage));
        }
        orderDetails.append(String.format("Total Price: $%.2f%n", calcOrderTotal()));
        return orderDetails.toString();
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderNumber, o.orderNumber);
    }

    // Additional methods
    private String getCurrentTime() {
        // Implement logic to get current time
        return "8:00 AM";
    }

    private Day getCurrentDay() {
        // Implement logic to get current day
        return Day.MONDAY;
    }

    // Implement the following methods based on your requirements
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage beverage = new Coffee(bevName, size, extraShot, extraSyrup);
        addNewBeverage(beverage);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        Beverage beverage = new Alcohol(bevName, size, /* weekendOffer parameter */ false);
        addNewBeverage(beverage);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Beverage beverage = new Smoothie(bevName, size, numOfFruits, addProtein);
        addNewBeverage(beverage);
    }

}
