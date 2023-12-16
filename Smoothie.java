/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Subclass of Beverage to process smoothie orders
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
public class Smoothie extends Beverage {
    private int numFruits;
    private boolean proteinPowder;
    private static final double PROTEIN_PRICE = 1.5;
    static final double FRUIT_PRICE = 0.5;

    public Smoothie(String name, Size size, int numFruits, boolean proteinPowder) {
        super(name, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.proteinPowder = proteinPowder;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + SIZE_PRICE * (getSize().ordinal() + 1);
        if (proteinPowder) price += PROTEIN_PRICE;
        price += numFruits * FRUIT_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Fruits: %d, Protein Powder: %s", numFruits, proteinPowder);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Smoothie smoothie = (Smoothie) obj;

        if (!getName().equals(smoothie.getName())) return false;
        if (getType() != smoothie.getType()) return false;
        if (getSize() != smoothie.getSize()) return false;
        if (numFruits != smoothie.numFruits) return false;
        return proteinPowder == smoothie.proteinPowder;
    }

    // Getters and Setters for the private fields
    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean isProteinPowder() {
        return proteinPowder;
    }

    public void setProteinPowder(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }
}
