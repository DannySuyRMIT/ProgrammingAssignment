package util;
import core.gameCore;

/**@author Faaz Ruheemaun  */

/**
 * The type Game ending.
 *
 * @Date 28 /05/25
 */
/**@Ver 1.1              */


public class gameEnding {                     // To create booleans that dont change.
    /**
     * The True bad ending.
     */
    static boolean trueBadEnding;
    /**
     * The True good ending.
     */
    static boolean trueGoodEnding;
    /**
     * The Good ending.
     */
    static boolean goodEnding;
    /**
     * The Bad ending.
     */
    static boolean badEnding;

    /**
     * Game ending.
     */
    public static void gameEnding() {             // To determine which ending occurs based on data and what to print.
         badEnding = gameCore.isDeathOccurred();
         trueBadEnding = gameLocations.getHasTriggeredBadShrine();
         trueGoodEnding = gameLocations.getHasTriggeredGoodShrine();
         goodEnding = gameLocations.getHasTriggeredShrine();
         if (badEnding == true) {
             System.out.println("\nYou have Died!\n");
         }
         if (trueBadEnding == true) {
             System.out.println("\nA boat of wood slowly appears at the pier, with it some suspicious individuals.\nThey offer you a spot on the boat and you accept hesitantly, thinking you'll finally get home.\nHowever, despite the countless hours of voyage, the journey doesn't end...You've entered a eternity of wondering in the foggy sea.\n");
         }
         if (goodEnding == true) {
             System.out.println("\nYou see a somewhat modern portable Shrine appear on the end of the pier...\nAs you near the Shrine, you feel a sense of dizziness and you pass out before you can touch the Shrine.\nWaking up, you find yourself back at the alley way...theres no longer is there a Shrine from earlier,\nand you decide to leave the alley way out of confusion thinking it wasn't real.\n");

             System.out.println("\nYou see a shiny modern portable Shrine appear on the end of the pier...\nLight slowly swallows you as your hand nears the Shrine, and you close your eyes out of instinct.\nOpening your eyes once more, you find yourself back at the alley way...you gaze upon the small Shrine from earlier,\nand a golden bar with a yokai-like token appears, seemingly as thanks.\n");
         } else if (trueGoodEnding) {
             System.out.println("\nYou see a shiny modern portable Shrine appear on the end of the pier...\nLight slowly swallows you as your hand nears the Shrine, and you close your eyes out of instinct.\nOpening your eyes once more, you find yourself back at the alley way...you gaze upon the small Shrine from earlier,\nand a golden bar with a yokai-like token appears, seemingly as thanks.\n");
         }
         System.out.print("\nThe end.\n");
         System.exit(0);
    }
}

