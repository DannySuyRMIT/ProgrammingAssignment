package data;

/**@author Christian Rayos */
/**@Ver 1.2               */
/**@Date 25/05/25        */

public class gameItems {
    private String itemName;
    private final String toolTip;
    private int itemQty;
    private double itemCost;
    private final String itemType;
    private boolean canSell = true;


    public gameItems(String itemName, String toolTip, int itemQty, double itemCost, String itemType, boolean canSell) {
        this.itemName = itemName;
        this.toolTip = toolTip;
        this.itemQty = itemQty;
        this.itemCost = itemCost;
        this.itemType = itemType;
        this.canSell = canSell;

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

    public double getItemCost() {
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

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public String toString() {
        return String.format("%dX\t%s\t$%.2f", this.itemQty, this.itemName, this.itemCost);
    }
}

