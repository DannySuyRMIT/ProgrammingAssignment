package data;
import core.*;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/
/**@Ver 1.2              */
/**@Date 28/05/25       */

public class gamePlayer {
    String userName = gameCore.getUserName();
    int playerHealth;
    int playerAttackPower;
    static int playerSpiritCoins = 20;
    String item1 = "";
    String item2 = "";
    String item3 = "";
    String item4 = "";
    String item5 = "";
    String item6 = "";
    String item7 = "";
    String item8 = "";



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
        if (item1.equals("")) {
            item1 = itemName;
        } else if (item2.equals("")) {
            item2 = itemName;
        } else {
            System.out.println("Inventory full!");
            return;
        }
        System.out.println("You received: " + itemName);
    }
    //Creating an inventory for the player
    public void showInventory() {
        System.out.println("\n--- Inventory ---");
        System.out.println("Coins: " + playerSpiritCoins);

        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8};
        boolean isEmpty = true;

        for (String item : items) {
            if (!item.equals("")) {
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
}

