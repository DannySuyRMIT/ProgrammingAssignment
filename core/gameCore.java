package core;
import util.*;

/**@author Christian Rayos */
/**@Editor Faaz Ruheemaun */
/**@Ver 2.3              */
/**@Date 25/05/25       */

public class gameCore {
    // Establish private values
    private static boolean mapUnlocked = false;
    private static boolean deathOccurred = false;

    // Obtain Player Name
    static String userName = userScanner.userScan();
    public static void gameLogic() {
        // Initialise Scanner :(
        userScanner userInput = new userScanner();

        // Initialise boolean locationEntryPrinted
        boolean locationEntryPrinted = false;

        while (!deathOccurred) {
            // Initialise Boolean Check
            boolean loopCheck = false;


            // Check if it's the first during menu.
            if (locationEntryPrinted == false) {
                gameLocations.locationEntry();
            }
            locationEntryPrinted = false;

            // Print initial Choices
            System.out.print("\n- - -Options- - -\n");
            System.out.print("\n[Interact] [Menu]\n");

            String userChoice = userScanner.userScan();

            if (userChoice.equals("interact")) {
                gameLocations.locationInteract();
            }

            else if (userChoice.equals("menu")) {
                // Menu
                while(loopCheck == false) {
                    System.out.print("\n- - - Menu - - -\n1. [Navigate]   \n2. [Map]   \n3. [Inventory]   \n4. [Stats]   \n5. [Exit]\n");
                    userChoice = userScanner.userScan();

                    if (userChoice.equals("navigate") || userChoice.equals("1")) {
                        // Put navigate Methods here
                        System.out.print("navigate\n");
                        gameMap.gameNavigate();
                        // Provide options to go N, E, S, W
                        // Temporary placement to test shop.
//                        System.out.print("- -Shop tile located- - \n");
//                        shop.shopDialogue();
                        loopCheck = true;

                    } else if (userChoice.equals("map") || userChoice.equals("2")) {
                        if (mapUnlocked == true) {
                            // put map methods here
                            gameMap.drawMap();
                        } else {
                            System.out.print("Go unlock the map. It's in the store >.<\n");
                        }

                    } else if (userChoice.equals("inventory") || userChoice.equals("3")) {
                        // put inventory methods here
                        System.out.print("Display inventory");
                        unlockMap();
                    } else if (userChoice.equals("stats") || userChoice.equals("4")) {
                        // put stats methods here
                        System.out.printf("- - -%s- - -",userName);
                    } else if (userChoice.equals("exit") || userChoice.equals("5")) {
                        // exit
                        System.out.print("Quit W.");
                        System.exit(0);
                    } else { // Make user select valid option
                        System.out.print("Select a valid option...\n");
                    }
                }
            } else { // Any responses that isn't "menu" or "interact" will prevent locationEntry from being printed again
                locationEntryPrinted = true;
            }
            //

        }
    } public static boolean isMapUnlocked() { // Provides status of mapUnlocked || True or False
        return mapUnlocked;
    }

    public static boolean isDeathOccurred() { // Provides status of deathOccurred || True or False
        return deathOccurred;
    }


    public static void unlockMap() { // Changes mapUnlocked from False to True
        mapUnlocked = true;
        System.out.print("\nMap feature now unlocked!\n");
    }

    public static void DeathOccur() { // Changes deathOccurred from False to True
        deathOccurred = true;
    }

    public static String getUserName() { //Temporary Method, relocate to playerData
        return userName;
    }
}
