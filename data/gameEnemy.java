package data;
import java.util.ArrayList;
import java.util.Random;

/**@author Danny Suy  */
/**@Ver 1.1           */
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

    public class enemyPool {
        static ArrayList<gameEnemy> commonEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> locationEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> eliteEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> bossEnemies = new ArrayList<>();

        static {
            //Common enemies
            commonEnemies.add(new gameEnemy("Kappa", 10, 3));
            commonEnemies.add(new gameEnemy("Ashi-magari", 12, 5));
            commonEnemies.add(new gameEnemy("Ayakashi", 14, 6));
            commonEnemies.add(new gameEnemy("Jibakurei", 15, 4));

            //Location based enemies
            locationEnemies.add(new gameEnemy("Chimimōryō", 15, 6));
            locationEnemies.add(new gameEnemy("Ayakashi V2", 19, 9));
            locationEnemies.add(new gameEnemy("Jibakurei BIG BROTHER", 20, 8));

            //Elite enemies
            eliteEnemies.add(new gameEnemy("Kitsune", 23, 11));

            //Boss enemies
            bossEnemies.add(new gameEnemy("Ronin", 75, 20));
        }

        //Grab random enemy from different category
        public static gameEnemy getRandomCommon() {
            return getRandomFromList(commonEnemies);
        }

        public static gameEnemy getRandomLocation() {
            return getRandomFromList(locationEnemies);
        }

        public static gameEnemy getRandomElite() {
            return getRandomFromList(eliteEnemies);
        }

        public static gameEnemy getRandomBoss() {
            return getRandomFromList(bossEnemies);
        }

        private static gameEnemy getRandomFromList(ArrayList<gameEnemy> list) {
            if (list.isEmpty()) return null;
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }


    }
}
