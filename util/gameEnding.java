package util;
import core.gameCore;

/**@author Faaz Ruheemaun  */
/**@Ver 1.0              */
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
         System.out.println("True Bad Ending!");
     }
    if (isShrineEnding == true){
        System.out.println("True Good Ending!");
    }
    else{
        System.out.println("Good Ending");
    }

}{
 }
}
