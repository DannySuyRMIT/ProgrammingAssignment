import core.gameCore;
import util.userScanner;

/**@author Christian Rayos */
/**@Ver 2.3              */
/**@Date 25/05/25        */

public class gameStart {
    public static void main(String[] args) {
        // Initialise inputScanner
        userScanner userInput = new userScanner();

        // Boolean initialise
        boolean userSelect = false;
        // Description
        System.out.print(" - - - - - Youkai Daze - - - - -\n"); // Title Sequence!

        // Lore block
        System.out.print("\nAfter a night of heavy drinking with your fellow workers, just to cope with\nthe news of being laid off from work. You head out, walking down the hazy\nstreets of Tokyo, your surroundings becoming a blur from the effects of alcohol. \nLured down an alleyway, you spot an old, small shrine, just as you pass out...\n\n");
        System.out.print("Waking up to an old wooden pier, your eyes adjust to the dark and humid atmosphere \naround you. The waters around you move about suspiciously, its' depths hidden \nunderneath the surface. The atmosphere and mood of this newfound place feels... off,\nunwelcoming to you. Feeling that it's not safe to stay where you are, you have only\none choice... Move through the pier towards the silhouette of the island ahead...\nAnd try to get back home. Alive hopefully.\n");
        // Choice to begin or exit.
        System.out.println("Decide:\n1. Begin\n2. Exit");
        String userChoice = userInput.userScan();
        while (!userSelect) {
            if (userChoice.equals("begin") || userChoice.equals("1")) {
                System.out.print("Entering the mist...\nYour name is:\n");
                userSelect = true;
                core.gameCore.gameLogic();
            } else if (userChoice.equals("exit") || userChoice.equals("2")) {
                System.out.print("\nThe Matrix.");
                userSelect = true;
                System.exit(0);
            } else {
                System.out.print("Please Select an option:\n");
                userChoice = userInput.userScan();
            }
        }
        System.out.print("\nGame Completion.");
    }
}