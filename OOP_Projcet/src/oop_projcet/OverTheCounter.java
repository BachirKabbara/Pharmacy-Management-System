package oop_projcet;

public class OverTheCounter extends Medicine {

    private int minAge;

    //constructors
    public OverTheCounter(String name, String composition,
            int dose, int minAge) {
        this(name, composition, dose, 10, 0, minAge);
    }

    public OverTheCounter(String name, String composition,
            int dose, double price, int quantity, int minAge) {
        super(name, composition, dose, price, quantity);
        setMinAge(minAge);
    }

    //setter
    public void setMinAge(int minAge) {
        //insuring the age is positive
        if (minAge > 0) {
            this.minAge = minAge;
        } else {
            this.minAge = 18;
        }
    }

    //getter
    public int getMinAge() {
        return minAge;
    }

    //other methods
    @Override
    public String toString() {
        return "OverTheCounter: \n" + super.toString()
                + "\n\tminimum Age: " + this.minAge;
    }

}
