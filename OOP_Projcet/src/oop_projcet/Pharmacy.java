package oop_projcet;

public class Pharmacy {

    private String name;
    private Medicine[] medicines = new Medicine[MaxNumberOfMedicines];
    private int overTheCounterQuantity;
    private int prescriptionQuantity;
    private int numberOfMedicines;
    private static int MaxNumberOfMedicines = 100;

    //constructor
    public Pharmacy(String name) {
        setName(name);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public static void setMaxNumberOfMedicines(int MaxNumberOfMedicines) {
        Pharmacy.MaxNumberOfMedicines = MaxNumberOfMedicines;
    }

    //getters (u did not mention a getter for the name...)
    public Medicine[] getMedicines() {
        return medicines;
    }

    public int getOverTheCounterQuantity() {
        return overTheCounterQuantity;
    }

    public int getPrescriptionQuantity() {
        return prescriptionQuantity;
    }

    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public static int getMaxNumberOfMedicines() {
        return MaxNumberOfMedicines;
    }

    //other methods
    public void addMedicine(Medicine newMed) {
        if (MaxNumberOfMedicines == numberOfMedicines) {
            System.out.println("ERROR: Max number of medicines reached");
            return;
        }
        for (int i = 0; i < medicines.length; i++) {
            if (newMed.equals(medicines[i])) {
                System.out.println("ERROR: This med exists in the Pharmacy");
                return;
            }
        }
        medicines[numberOfMedicines] = newMed;
        numberOfMedicines++;

        if (newMed instanceof Prescription) {
            prescriptionQuantity += newMed.getQuantity();
        } else if (newMed instanceof OverTheCounter) {
            overTheCounterQuantity += newMed.getQuantity();
        }

        System.out.println("New medicine is added successfully");
    }

    public void raisePrices(double percentage) {
        if (percentage == 0) {
            return;
        }
        if (percentage > 0) {
            for (int i = 0; i < medicines.length; i++) {
                if (medicines[i] != null) {
                    medicines[i].setPrice(medicines[i].getPrice()
                            * ((percentage * 0.01) + 1));
                }
            }
        } else {
            for (int i = 0; i < medicines.length; i++) {
                if (medicines[i] != null) {
                    medicines[i].setPrice(medicines[i].getPrice()
                            * (1 - (-percentage * 0.01)));
                }
            }
        }
    }

    public int[] searchByName(String name) {
        int counter = 0;
        int[] dummyArrayOfMeds = new int[MaxNumberOfMedicines];
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i] != null) {
                if (name.equals(medicines[i].getName())) {
                    dummyArrayOfMeds[counter] = i;
                    counter++;
                }
            }
        }
        int[] arrayOfMeds = new int[counter];
        for (int i = 0; i < arrayOfMeds.length; i++) {
            arrayOfMeds[i] = dummyArrayOfMeds[i];
        }
        return arrayOfMeds;
    }

    public int searchByNameAndDose(String name, int dose) {
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i] != null) {
                if (name.equals(medicines[i].getName())
                        && dose == medicines[i].getDose()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int[] searchByComposition(String composition) {
        int counter = 0;
        int[] dummyArrayOfMeds = new int[MaxNumberOfMedicines];
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i] != null) {
                if (composition.equals(medicines[i].getComposition())) {
                    dummyArrayOfMeds[counter] = i;
                    counter++;
                }
            }
        }
        int[] arrayOfMeds = new int[counter];
        for (int i = 0; i < arrayOfMeds.length; i++) {
            arrayOfMeds[i] = dummyArrayOfMeds[i];
        }
        return arrayOfMeds;
    }

    public void sellMedicine(String name, int dose, int quantity) {
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i] != null) {
                if (name.equals(medicines[i].getName())
                        && dose == medicines[i].getDose()) {
                    if (medicines[i].getQuantity() >= quantity) {

                        if (medicines[i] instanceof Prescription) {
                            prescriptionQuantity -= quantity;
                        } else if (medicines[i] instanceof OverTheCounter) {
                            overTheCounterQuantity -= quantity;
                        }
                        medicines[i].setQuantity(medicines[i].getQuantity()
                                - quantity);
                        System.out.println("Operation Successful");
                        return;
                    } else {
                        System.out.println("ERROR: No enough quantity");
                        return;
                    }
                }
            }
        }
        System.out.println("ERROR: Medicine not found");
    }

    public boolean restock(String name, int dose, int quantity) {
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i] != null) {
                if (name.equals(medicines[i].getName())
                        && dose == medicines[i].getDose()) {
                    if (medicines[i] instanceof Prescription) {
                        prescriptionQuantity += quantity;
                    } else if (medicines[i] instanceof OverTheCounter) {
                        overTheCounterQuantity += quantity;
                    }
                    medicines[i].setQuantity(medicines[i].getQuantity()
                            + quantity);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pharmacy: " + name
                + "\nNumber Of Medicines: " + numberOfMedicines
                + "\nOver The Counter Quantity: " + overTheCounterQuantity
                + "\nPrescription Quantity: " + prescriptionQuantity;
    }
}
