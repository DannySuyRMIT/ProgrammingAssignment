import util.userScanner;

public class gameStart {
    public static void main(String[] args) {
        System.out.print(" - - - - - Youkai Daze - - - - -\n"); // Title Sequence!

        // Lore block
        System.out.print("\nAfter a night of heavy drinking with your fellow workers, just to cope with\n the news of being laid off from work. You head out, walking down the hazy\n streets of Tokyo, your surroundings becoming a blur from the effects of alcohol. \nLured down an alleyway, you spot an old, small shrine, just as you pass out...\n\n");
        System.out.print("Waking up to an old wooden pier, your eyes adjust to the dark and humid atmosphere \naround you. The waters around you move about suspiciously, its' depths hidden underneath the surface. \nThe air around you feels... different. Mist surrounds you, and with how obscured your vision is, \nthe only choice you have is heading up the pier...\n");

        // Choice to begin or exit.
        System.out.print("Select your choice:\n1. Begin\n2. Exit\n");
        userScanner userInput = new userScanner();
        String userChoice = userInput.userScan();
        while (true) {
            if (userChoice.equals("begin") || userChoice.equals("1")) {
                System.out.print("Beginning Simulation...\n");
                // Put gameCore / gameLogic method here
                gameCore.gameLogic();
                break;
            } else if (userChoice.equals("exit") || userChoice.equals("2")) {
                System.out.print("\n The Matrix.");
                System.exit(0);
            } else {
                System.out.print("Please Select an option:");
                userChoice = userInput.userScan();
            }
        }
    }
}