package lockedme;

import java.util.Scanner;
import lockedme.businesslogic.FileOperations;

public class Executable {

    public static void main(String[] args) {
        FileOperations fileOperations = new FileOperations();
        Scanner scanner = new Scanner(System.in);
        int mainChoice, subChoice;

        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║         Welcome to LockedMe.com         ║");
        System.out.println("║         Developed by: Akshat Das        ║");
        System.out.println("║     Email Id: akshatdas31@gmail.com     ║");
        System.out.println("╚═════════════════════════════════════════╝\n");

        do {
            System.out.println("─────────────────────────────────────");
            System.out.println("             Main Menu               ");
            System.out.println("─────────────────────────────────────");
            System.out.println("1. List files alphabetically");
            System.out.println("2. Create/delete/search file");
            System.out.println("3. Exit application");
            System.out.println("─────────────────────────────────────");
            System.out.print("Enter your choice: ");

            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    fileOperations.sortFileNames();
                    break;
                case 2:
                    do {
                        System.out.println("─────────────────────────────────────");
                        System.out.println("      Business-level operations      ");
                        System.out.println("─────────────────────────────────────");
                        System.out.println("1. Create a file in a directory");
                        System.out.println("2. Delete a file from a directory");
                        System.out.println("3. Search for a file in a directory");
                        System.out.println("4. Return to the main menu");
                        System.out.println("─────────────────────────────────────");
                        System.out.print("Enter your choice: ");

                        subChoice = scanner.nextInt();
                        switch (subChoice) {
                            case 1:
                                fileOperations.addFile();
                                break;
                            case 2:
                                fileOperations.deleteFile();
                                break;
                            case 3:
                                fileOperations.searchFile();
                                break;
                            case 4:
                                // Return to the main menu
                                break;
                            default:
                                System.out.println("\nPlease enter a valid choice");
                                break;
                        }
                    } while (subChoice != 4);
                    break;
                case 3:
                    System.out.println("\nExiting program...");
                    System.out.println("Thank you for using LockedMe!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice");
                    System.out.println("Please enter a valid choice");
                    break;
            }

        } while (mainChoice != 3);

        scanner.close();
    }
}