package data;

/**@author Christian Rayos */
/**@Ver 1.3               */

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

    public String toString() {
        return String.format("%dX\t%s\t$%d", this.itemQty, this.itemName, this.itemCost);
    }
}

