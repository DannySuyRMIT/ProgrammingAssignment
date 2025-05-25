package util;
import java.util.Scanner;

public class userScanner {
    public String userScan() {
        // Initialise
        Scanner userInput = new Scanner(System.in);

        // obtain and return
        String userChoice = userInput.nextLine();

        userChoice= userChoice.toLowerCase(); // makes choices lowercase
        return userChoice;
    }
}
