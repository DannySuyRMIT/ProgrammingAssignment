package data;
import core.gameCore;
import java.util.ArrayList;

/**@author Danny Suy       */
/**@Editor Christian Rayos*/

/**
 * The type Game player.
 *
 * @Date 28 /05/25
 */
/**@Ver 2.2              */


public class gamePlayer {
    /**
     * The Username.
     */
    String userName = gameCore.getUserName();
    /**
     * The Player health.
     */
    static int playerHealth = 50;
    /**
     * The Player attack power.
     */
    static int playerAttackPower = 3;
    /**
     * The Player defense power.
     */
    static int playerDefencePower = 1;
    /**
     * The Player spirit coins.
     */
    static int playerSpiritCoins = 0;

    private static gameWeaponItems equippedWeapon;
    private static gameArmourItems equippedArmour;

    // Initialise playerInventory Inventory
    private static final ArrayList<gameItems> playerInventory = new ArrayList<gameItems>();

    /**
     * The constant isEmpty.
     */
// Initialise isEmpty check
    static boolean isEmpty;

    /**
     * Instantiates a new Game player.
     *
     * @param userName           the username
     * @param playerHealth       the player health
     * @param playerAttackPower  the player attack power
     * @param playerDefencePower the player defense power
     */
// Creating the player
    public gamePlayer(String userName, int playerHealth, int playerAttackPower, int playerDefencePower) {
        this.userName = userName;
        this.playerHealth = playerHealth;
        this.playerAttackPower = playerAttackPower;
        this.playerDefencePower = playerDefencePower;

        this.equippedArmour = new gameArmourItems("None", "No armour equipped", 0, 0, false, 0);
        this.equippedWeapon = new gameWeaponItems("None", "No weapon equipped", 0, 0, false, 0);
    }

    /**
     * Attack.
     *
     * @param enemy the enemy
     */
// Attack Power
    public void attack(gameEnemy enemy) {
        System.out.println(userName + " attacks " + enemy.entityName + " for " + playerAttackPower + " damage!");
        enemy.entityHealth -= playerAttackPower;
        System.out.println("You have " + playerHealth + "HP.");
    }

    /**
     * Take damage.
     *
     * @param damage the damage
     */
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

    /**
     * Equip weapon.
     *
     * @param weapon the weapon
     */
// Equip weapon
    public static void equipWeapon(gameWeaponItems weapon) {
        System.out.println("Unequipped: " + equippedWeapon.getItemName());
        playerAttackPower -= equippedWeapon.getItemAtk();

        equippedWeapon = weapon;
        playerAttackPower += weapon.getItemAtk();

        System.out.println("Equipped weapon: " + weapon.getItemName());
    }

    /**
     * Equip armour.
     *
     * @param armour the armour
     */
// Equip armour
    public static void equipArmour(gameArmourItems armour) {
        System.out.println("Unequipped: " + equippedArmour.getItemName());
        playerDefencePower -= equippedArmour.getItemDef();

        equippedArmour = armour;
        playerDefencePower += armour.getItemDef();

        System.out.println("Equipped armour: " + armour.getItemName());
    }


    /**
     * Equip item by name.
     *
     * @param itemName the item name
     */
    public  void equipItemByName(String itemName) {
        for (gameItems item : playerInventory) {
            if (item instanceof Equipable && item.getItemName().equalsIgnoreCase(itemName)) {
                ((Equipable) item).equip(this); // Cast is still needed

                return;
            }

        }
        System.out.println("Equipment named '" + itemName + "' not found in inventory or not equippable.");
    }


    /**
     * player is alive boolean.
     *
     * @return the boolean
     */
//Check if player has more than 0 HP
    public boolean isAlive() {
        return playerHealth > 0;
    }

    /**
     * The interface Equipable.
     */
    public interface Equipable {
        /**
         * Equip.
         *
         * @param player the player
         */
        void equip(gamePlayer player);
    }

    /**
     * Add item.
     *
     * @param gameItems the game items
     */
//add an item to the players inventory when dropped or bought
    public static void addItem(gameItems gameItems) {
        if (playerInventory.size() < 8) {
            playerInventory.add(gameItems);
        } else {
            System.out.println("Inventory full!");
            return;
        }
        System.out.println("You received: " + gameItems);
    }

    /**
     * Remove item.
     *
     * @param gameItems the game items
     */
// Remove
    public static void removeItem(int gameItems) {
        playerInventory.remove(gameItems);
    }

    /**
     * Player stat.
     */
    public static void playerStat() {
        System.out.printf("Current ATK: %d\nCurrent HP: %d\nCurrent DEF: %d\n", playerAttackPower, playerHealth, playerDefencePower);
        System.out.println("Equipped Weapon: " + equippedWeapon.getItemName() + " (ATK: " + equippedWeapon.getItemAtk() + ")");
        System.out.println("Equipped Armour: " + equippedArmour.getItemName() + " (DEF: " + equippedArmour.getItemDef() + ")");
    }

    /**
     * Show inventory.
     */
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

    /**
     * Gets player spirit coins.
     *
     * @return the player spirit coins
     */
    public static int getPlayerSpiritCoins() {
        return playerSpiritCoins;
    }

    /**
     * Sets player spirit coins.
     *
     * @param newPlayerSpiritCoins the new player spirit coins
     */
    public static void setPlayerSpiritCoins(int newPlayerSpiritCoins) {
        playerSpiritCoins = newPlayerSpiritCoins;
    }

    /**
     * Gets is empty.
     *
     * @return the is empty
     */
    public static boolean getIsEmpty() {
        return isEmpty;
    }

    /**
     * Gets player inventory.
     *
     * @return the player inventory
     */
    public static ArrayList<gameItems> getPlayerInventory() {
        return playerInventory;
    }

    /**
     * Player stats.
     */
    public static void playerStats() {
        System.out.printf("Current ATK: %d\nCurrent HP: %d\nCurrent DEF: %d\n", playerAttackPower, playerHealth, playerDefencePower);
    }

    /**
     * Gets player health.
     *
     * @return the player health
     */
    public static int getPlayerHealth() {
        return playerHealth;
    }

    /**
     * Sets player health.
     *
     * @param HP the hp
     */
    public static void setPlayerHealth(int HP) {
        playerHealth = HP;
    }

    /**
     * Gets player attack power.
     *
     * @return the player attack power
     */
    public static int getPlayerAttackPower() {
        return playerAttackPower;
    }

    /**
     * Sets player attack power.
     *
     * @param ATK the atk
     */
    public static void setPlayerAttackPower(int ATK) {
        playerAttackPower = ATK;
    }

    /**
     * Gets player defense power.
     *
     * @return the player defense power
     */
    public static int getPlayerDefencePower() {
        return playerDefencePower;
    }

    /**
     * Sets player defense power.
     *
     * @param DEF the def
     */
    public static void setPlayerDefencePower(int DEF) {
        playerDefencePower = DEF;
    }

}