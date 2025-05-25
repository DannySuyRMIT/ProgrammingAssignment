import util.userScanner;

public class gameStart {
    public static void main(String [] args) {
        System.out.print("- - - Game Name - - -\n");
        System.out.print("Game Setting...");
        System.out.print("Select your choice:\n1. Begin\n2. Retreat\n");
        userScanner userInput = new userScanner();
        String userChoice = userInput.userScan();
        while (userChoice != "begin" || userChoice != "retreat") {
            if (userChoice.equals("begin") || userChoice.equals("1")) {
                System.out.print("Beginning Simulation...\n");
                // Put gameCore / gameLogic method here
                break;
            }
            else if(userChoice.equals("retreat") || userChoice.equals("2")) {
                System.out.print("\n The Matrix.");
                System.exit(1);
            }
            else {
                System.out.print("Please Select an option:");
                userChoice = userInput.userScan();
            }
        }

    }
}
