/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Driver for the BevShop class that interacts with the user and accepts orders 
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        while (true) {
            System.out.println("Start a new order:");
            System.out.println("Your Total Order for now is 0.0");

            System.out.print("Would you please enter your name: ");
            String customerName = scanner.nextLine();

            System.out.print("Would you please enter your age: ");
            int customerAge = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (bevShop.isValidAge(customerAge)) {
                System.out.println("Your age is above 20, and you are eligible to order alcohol.");

                bevShop.startNewOrder(8, Day.MONDAY, customerName, customerAge);

                while (true) {
                    System.out.println("Would you please add a beverage to your order (Coffee, Alcohol, Smoothie): ");
                    System.out.print("Enter the type of beverage (or 'done' to finish the order): ");
                    String beverageType = scanner.nextLine();

                    if (beverageType.equalsIgnoreCase("done")) {
                        break;
                    }

                    processBeverage(scanner, bevShop, beverageType);
                }

                Order currentOrder = bevShop.getCurrentOrder();
                System.out.println("Your current order:\n" + currentOrder);
                System.out.println("Total amount for the current order: " + currentOrder.calcOrderTotal());

                bevShop.processOrder(currentOrder);
            } else {
                System.out.println("Your age is not appropriate for an alcohol drink!!");
            }

            System.out.println("Would you like to start a new order? (yes/no)");
            String response = scanner.nextLine().toLowerCase();

            if (!response.equals("yes")) {
                break;
            }
        }

        System.out.println("Total amount for all orders: " + bevShop.totalMonthlySale());
    }

    private static void processBeverage(Scanner scanner, BevShop bevShop, String beverageType) {
        System.out.print("Enter the size of the beverage (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(scanner.nextLine().toUpperCase());

        switch (beverageType.toUpperCase()) {
            case "COFFEE":
                System.out.print("Does the coffee have an extra shot? (true/false): ");
                boolean extraShot = scanner.nextBoolean();

                System.out.print("Does the coffee have extra syrup? (true/false): ");
                boolean extraSyrup = scanner.nextBoolean();

                bevShop.processCoffeeOrder("Coffee", size, extraShot, extraSyrup);
                break;

            case "ALCOHOL":
                bevShop.processAlcoholOrder("Alcohol", size);
                break;

            case "SMOOTHIE":
                System.out.print("Enter the number of fruits for the smoothie: ");
                int numFruits = scanner.nextInt();

                System.out.print("Does the smoothie have protein powder? (true/false): ");
                boolean addProtein = scanner.nextBoolean();

                bevShop.processSmoothieOrder("Smoothie", size, numFruits, addProtein);
                break;

            default:
                System.out.println("Invalid beverage type.");
        }

        scanner.nextLine();  // Consume the newline character
    }
}
