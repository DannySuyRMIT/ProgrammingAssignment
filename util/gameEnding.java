package util;
import core.gameCore;

/**@author Faaz Ruheemaun  */
/**@Ver 1.1              */
/**@Date 28/05/25       */

public class gameEnding {
    private static boolean isBambooShrubeEnding = false;
    boolean isShrineShrubeEnding = false;


 public static void gameEnding(){
     boolean DeathOccurred = gameCore.isDeathOccurred();
     boolean isShrineShrubeEnding = true;
     boolean isShrineEnding = true;
     if (DeathOccurred  == true){
         System.out.println("You have Died!");
     }
     if (isBambooShrubeEnding == true){
         System.out.println("A bot slowly appears at the pier, with it some suspicious people.\nThey offer you a spot on the boat and you accept hesitantly, thinking you'll finally get home.\nHowever, despite the countless hours of voyage, the journey doesn't end...You've entered a eternity of wondering in the foggy sea.");
     }
    if (isShrineEnding == true){
        System.out.println("You see a shiny modern portable Shrine appear on the end of the pier...\nLight slowly swallows you as your hand nears the Shrine, and you close your eyes out of instinct.\nOpening your eyes once more, you find yourself back at the alley way...you gaze upon the small Shrine from earlier,\nand a golden bar with a yokai-like token appears, seemingly as thanks.");
    }
    else{
        System.out.println("You see a somewhat modern portable Shrine appear on the end of the pier...\nAs you near the Shrine, you feel a sense of dizziness and you pass out before you can touch the Shrine.\nWaking up, you find yourself back at the alley way...theres no longer is there a Shrine from earlier,\nand you decide to leave the alley way out of confusion thinking it wasn't real.");
    }

}{
 }
}
