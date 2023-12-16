/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Subclass of beverage to process coffee orders
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private static final double EXTRA_SHOT_PRICE = 0.5;
    private static final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + SIZE_PRICE * (getSize().ordinal() + 1);
        if (extraShot) price += EXTRA_SHOT_PRICE;
        if (extraSyrup) price += EXTRA_SYRUP_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Extra Shot: %s, Extra Syrup: %s", extraShot, extraSyrup);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coffee coffee = (Coffee) obj;

        if (!getName().equals(coffee.getName())) return false;
        if (getType() != coffee.getType()) return false;
        if (getSize() != coffee.getSize()) return false;
        if (extraShot != coffee.extraShot) return false;
        return extraSyrup == coffee.extraSyrup;
    }

    // Getters and Setters for the private fields
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
