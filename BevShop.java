/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: BevShop Class implemented from an interface to process details about the shop
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
import java.util.ArrayList;
import java.util.Collections;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private int numOfAlcoholDrinks;

    public BevShop() {
        this.orders = new ArrayList<>();
        this.numOfAlcoholDrinks = 0;
    }

    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(customer, time, day);
        orders.add(newOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        getCurrentOrder().addNewBeverage(coffee);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (getNumOfAlcoholDrink() < getMaxOrderForAlcohol()) {
            Alcohol alcohol = new Alcohol(bevName, size, isWeekendOffer());
            getCurrentOrder().addNewBeverage(alcohol);
            numOfAlcoholDrinks++; // Increment the count
        } else {
            System.out.println("Maximum number of alcohol beverages per order reached.");
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (!isMaxFruit(numOfFruits)) {
            Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
            getCurrentOrder().addNewBeverage(smoothie);
        } else {
            System.out.println("Number of fruits exceeds the maximum allowed for a smoothie.");
        }
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }
    private Day getCurrentDay() {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        switch (dayOfWeek) {
            case MONDAY:
                return Day.MONDAY;
            case TUESDAY:
                return Day.TUESDAY;
            case WEDNESDAY:
                return Day.WEDNESDAY;
            case THURSDAY:
                return Day.THURSDAY;
            case FRIDAY:
                return Day.FRIDAY;
            case SATURDAY:
                return Day.SATURDAY;
            case SUNDAY:
                return Day.SUNDAY;
            default:
                return null;
        }
    }

    private boolean isWeekendOffer() {
        Day currentDay = getCurrentDay();
        return currentDay == Day.SATURDAY || currentDay == Day.SUNDAY;
    }
    public void processOrder(Order order) {
        if (order != null) {
            orders.add(order);
            System.out.println("Order processed successfully!");
        } else {
            System.out.println("No order to process.");
        }
    }

}
