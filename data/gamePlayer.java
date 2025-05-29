package data;
import core.gameCore;
import java.util.ArrayList;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/
/**@Ver 2.0              */
/**@Date 28/05/25       */

public class gamePlayer {
    String userName = gameCore.getUserName();
    static int playerHealth;
    static int playerAttackPower;
    static int playerDefencePower;
    static int playerSpiritCoins = 20;

    // Initialise playerInventory Inventory
    private static final ArrayList<gameItems> playerInventory = new ArrayList<gameItems>();

    // Initialise isEmpty check
    static boolean isEmpty;
    // Creating the player
    public gamePlayer(String userName, int playerHealth, int playerAttackPower, int playerDefencePower ) {
        this.userName = userName;
        this.playerHealth = playerHealth;
        this.playerAttackPower = playerAttackPower;
        this.playerDefencePower = playerDefencePower;
    }

    // Attack Power
    public void attack(gameEnemy enemy) {
        System.out.println(userName + " attacks " + enemy.entityName + " for " + playerAttackPower + " damage!");
        enemy.entityHealth -= playerAttackPower;
    }

    // Take damage
    public void takeDamage(int damage) {
        playerHealth -= damage;
        if (playerHealth <= 0) {
            playerHealth = 0;
            System.out.println(userName + " is defeated!");
        }
    }

    //Check if player has more than 0 HP
    public boolean isAlive() {
        return playerHealth > 0;
    }

    //add an item to the players inventory when dropped or bought
    public void addItem(gameItems itemName) {
        if (playerInventory.size() < 8) {
            playerInventory.add(itemName);
        } else {
            System.out.println("Inventory full!");
            return;
        }
        System.out.println("You received: " + itemName);
    }
    // Remove
    public void removeItem(gameItems gameItems) {
        playerInventory.remove(gameItems);
    }
    // Creating an inventory for the player
    public static void showInventory() {
        System.out.printf("\n--- Inventory ---\n");
        System.out.printf("Coins: %d\n",playerSpiritCoins);

        // Fill player inventory with placeholders

        if (playerInventory.isEmpty() == false) {
            System.out.println(playerInventory);
        } else {
            System.out.print("Inventory currently empty\n");
        }


    }
    public static int getPlayerSpiritCoins() {
        return playerSpiritCoins;
    }
    public static boolean getIsEmpty() {
        return isEmpty;
    }

    public static ArrayList<gameItems> getPlayerInventory() {
        return playerInventory;
    }

    public static void playerStats() {
        System.out.printf("Current ATK: %d\nCurrent HP: %d\nCurrent DEF: %d",playerAttackPower, playerHealth, playerDefencePower);
    }

}

