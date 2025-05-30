package data;
import java.util.ArrayList;
import java.util.Random;

/**@author Danny Suy  */

/**
 * The type Game enemy.
 *
 * @Date 26 /05/25
 */
/**@Ver 1.5           */


public class gameEnemy {
    /**
     * The Entity name.
     */
    String entityName;
    /**
     * The Entity health.
     */
    int entityHealth;
    /**
     * The Entity attack power.
     */
    int entityAttackPower;
    /**
     * The Drop chance.
     */
    int dropChance;

    /**
     * Instantiates a new Game enemy.
     *
     * @param entityName        the entity name
     * @param entityHealth      the entity health
     * @param entityAttackPower the entity attack power
     * @param dropChance        the drop chance
     */
// Enemy Creation
    public gameEnemy(String entityName, int entityHealth, int entityAttackPower, int dropChance) {
        this.entityName = entityName;
        this.entityHealth = entityHealth;
        this.entityAttackPower = entityAttackPower;
        this.dropChance = dropChance;

    }

    /**
     * Gets drop chance.
     *
     * @return the drop chance
     */
    public int getDropChance() {
        return dropChance;
    }

    /**
     * Attack.
     *
     * @param player the player
     */
// Attack method
    public void attack(gamePlayer player) {
        System.out.println(entityName + " attacks " + player.userName + " for " + entityAttackPower + " damage!");
        player.takeDamage(entityAttackPower);
        System.out.println(entityName + " have " + entityHealth + "HP.");
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return entityHealth > 0;
    }

    /**
     * The type Enemy pool.
     */
    public class enemyPool {
        /**
         * The Common enemies.
         */
        static ArrayList<gameEnemy> commonEnemies = new ArrayList<>();
        /**
         * The Location one enemies.
         */
        static ArrayList<gameEnemy> locationOneEnemies = new ArrayList<>();
        /**
         * The Location two enemies.
         */
        static ArrayList<gameEnemy> locationTwoEnemies = new ArrayList<>();
        /**
         * The Elite enemies.
         */
        static ArrayList<gameEnemy> eliteEnemies = new ArrayList<>();
        /**
         * The Boss enemies.
         */
        static ArrayList<gameEnemy> bossEnemies = new ArrayList<>();

        /**
         * The constant commonPoolState.
         */
// Intialise state of each Pool
        static boolean commonPoolState = true;
        /**
         * The Location pool one state.
         */
        static boolean locationPoolOneState = true;
        /**
         * The Location pool two state.
         */
        static boolean locationPoolTwoState = true;
        /**
         * The Elite pool state.
         */
        static boolean elitePoolState = true;
        /**
         * The Boss pool state.
         */
        static boolean bossPoolState = true;

        static {
            //Common enemies
            commonEnemies.add(new gameEnemy("Kappa", 10, 3, 10));
            commonEnemies.add(new gameEnemy("Ashi-magari", 12, 5, 15));
            commonEnemies.add(new gameEnemy("Ayakashi", 14, 6, 17));
            commonEnemies.add(new gameEnemy("Jibakurei", 15, 4, 20));

            //Location 1 based enemies
            locationOneEnemies.add(new gameEnemy("Chimimōryō", 15, 6, 20));
            locationOneEnemies.add(new gameEnemy("Ayakashi V2", 19, 9, 25));
            locationOneEnemies.add(new gameEnemy("Jibakurei BIG BROTHER", 20, 8, 30));

            //Location 2 based enemies
            locationTwoEnemies.add(new gameEnemy("Chimimōryō", 15, 6, 22));
            locationTwoEnemies.add(new gameEnemy("Rokurokubi", 19, 9, 24));
            locationTwoEnemies.add(new gameEnemy("Oni", 20, 8,28));

            //Elite enemies
            eliteEnemies.add(new gameEnemy("Kitsune", 40, 11, 45));

            //Boss enemies
            bossEnemies.add(new gameEnemy("Ronin", 75, 20, 100));
        }

        /**
         * Disable enemy pool.
         *
         * @param poolName the pool name
         */
        public static void disableEnemyPool(String poolName) {
            switch (poolName) {
                case "commonEnemies":
                    break;
                case "locationOneEnemies":
                    locationPoolOneState = false;
                    break;
                case "locationTwoEnemies":
                    locationPoolTwoState = false;
                    break;
                case "eliteEnemies":
                    elitePoolState = false;
                    break;
                case "bossEnemies":
                    bossPoolState = false;
                    break;
            }
        }

        /**
         * Gets random common.
         *
         * @return the random common
         */
//Grab random enemy from different category
        public static gameEnemy getRandomCommon() {
            return getRandomFromList(commonEnemies);
        }

        /**
         * Gets random one location.
         *
         * @return the random one location
         */
        public static gameEnemy getRandomOneLocation() {
            return getRandomFromList(locationOneEnemies);
        }

        /**
         * Gets random two location.
         *
         * @return the random two location
         */
        public static gameEnemy getRandomTwoLocation() {
            return getRandomFromList(locationTwoEnemies);
        }

        /**
         * Gets random elite.
         *
         * @return the random elite
         */
        public static gameEnemy getRandomElite() {
            return getRandomFromList(eliteEnemies);
        }

        /**
         * Gets random boss.
         *
         * @return the random boss
         */
        public static gameEnemy getRandomBoss() {
            return getRandomFromList(bossEnemies);
        }

        private static gameEnemy getRandomFromList(ArrayList<gameEnemy> list) {
            if (list.isEmpty()) return null;
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }

        /**
         * Gets location one pool state.
         *
         * @return the location one pool state
         */
        public static boolean getLocationOnePoolState() {
            return locationPoolOneState;
        }

        /**
         * Gets location two pool state.
         *
         * @return the location two pool state
         */
        public static boolean getLocationTwoPoolState() {
            return locationPoolTwoState;
        }

        /**
         * Gets elite pools state.
         *
         * @return the elite pools state
         */
        public static boolean getElitePoolsState() {
            return elitePoolState;
        }

        /**
         * Gets location boss state.
         *
         * @return the location boss state
         */
        public static boolean getLocationBossState() {
            return bossPoolState;
        }


    } public String toString() {
        return String.format("    Entity: %s\nCurrent HP: %d  |Current ATK: %d",entityName,entityHealth,entityAttackPower);
    }
}
