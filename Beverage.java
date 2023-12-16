/*
 * Class: CMSC203 
 * Instructor:Gary Thai
 * Description: Superclass Beverage class to to list methods for beverages 
 * Due: 12/15/2023
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Binyam Wodajo
*/
public abstract class Beverage {
    protected String name;
    protected Type type;
    protected Size size;
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_PRICE = 1.0;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Beverage beverage = (Beverage) obj;

        if (!name.equals(beverage.name)) return false;
        if (type != beverage.type) return false;
        return size == beverage.size;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
