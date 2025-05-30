package util;
import java.util.Scanner;

/**@author Christian Rayos */

/**
 * The type User scanner.
 *
 * @Date 25 /05/25
 */
/**@Ver 1.2               */


public class userScanner {
    /**
     * The User input.
     */
    static Scanner userInput = new Scanner(System.in);

    /**
     * User scan string.
     *
     * @return the string
     */
    public static String userScan() {

        // obtain and return
        String userChoice = userInput.nextLine().toLowerCase(); // obtains user input and makes it lowercase
        return userChoice;
    }

    /**
     * Int scan int.
     *
     * @return the int
     */
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
