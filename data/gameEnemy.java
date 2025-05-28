/**@author Danny Suy  */
/**@Ver 1.0           */
/**@Date 26/05/25     */

public class gameEnemy {
    String name;
    int health;
    int attackPower;

    // Constructor
    public gameEnemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // Attack method
    public void attack(gamePlayer player) {
        System.out.println(name + " attacks " + player.name + " for " + attackPower + " damage!");
        player.takeDamage(attackPower);
    }

    public boolean isAlive() {
        return health > 0;
    }
}
