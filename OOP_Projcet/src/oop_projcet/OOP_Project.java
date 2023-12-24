package oop_projcet;

import java.util.*;

public class OOP_Project {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //all datafeilds used
        double price;
        char choose;
        int choice, dose, quantity, minAge;
        String name, composition, doctorSp;
        Pharmacy pharmacy = new Pharmacy(" myPharma ");
        OverTheCounter OnewMed;
        Prescription PnewMed;
        int[] SearchedMeds;
        Medicine[] meds;

        //main program
        System.out.println("Welcome to \" myPharma \" pharmacy system.");
        //this loop uses the menu method always displaying and retruning the number the user chooses
        //if the number is different then 8 the loop will continue
        do {
            System.out.println("--------------------"
                    + "---------------------------");
            choice = menu();

            switch (choice) {
                case 1:
                    //giving the user a choice to add either over the couter or perscription meds
                    System.out.print("Choose O or o for over the counter"
                            + "medicine and p or P for"
                            + "\nprescription medicine: ");
                    // loop to ensure the user choose the right parameters
                    do {
                        choose = scan.next().charAt(0);
                    } while (choose != 'o' && choose != 'O'
                            && choose != 'p' && choose != 'P');
                    System.out.println("\nEnter the information"
                            + " of the new medicine:\n");
                    System.out.print("name: ");
                    name = scan.next();
                    System.out.print("composition: ");
                    composition = scan.next();
                    System.out.print("dose: ");
                    dose = scan.nextInt();
                    System.out.print("quantity: ");
                    quantity = scan.nextInt();
                    System.out.print("price: ");
                    price = scan.nextDouble();
                    if (choose == 'O' || choose == 'o') {
                        System.out.print("Enter the minimum Age"
                                + " for this medicine: ");
                        minAge = scan.nextInt();
                        OnewMed = new OverTheCounter(name, composition,
                                dose, price, quantity, minAge);
                        pharmacy.addMedicine(OnewMed);
                        System.out.println();
                    } else {
                        System.out.print("Enter the doctor specialization"
                                + " for this medicine: ");
                        doctorSp = scan.next();
                        PnewMed = new Prescription(name, composition, dose,
                                price, quantity, doctorSp);
                        pharmacy.addMedicine(PnewMed);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the"
                            + " medicine to be found: ");
                    name = scan.next();
                    SearchedMeds = pharmacy.searchByName(name);
                    meds = pharmacy.getMedicines();
                    System.out.println(SearchedMeds.length
                            + " medicine found matching this name.");
                    //loop through the array of meds by that name
                    for (int i = 0; i < SearchedMeds.length; i++) {
                        System.out.println((i + 1) + "- "
                                + meds[SearchedMeds[i]]);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter the composition"
                            + " of the medicine to be found: ");
                    composition = scan.next();
                    meds = pharmacy.getMedicines();
                    SearchedMeds = pharmacy.searchByComposition(composition);
                    System.out.println(SearchedMeds.length
                            + " medicine found matching this composition.");
                    //loop through the array of meds by that composition
                    for (int i = 0; i < SearchedMeds.length; i++) {
                        System.out.println((i + 1) + "- "
                                + meds[SearchedMeds[i]]);
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("\nEnter the name of the medicine: ");
                    name = scan.next();
                    System.out.print("Enter the dose: ");
                    dose = scan.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = scan.nextInt();
                    //call the sellMedicine void method automaticlly prints and does the operation
                    pharmacy.sellMedicine(name, dose, quantity);
                    break;
                case 5:
                    System.out.print("\nEnter the name of the medicine: ");
                    name = scan.next();
                    System.out.print("Enter the dose: ");
                    dose = scan.nextInt();
                    System.out.print("Enter the quantity: ");
                    quantity = scan.nextInt();
                    //unlike the void method this one is a boolean so we manually printed if the operation was successful 
                    if (pharmacy.restock(name, dose, quantity)) {
                        System.out.println("Restock Successful\n");
                    } else {
                        System.out.println("Restock Unsuccessful\n");
                    }
                    break;
                case 6:
                    meds = pharmacy.getMedicines();
                    //looping through all the meds and if not found an error msg is printed
                    if (pharmacy.getNumberOfMedicines() != 0) {
                        for (int i = 0; i
                                < pharmacy.getNumberOfMedicines(); i++) {
                            System.out.print("Medicine " + (i + 1) + ": ");
                            System.out.println(meds[i]);
                            System.out.println("----\n");
                        }
                    } else {
                        System.out.println("No Medicine to be found");
                    }
                    break;
                case 7:
                    //simply using the pharmacy toString method 
                    System.out.println("\n" + pharmacy + "\n");
                    break;
            }

        } while (choice
                != 8);
    }

    //required method
    public static int menu() {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.print("Choose one the following options:\n"
                + "1- Add a new medicine\n"
                + "2- Search for a medicine by name\n"
                + "3- Search for a medicine by composition\n"
                + "4- Sell a medicine\n"
                + "5- Restock a medicine\n"
                + "6- Display all medicines\n"
                + "7- Display information\n"
                + "8- Exist\n"
                + "Enter your choice (between 1 and 8): ");
        //loop so that the user is required to choose the right option 
        do {
            choice = scan.nextInt();
        } while (choice < 1 || choice > 8);

        return choice;
    }

}

// happy face :)