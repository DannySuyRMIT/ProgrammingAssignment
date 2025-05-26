package util;
import java.util.Scanner;

/**@author Christian Rayos */

public class userScanner {
    static Scanner userInput = new Scanner(System.in);
    public static String userScan() {


        // obtain and return
        String userChoice = userInput.nextLine().toLowerCase(); // obtains user input and makes it lowercase
        return userChoice;
    } public static int indexScan() {
        int indexSelect = userInput.nextInt();
        return indexSelect;
    }
}
