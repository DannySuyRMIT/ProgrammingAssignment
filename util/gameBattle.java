import java.util.Scanner;

public class BattleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their name
        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        // Create a player using the entered name
        gamePlayer player = new gamePlayer(playerName, 50, 3);
        gameEnemy enemy = new gameEnemy("Goblin", 15, 2);

        // Battle loop: Player and enemy take turns attacking
        while (player.isAlive() && enemy.isAlive()) {
            // Player's turn
            System.out.println("\nIt's your turn!");
            System.out.println("1. Attack");
            System.out.print("Choose an action: ");
            int action = scanner.nextInt();

            if (action == 1) {
                player.attack(enemy);
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

        scanner.close();
    }
}
