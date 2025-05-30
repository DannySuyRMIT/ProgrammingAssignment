package data;
import core.gameCore;
import java.util.ArrayList;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/
/**@Ver 2.2              */
/**@Date 28/05/25       */

public class gamePlayer {
    String userName = gameCore.getUserName();
    static int playerHealth = 50;
    static int playerAttackPower = 3;
    static int playerDefencePower = 1;
    static int playerSpiritCoins = 0;

    private static gameWeaponItems equippedWeapon;
    private static gameArmourItems equippedArmour;

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

        this.equippedArmour = new gameArmourItems("None", "No armour equipped", 0, 0, false, 0);
        this.equippedWeapon = new gameWeaponItems("None", "No weapon equipped", 0, 0, false, 0);
    }

    // Attack Power
    public void attack(gameEnemy enemy) {
        System.out.println(userName + " attacks " + enemy.entityName + " for " + playerAttackPower + " damage!");
        enemy.entityHealth -= playerAttackPower;
        System.out.println("You have " + playerHealth + "HP.");
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

    // Equip weapon
    public void equipWeapon(gameWeaponItems weapon) {
        System.out.println("Unequipped: " + equippedWeapon.getItemName());
        playerAttackPower -= equippedWeapon.getItemAtk();

        equippedWeapon = weapon;
        playerAttackPower += weapon.getItemAtk();

        System.out.println("Equipped weapon: " + weapon.getItemName());
    }

    // Equip armour
    public void equipArmour(gameArmourItems armour) {
        System.out.println("Unequipped: " + equippedArmour.getItemName());
        playerDefencePower -= equippedArmour.getItemDef();

        equippedArmour = armour;
        playerDefencePower += armour.getItemDef();

        System.out.println("Equipped armour: " + armour.getItemName());
    }

    public void equipWeaponByName(String itemName) {
        for (gameItems item : playerInventory) {
            if (item.getItemType().equals("Weapon") && item.getItemName().equalsIgnoreCase(itemName)) {
                equipWeapon((gameWeaponItems) item); // Cast is still needed
                return;
            }
        }
        System.out.println("Weapon named '" + itemName + "' not found in inventory.");
    }

    public void equipArmourByName(String itemName) {
        for (gameItems item : playerInventory) {
            if (item.getItemType().equals("Armour") && item.getItemName().equalsIgnoreCase(itemName)) {
                equipArmour((gameArmourItems) item); // Cast is still needed
                return;
            }
        }
        System.out.println("Armour named '" + itemName + "' not found in inventory.");
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

    public static void playerStat() {
        System.out.printf("Current ATK: %d\nCurrent HP: %d\nCurrent DEF: %d\n", playerAttackPower, playerHealth, playerDefencePower);
        System.out.println("Equipped Weapon: " + equippedWeapon.getItemName() + " (ATK: " + equippedWeapon.getItemAtk() + ")");
        System.out.println("Equipped Armour: " + equippedArmour.getItemName() + " (DEF: " + equippedArmour.getItemDef() + ")");
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