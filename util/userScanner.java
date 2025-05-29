package util;
import java.util.Scanner;

/**@author Christian Rayos */
/**@Ver 1.2               */
/**@Date 25/05/25        */

public class userScanner {
    static Scanner userInput = new Scanner(System.in);
    public static String userScan() {

        // obtain and return
        String userChoice = userInput.nextLine().toLowerCase(); // obtains user input and makes it lowercase
        return userChoice;
    }

    public static int intScan() {
        int indexSelect = 0; // used for Integer usage

        try {
            indexSelect = userInput.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return indexSelect;
    }
}
