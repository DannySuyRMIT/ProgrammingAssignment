package util;
import java.util.Scanner;

public class userScanner {
    public static String userScan() {
        // Initialise
        Scanner userInput = new Scanner(System.in);

        // obtain and return
        String userChoice = userInput.nextLine().toLowerCase(); // obtains user input and makes it lowercase
        return userChoice;
    }
}
