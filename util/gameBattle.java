package util;
import core.gameCore;
import data.*;
import java.util.Random;

/**@author Danny Suy  */
/**@Ver 1.4           */
/**@Date 29/05/25     */


public class gameBattle {
    public static void gameCombat(gamePlayer player, gameEnemy enemy, String poolType) {

        // Battle loop: Player and enemy take turns attacking
        while (player.isAlive() && enemy.isAlive()) {
            //Print stats
            System.out.print("\n<-- - - - -=entity=- - - - -->\n");
            System.out.print(enemy);
            System.out.print("\n\n");
            gamePlayer.playerStats();
            System.out.print("\n<-- - - - -=Player=- - - - -->\n");

            // Player's turn
            System.out.println("\nIt's your turn!");
            System.out.println("1. Attack");
            System.out.println("2. Inventory");
            System.out.print("Choose an action: ");
            int action = userScanner.intScan();

            if (action == 1) {
                player.attack(enemy);
            } else if (action == 2) {
                gamePlayer.showInventory();
                System.out.print("Choose an item to use (1-8): ");
            } else {
                System.out.println("Invalid action. Please choose 1 or 2.");
                continue;
            }

            // Check if the enemy is dead
            if (!enemy.isAlive()) {
                System.out.println("\nYou defeated the enemy!");
                userScanner.userScan();
                gameEnemy.enemyPool.disableEnemyPool(poolType);
                Random droppedChance = new Random();

                int spiritCoins = droppedChance.nextInt(3)+1;
                spiritCoins += gamePlayer.getPlayerSpiritCoins();
                gamePlayer.setPlayerSpiritCoins(spiritCoins);

                int dropItem = droppedChance.nextInt(0,100);
                if (dropItem <= 6) {
                    dropItem = droppedChance.nextInt(0,shop.populateShopInventory().size()+1);
                    player.addItem(shop.populateShopInventory().get(dropItem));
                }

                break;
            }

            // Enemy's turn
            System.out.println("\nIt's the enemy's turn!");
            enemy.attack(player);

            // Check if the player is dead
            if (!player.isAlive()) {
                System.out.println("\nYou have been defeated!");
                gameCore.DeathOccur();
                gameEnding.gameEnding();
                break;
            }
        }
    }
}
