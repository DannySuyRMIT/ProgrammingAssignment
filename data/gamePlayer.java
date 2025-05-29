package data;
import core.gameCore;
import java.util.ArrayList;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/
/**@Ver 2.1              */
/**@Date 28/05/25       */

public class gamePlayer {
    String userName = gameCore.getUserName();
    static int playerHealth = 50;
    static int playerAttackPower = 2;
    static int playerDefencePower = 1;
    static int playerSpiritCoins = 0;

    // Initialise playerInventory Inventory
    private static final ArrayList<gameItems> playerInventory = new ArrayList<gameItems>();

    // Initialise isEmpty check
    static boolean isEmpty;
    // Creating the player
    public gamePlayer(String userName, int playerHealth, int playerAttackPower, int playerDefencePower) {
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
        if (playerDefencePower >= damage) {
            damage = 1;
            playerHealth -= damage;
        } else {
            damage -= playerDefencePower;
            playerHealth -= damage;
            }
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
    public void addItem(gameItems gameItems) {
        if (playerInventory.size() < 8) {
            playerInventory.add(gameItems);
        } else {
            System.out.println("Inventory full!");
            return;
        }
        System.out.println("You received: " + gameItems);
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

    public static void setPlayerSpiritCoins(int newPlayerSpiritCoins) {
        playerSpiritCoins = newPlayerSpiritCoins;
    }
    public static boolean getIsEmpty() {
        return isEmpty;
    }

    public static ArrayList<gameItems> getPlayerInventory() {
        return playerInventory;
    }

    public static void displayPlayerInventory() {
        for (int i = 0; i < playerInventory.size(); i++) {
            System.out.println(" - "+playerInventory.get(i).toString());
        }
    }

    public void playerStats() {
        System.out.printf("Current ATK: %d\nCurrent HP: %d\nCurrent DEF: %d\n", playerAttackPower, playerHealth, playerDefencePower);
    }

    public static int getPlayerHealth() {
        return playerHealth;
    }

    public static void setPlayerHealth(int HP) {
        playerHealth = HP;
    }

    public static int getPlayerAttackPower() {
        return playerAttackPower;
    }

    public static void setPlayerAttackPower(int ATK) {
        playerAttackPower = ATK;
    }

    public static int getPlayerDefencePower() {
        return playerDefencePower;
    }

    public static void setPlayerDefencePower(int DEF) {
        playerDefencePower = DEF;
    }

}

