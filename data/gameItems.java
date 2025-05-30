package data;

/**@author Christian Rayos */
/**@Ver 1.4               */

import java.util.ArrayList;

/**@Date 25/05/25        */

public class gameItems {
    private String itemName;
    private String toolTip;
    private int itemQty;
    private int itemCost;
    public String itemType;
    public boolean canSell = true;


    public gameItems(String itemName, String toolTip, int itemQty, int itemCost, String itemType, boolean canSell) {
        this.itemName = itemName;
        this.toolTip = toolTip;
        this.itemQty = itemQty;
        this.itemCost = itemCost;
        this.itemType = itemType;
        this.canSell = canSell;

    }



    // Copies index contents, and pasts it into another parameter field
    public gameItems(gameItems shopToBackpack) {
        this.itemName = shopToBackpack.getItemName();
        this.toolTip = shopToBackpack.getToolTip();
        this.itemQty = shopToBackpack.getItemQty();
        this.itemCost = shopToBackpack.getItemCost();
        this.itemType = shopToBackpack.getItemType();
        this.canSell = shopToBackpack.getCanSell();

    }
    private static ArrayList<gameItems> worldInventory = populateWorldInventory();

    // Initialise world Items

    public static ArrayList<gameItems> populateWorldInventory() {
        worldInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        worldInventory.add(new gameWeaponItems("blessed katana","Very sharp. Will easily down a foe",1,0,true,10));
        worldInventory.add(new gameArmourItems("pendant","Seems to be embued with some holy energy. Will weaken enemy atk.",1,0,true,10));

        return worldInventory; // can be obtained from gameLocations
    }

    private static ArrayList<gameItems> dropInventory = populatedropField();

    public static ArrayList<gameItems> populatedropField() {
        dropInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        dropInventory.add(new gameWeaponItems("dagger","Mildly pointy. Inflicts Bleed.",50,2,true,2));
        dropInventory.add(new gameWeaponItems("dull blade","Not so sharp... still better than nothing.",5,3,true,3));
        dropInventory.add(new gameWeaponItems("not-so-dull blade","Decently sharpened. Good for a fight.",2,5,true, 5));
        dropInventory.add(new gameWeaponItems("scam blade","Dull blade repainted...'are they trying to scam us? '",10,8,true,3));
        // Armour
        dropInventory.add(new gameArmourItems("dull steel helmet","A bit worn, but stops you from losing your head.",1,6,true,2));
        dropInventory.add(new gameArmourItems("dull steel breastplate","Has some dents, but you'll live. Maybe.",1,12,true,3));
        dropInventory.add(new gameArmourItems("dull steel leggings","Bit difficult to move in, but still protects.",1,8,true,2));
        dropInventory.add(new gameArmourItems("dull steel boots","You might trip, so don't do that.",1,4,true,1));
        // Utility
        dropInventory.add(new gameItems("pebble","A small stone... might trip your foe",25,2,"Usable",false));
        dropInventory.add(new gameItems("red potion","Wonders of alchemy... tastes bitter, but heals you. grants 15HP.",12,4,"Usable",true));
        return dropInventory;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public int getItemQty() {
        return this.itemQty;
    }

    public int getItemCost() {
        return this.itemCost;
    }

    public String getItemType() {
        return this.itemType;
    }

    public boolean getCanSell() {
        return canSell;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public static gameItems noDrop= new gameItems("No Drop", "Nothing dropped", 0, 0, "None", false);



    public String toString() {
        return String.format("%dX\t%s\t$%d", this.itemQty, this.itemName, this.itemCost);
    }
}

