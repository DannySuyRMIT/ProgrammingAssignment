package data;

/**@author Christian Rayos */
/**@Ver 1.3               */
/**@Date 25/05/25        */

public class gameItems {
    private String itemName;
    private String toolTip;
    private int itemQty;
    private int itemCost;
    private String itemType;
    private boolean canSell = true;


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

