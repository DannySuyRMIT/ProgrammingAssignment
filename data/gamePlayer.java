package data;
import core.gameCore;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/
/**@Ver 1.5              */
/**@Date 28/05/25       */

public class gamePlayer {
    private gameCore gameCore;
    String userName = gameCore.getUserName();
    int playerHealth;
    int playerAttackPower;
    static int playerSpiritCoins = 20;
    static String item1 = "";
    static String item2 = "";
    static String item3 = "";
    static String item4 = "";
    static String item5 = "";
    static String item6 = "";
    static String item7 = "";
    static String item8 = "";

    // Initialise playerInventory Array
    private static String[] playerInventory = new String[8];

    // Initialise isEmpty check
    static boolean isEmpty;
    // Creating the player
    public gamePlayer(String userName, int playerHealth, int playerAttackPower) {
        this.userName = userName;
        this.playerHealth = playerHealth;
        this.playerAttackPower = playerAttackPower;
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
    public void addItem(String itemName) {
        if (item1.isEmpty()) {
            item1 = itemName;
        } else if (item2.isEmpty()) {
            item2 = itemName;
        } else {
            System.out.println("Inventory full!");
            return;
        }
        System.out.println("You received: " + itemName);
    }
    //Creating an inventory for the player
    public static void showInventory() {
        System.out.println("\n--- Inventory ---");
        System.out.println("Coins: " + playerSpiritCoins);

        // Fill player inventory with placeholders
        playerInventory[0] = item1;
        playerInventory[1] = item2;
        playerInventory[2] = item3;
        playerInventory[3] = item4;
        playerInventory[4] = item5;
        playerInventory[5] = item6;
        playerInventory[6] = item7;
        playerInventory[7] = item8;

        isEmpty = true;
        for (String item : playerInventory) {
            if (!item.isEmpty()) {
                System.out.println("- " + item);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("Inventory is empty.");

        }

    }
    public static int getPlayerSpiritCoins() {
        return playerSpiritCoins;
    }
    public static boolean getIsEmpty() {
        return isEmpty;
    }
}

