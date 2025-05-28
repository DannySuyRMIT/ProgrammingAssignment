package data;

/**@author Danny Suy  */
/**@Ver 1.0           */
/**@Date 26/05/25     */

public class gameEnemy {
    String entityName;
    int entityHealth;
    int entityAttackPower;

    // Constructor
    public gameEnemy(String entityName, int entityHealth, int entityAttackPower) {
        this.entityName = entityName;
        this.entityHealth = entityHealth;
        this.entityAttackPower = entityAttackPower;
    }

    // Attack method
    public void attack(gamePlayer player) {
        System.out.println(entityName + " attacks " + player.userName + " for " + entityAttackPower + " damage!");
        player.takeDamage(entityAttackPower);
    }

    public boolean isAlive() {
        return entityHealth > 0;
    }
}
