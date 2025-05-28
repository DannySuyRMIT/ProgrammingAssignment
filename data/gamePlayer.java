/**@author Danny Suy  */
/**@Ver 1.1           */
/**@Date 28/05/25     */

public class gamePlayer {
    String name;
    int health;
    int attackPower;
    int coins = 50; 
    String item1 = "";
    String item2 = "";
    String item3 = "";
    String item4 = "";
    String item5 = "";
    String item6 = "";
    String item7 = "";
    String item8 = "";



    // Creating the player
    public gamePlayer(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Attack Power
    public void attack(gameEnemy enemy) {
        System.out.println(name + " attacks " + enemy.name + " for " + attackPower + " damage!");
        enemy.health -= attackPower;
    }

    // Take damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            System.out.println(name + " is defeated!");
        }
    }

    //Check if player has more than 0 HP
    public boolean isAlive() {
        return health > 0;
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
        System.out.println("Coins: " + coins);
        if (!item1.equals("")) System.out.println("- " + item1);
        if (!item2.equals("")) System.out.println("- " + item2);
        if (!item1.equals("")) System.out.println("- " + item3);
        if (!item2.equals("")) System.out.println("- " + item4);
        if (!item1.equals("")) System.out.println("- " + item5);
        if (!item2.equals("")) System.out.println("- " + item6);
        if (!item1.equals("")) System.out.println("- " + item7);
        if (!item2.equals("")) System.out.println("- " + item8);
        if (item1.equals("") && item2.equals("")) System.out.println("Inventory is empty.");
    }
}

