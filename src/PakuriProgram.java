import java.util.Scanner;
import java.util.Arrays;

public class PakuriProgram {
    public static void main(String[] args) {
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex: ");

        //sets scanners
        Scanner scnr = new Scanner(System.in);

        int userCapacity = 0;;

        boolean isException = true;

        // try catch statement for exception
        while(isException) {
            String userCapacity0 = scnr.next();
            try {
                // checks if input is an int
                userCapacity = Integer.parseInt(userCapacity0);
                isException = false;
                if (userCapacity <= 0) {
                    isException = true;
                    System.out.println("Please enter a valid size.");
                    System.out.println("Enter max capacity of the Pakudex: ");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");
            }
        }

        // set the capacity of the object array
            Pakudex pak = new Pakudex(userCapacity);
            System.out.println("The Pakudex can hold " + userCapacity + " species of Pakuri.");


            //prints menu
        while(true) {
            System.out.println("Pakudex Main Menu ");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.println("What would you like to do?");

            // takes in user's menu choice
            String userInput1 = scnr.next();

            // try catch statement for exception
            try {
                // tests if input is an int
                int userInput0 = Integer.parseInt(userInput1);

                switch (userInput0) {
                    case 1:
                        // checks if there are pakuri in the array to list
                        boolean success;
                        if (pak.getSize() > 0) {
                            success = true;
                        } else {
                            success = false;
                        }

                        // if there are pakuri, then it lists all of the pakuri
                        if (success == true) {
                            System.out.println("Pakuri In Pakudex: ");

                            for (int i = 0; i < pak.getSize(); i++) {
                                int pakNum = i + 1;
                                String pakuriPrint = pak.getSpeciesArray()[i];
                                System.out.println(pakNum + ". " + pakuriPrint);

                            }
                        }
                        // if there are no pakuri, then it does not list any pakuri
                        else if (success == false) {
                            System.out.println("No Pakuri in Pakudex yet!");
                        }
                        break;

                        // displays species and stats
                    case 2:
                        System.out.println("Enter the name of the species to display: ");
                        String userInput2 = scnr.next();

                        if (pak.getStats(userInput2) == null) {
                            System.out.println("Error: No such Pakuri!");
                        }
                        // gets stats of the species
                        else {
                            pak.getStats(userInput2);
                            System.out.println("Species: " + userInput2);

                            System.out.println("Attack: " + pak.getStats(userInput2)[0]);
                            System.out.println("Defense: " + pak.getStats(userInput2)[1]);
                            System.out.println("Speed: " + pak.getStats(userInput2)[2]);
                        }
                        break;

                        // adds species to the object array
                    case 3:
                        if (pak.getSize() >= pak.getCapacity()) {
                            System.out.println("Error: Pakudex is full!");
                        }

                        else {System.out.println("Enter the name of the species to add: ");
                        String userInput3 = scnr.next();

                        pak.addPakuri(userInput3);
                        }
                        break;

                    // evolves species
                    case 4:
                        System.out.println("Enter the name of the species to evolve: ");
                        String userInput5 = scnr.next();

                        if (pak.evolveSpecies(userInput5)) {
                            System.out.println(userInput5 + " has evolved!");
                        }
                        break;

                    // sorts the pakuri in alphabetical order
                    case 5:
                        pak.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                        break;

                    // exits the system
                    case 6:
                        System.out.println("Thanks for using Pakudex! Bye!");
                        System.exit(0);

                        // default if integer input is less than 1 or greater than 6
                    default:
                        System.out.println("Unrecognized menu selection!");
                        break;
                }


            } catch (Exception e) {
                System.out.println("Unrecognized menu selection!");
            }
        }
    }
}
