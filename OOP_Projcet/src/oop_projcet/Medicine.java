package oop_projcet;

import java.util.Objects;

public class Medicine {

    private String name;
    private String composition;
    private int dose;
    private double price;
    private int quantity;

    //constructors
    public Medicine() {
        this("no name", "no composition", 1000, 10, 0);
    }

    public Medicine(String name, String composition,
            int dose, double price, int quantity) {
        setMed(name, composition, dose, price, quantity);
    }

    //setters
    public void setMed(String name, String composition,
            int dose, double price, int quantity) {
        setName(name);
        setComposition(composition);
        setDose(dose);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name) {
        //made the name lowercase for generelization
        this.name = name.toLowerCase();
    }

    public void setComposition(String composition) {
        //made the composition lowercase for generelization
        this.composition = composition.toLowerCase();
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public int getDose() {
        return dose;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    //other methods 
    @Override
    public String toString() {
        return "\tname: " + name + "\n\tcomposition: " + composition + "\n\tdo"
                + "se: " + dose + "mg\n\tprice: " + price
                + "\n\tquantity: " + quantity;
    }

    @Override
    //equals method that checks name and dose
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Medicine) {
            final Medicine other = (Medicine) obj;
            if (dose != other.dose) {
                return false;
            }
            return Objects.equals(name, other.name);
        }
        return false;
    }
}
