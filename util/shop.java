package util;
import Core.gameCore;

public class shop {
    public static void gameBuy () {
        System.out.print("- - -Items for sale- - -\n");
        System.out.print("map\n");

        String userChoice = userScanner.userScan();
        if (userChoice.equals("map")) {
            gameCore.unlockMap();
        }
    }

    public static void shopSell() {
        System.out.print("Select item to sell");
    }

    public static void shopDialogue() {
        System.out.print("welcome to shop\n");
        System.out.print("Would you like to sell wares, or buy some instead?\n");
        System.out.print("[sell]    [buy]   [exit]\n");
        String userChoice = userScanner.userScan();

        if (userChoice.equals("sell")) {
            shopSell();
        } else if (userChoice.equals("buy")) {
            gameBuy();
        } else if(userChoice.equals("exit")) {
            System.out.print("\nGoodbye. See you next time!");
        }
    }

    public static void shopGamble() {

    }
}
