package util;
import core.gameCore;

/**@author Faaz Ruheemaun  */
/**@Editor Christian Rayos*/
/**@Ver 2.1              */
/**@Date 25/05/25       */

public class gameMap {

    // Initialise
    private static boolean successfulMove = false;
    // Start position is at Spawn (3,5)
    public static int currentLocation = 305;

    // Valid room positions (y, x)
    private static final int[][] ROOM_LOCATIONS = {
            {1, 1}, {1, 2}, {1, 4}, {1, 5},
            {2, 1}, {2, 4},
            {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5},
            {4, 1}, {4, 4},
            {5, 1}, {5, 3}, {5, 4}, {5, 5}
    };

    // Room labels (for special rooms)
    private static final String[][] LABELS = {
            {"1", "1", "C"},   // Cave
            {"1", "4", "B"},   // Bamboo Forest
            {"1", "5", "B*"},  // Blacksmith
            {"3", "3", "V"},   // Village
            {"3", "5", "S"},   // Spawn
            {"5", "1", "F"},   // Fogged Forest
            {"5", "3", "Sh"},  // Shrine
            {"5", "5", "O*"},  // Outpost
            {"1", "2", "R"}    // Ritual Area
    };

    public static void gameNavigate() {


        System.out.println("You have opened the map!");
        System.out.println("Use commands like 'go north', 'go west' etc.\n");
        System.out.print("Likewise, you may use 'exit' to return to menu.\n");

        while (true) {   // infinite loop
            if (gameCore.isMapUnlocked() == true) { // Checks if better mapFunction unlocked
                drawMap();
            } else {
                drawInferiorMap();
            }
            System.out.print("Your move: ");
            String userChoice = userScanner.userScan().trim(); // removes any whitespace from.


            if (userChoice.equals("exit")) {
                System.out.println("Returning to Menu!");
                break;
            }

            movePlayer(userChoice);
            if (successfulMove = true) {
                break;
            }
        }
    }

    // Print out the map
    public static void drawMap() {
        int[] loc = getCoordinates(currentLocation);
        int playerY = loc[0];
        int playerX = loc[1];

        // rowDivider for printing
        String rowDivider = "+-----+-----+-----+-----+-----+";

        System.out.println();
        for (int y = 5; y >= 1; y--) { // repeats until all rows have been accounted for
            System.out.println(rowDivider); // Prints initial horizontal and leftmost border of map
            System.out.print("|");

            for (int x = 1; x <= 5; x++) { // prints rest of row
                String label;

                if (playerY == y && playerX == x) { //
                    label = " P ";
                } else if (isRoom(y, x)) {
                    label = formatLabel(getLabel(y, x));
                } else {
                    label = " - ";
                }

                System.out.print(" " + label + " |");
            }
            System.out.println();
        }
        System.out.println(rowDivider);

        // Map Legend
        System.out.println("\nLegend:");
        System.out.println(" C   = Cave");
        System.out.println(" B   = Bamboo Forest");
        System.out.println(" B*  = Blacksmith");
        System.out.println(" V   = Village");
        System.out.println(" S   = Spawn");
        System.out.println(" F   = Fogged Forest");
        System.out.println(" Sh  = Shrine");
        System.out.println(" O*  = Outpost");
        System.out.println(" R   = Ritual Area");
        System.out.println(" P   = Player");
        System.out.println(" -   = Inaccessible\n");
    }

    // Display Inferior map
    public static void drawInferiorMap() {
        int[] loc = getCoordinates(currentLocation);
        int playerY = loc[0];
        int playerX = loc[1];


        String rowDivider = "+-----+-----+-----+-----+-----+";

        System.out.println();
        for (int y = 5; y >= 1; y--) {
            System.out.println(rowDivider);
            System.out.print("|");

            for (int x = 1; x <= 5; x++) {
                String label;

                if (playerY == y && playerX == x) {
                    label = " P ";

                    //Checks for Cells:    Vertically adjacent                      horizontally adjacent
                } else if ((Math.abs(playerY - y) == 1 && playerX == x) || (Math.abs(playerX - x) == 1 && playerY == y)) {
                    // Makes Adjacent cell
                    if (isRoom(y,x)) {
                        label = formatLabel("O");
                    } else {
                        label = " - ";
                    }

                } else {
                    label = " / ";
                }

                System.out.print(" " + label + " |");
            }
            System.out.println();
        }
        System.out.println(rowDivider);

    }


    // Get Y and X from location integer (e.g., 305 => [3, 5])
    public static int[] getCoordinates(int loc) {
        int y = loc / 100;
        int x = loc % 100;
        return new int[]{y, x};
    }

    // Center and pad labels to ensure 3-character width
    private static String formatLabel(String label) {
        return String.format("%-3s", label);
    }

    // Check if position is a walkable room
    public static boolean isRoom(int y, int x) {
        for (int[] room : ROOM_LOCATIONS) {
            if (room[0] == y && room[1] == x) {
                return true;
            }
        }
        return false;
    }

    // Get label for a special room
    public static String getLabel(int y, int x) {
        for (String[] label : LABELS) {
            if (Integer.parseInt(label[0]) == y && Integer.parseInt(label[1]) == x) {
                return label[2];
            }
        }
        return "O"; // Default label for normal room
    }

    // Move the player around based on input
    public static void movePlayer(String direction) {
        int[] loc = getCoordinates(currentLocation);
        int y = loc[0];
        int x = loc[1];

        switch (direction) {
            case "go north" -> y++;
            case "go up"    -> y++;
            case "go south" -> y--;
            case "go down"  -> y--;
            case "go east"  -> x++;
            case "go right" -> x++;
            case "go west"  -> x--;
            case "go left"  -> x--;
            default -> {
                System.out.println("Oops! Try 'go north' or 'go up', etc.");
                return;
            }
        }

        if (isRoom(y, x)) {
            currentLocation = y * 100 + x;
            successfulMove = true;
        } else {
            System.out.println("You can't go that way!");
        }
    }
    public static int getCurrentLocation() { // Obtain players' current location
        return currentLocation;
    }

}

