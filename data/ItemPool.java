package data;

import java.util.ArrayList;

/**@author Christian Rayos */
/**@Ver 1.0               */

/**
 * The type Game items.
 *
 * @Date 30 /05/25
 */
/**
 * The type Item pool.
 */
public class ItemPool {

    private static ArrayList<gameItems> worldInventory = populateWorldInventory();

    // Initialise world Items

    /**
     * Populate world inventory array list.
     *
     * @return the array list
     */
    public static ArrayList<gameItems> populateWorldInventory() {
        worldInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        worldInventory.add(new gameWeaponItems("blessed katana","Very sharp. Will easily down a foe",1,0,true,10));
        worldInventory.add(new gameArmourItems("pendant","Seems to be embued with some holy energy. Will weaken enemy atk.",1,0,true,10));
        worldInventory.add(new gameArmourItems("Samurai set","Extremely well maintained",1,0,true,22));

        return worldInventory; // can be obtained from gameLocations
    }


    // Initialise dropInventory
    private static ArrayList<gameItems> dropInventory = populatedropField();

    /**
     * Populatedrop field array list.
     *
     * @return the array list
     */
    public static ArrayList<gameItems> populatedropField() {
        dropInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        dropInventory.add(new gameWeaponItems("dagger", "Mildly pointy. Inflicts Bleed.", 50, 2, true, 2));
        dropInventory.add(new gameWeaponItems("dull blade", "Not so sharp... still better than nothing.", 5, 3, true, 3));
        dropInventory.add(new gameWeaponItems("not-so-dull blade", "Decently sharpened. Good for a fight.", 2, 5, true, 5));
        dropInventory.add(new gameWeaponItems("scam blade", "Dull blade repainted...'are they trying to scam us? '", 10, 8, true, 3));
        // Armour
        dropInventory.add(new gameArmourItems("dull armour set", "A bit worn, but stops you from losing your head.", 1, 14, true, 14));
        // Utility
        dropInventory.add(new gameBasicItem("pebble", "A small stone... might trip your foe", 25, 2, "Usable", false));
        dropInventory.add(new gameBasicItem("red potion", "Wonders of alchemy... tastes bitter, but heals you. grants 15HP.", 12, 4, "Usable", true));
        return dropInventory;
    }
}
