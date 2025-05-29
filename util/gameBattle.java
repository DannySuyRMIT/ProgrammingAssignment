package util;
import data.gameEnemy;
import data.gamePlayer;
import java.util.Scanner;
import static core.gameCore.userName;

/**@author Danny Suy  */
/**@Ver 1.4           */
/**@Date 29/05/25     */


public class gameBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a player using the entered name
        gamePlayer player = new gamePlayer(userName, 50, 3);
        gameEnemy enemy = new gameEnemy("name", 15, 2);

        // Battle loop: Player and enemy take turns attacking
        while (player.isAlive() && enemy.isAlive()) {
            // Player's turn
            System.out.println("\nIt's your turn!");
            System.out.println("1. Attack");
            System.out.println("2. Inventory");
            System.out.print("Choose an action: ");
            int action = scanner.nextInt();

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
                break;
            }

            // Enemy's turn
            System.out.println("\nIt's the enemy's turn!");
            enemy.attack(player);

            // Check if the player is dead
            if (!player.isAlive()) {
                System.out.println("\nYou have been defeated!");
                break;
            }
        }
    }
}
