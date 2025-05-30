package data;
import java.util.ArrayList;
import java.util.Random;

/**@author Danny Suy  */
/**@Ver 1.3           */
/**@Date 26/05/25     */

public class gameEnemy {
    String entityName;
    int entityHealth;
    int entityAttackPower;
    gameItems dropItem;
    int dropChance;

    // Enemy Creation
    public gameEnemy(String entityName, int entityHealth, int entityAttackPower, gameItems dropItem, int dropChance) {
        this.entityName = entityName;
        this.entityHealth = entityHealth;
        this.entityAttackPower = entityAttackPower;
        this.dropItem = dropItem;
        this.dropChance = dropChance;

    }

    // Attack method
    public void attack(gamePlayer player) {
        System.out.println(entityName + " attacks " + player.userName + " for " + entityAttackPower + " damage!");
        player.takeDamage(entityAttackPower);
        System.out.println(entityName + " have " + entityHealth + "HP.");
    }

    public boolean isAlive() {
        return entityHealth > 0;
    }

    public class enemyPool {
        static ArrayList<gameEnemy> commonEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> locationOneEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> locationTwoEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> eliteEnemies = new ArrayList<>();
        static ArrayList<gameEnemy> bossEnemies = new ArrayList<>();

        // Intialise state of each Pool
        static boolean commonPoolState = true;
        static boolean locationPoolOneState = true;
        static boolean locationPoolTwoState = true;
        static boolean elitePoolState = true;
        static boolean bossPoolState = true;

        static {
            //Common enemies
            commonEnemies.add(new gameEnemy("Kappa", 10, 3, , 10));
            commonEnemies.add(new gameEnemy("Ashi-magari", 12, 5, gameWeaponItems, 15));
            commonEnemies.add(new gameEnemy("Ayakashi", 14, 6));
            commonEnemies.add(new gameEnemy("Jibakurei", 15, 4));

            //Location 1 based enemies
            locationOneEnemies.add(new gameEnemy("Chimimōryō", 15, 6));
            locationOneEnemies.add(new gameEnemy("Ayakashi V2", 19, 9));
            locationOneEnemies.add(new gameEnemy("Jibakurei BIG BROTHER", 20, 8));

            //Location 2 based enemies
            locationTwoEnemies.add(new gameEnemy("Chimimōryō", 15, 6));
            locationTwoEnemies.add(new gameEnemy("Ayakashi V2", 19, 9));
            locationTwoEnemies.add(new gameEnemy("Jibakurei BIG BROTHER", 20, 8));

            //Elite enemies
            eliteEnemies.add(new gameEnemy("Kitsune", 23, 11));

            //Boss enemies
            bossEnemies.add(new gameEnemy("Ronin", 75, 20));
        }

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
        //Create a drop loot from enemies
        public void dropLoot(gamePlayer player) {
            //Roll between 1-100 to see whether enemies drop something or not
            Random rand = new Random();
            int roll = rand.nextInt(100) + 1;

            if (roll <= dropChance && !dropItem.getItemName().equalsIgnoreCase("No Drop")) {
                System.out.println(entityName + " dropped: " + dropItem.getItemName());
                player.addItem(dropItem);
            } else {
                System.out.println(entityName + " dropped nothing.");
            }
        }

        //Grab random enemy from different category
        public static gameEnemy getRandomCommon() {
            return getRandomFromList(commonEnemies);
        }

        public static gameEnemy getRandomOneLocation() {
            return getRandomFromList(locationOneEnemies);
        }

        public static gameEnemy getRandomTwoLocation() {
            return getRandomFromList(locationTwoEnemies);
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
        
        public static boolean getLocationOnePoolState() {
            return locationPoolOneState;
        }

        public static boolean getLocationTwoPoolState() {
            return locationPoolTwoState;
        }

        public static boolean getElitePoolsState() {
            return elitePoolState;
        }

        public static boolean getLocationBossState() {
            return bossPoolState;
        }

    }
}
