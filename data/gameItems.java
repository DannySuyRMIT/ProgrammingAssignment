package data;
import java.util.ArrayList;

/**@author Christian Rayos */
/**@Ver 2.0               */

/**
 * The type Game items.
 *
 * @Date 25 /05/25
 */
public abstract class gameItems {
    private String itemName;
    private String toolTip;
    private int itemQty;
    private int itemCost;
    /**
     * The Item type.
     */
    public String itemType;
    /**
     * The Can sell.
     */
    public boolean canSell = true;


    /**
     * Instantiates a new Game items.
     *
     * @param itemName the item name
     * @param toolTip  the tool tip
     * @param itemQty  the item qty
     * @param itemCost the item cost
     * @param itemType the item type
     * @param canSell  the can sell
     */
    public gameItems(String itemName, String toolTip, int itemQty, int itemCost, String itemType, boolean canSell) {
        this.itemName = itemName;
        this.toolTip = toolTip;
        this.itemQty = itemQty;
        this.itemCost = itemCost;
        this.itemType = itemType;
        this.canSell = canSell;

    }

    /**
     * Copy game items.
     *
     * @return the game items
     */
    public abstract gameItems copy();


    /**
     * Instantiates a new Game items.
     *
     * @param shopToBackpack the shop to backpack
     */
// Copies index contents, and pasts it into another parameter field
    public gameItems(gameItems shopToBackpack) {
        this.itemName = shopToBackpack.getItemName();
        this.toolTip = shopToBackpack.getToolTip();
        this.itemQty = shopToBackpack.getItemQty();
        this.itemCost = shopToBackpack.getItemCost();
        this.itemType = shopToBackpack.getItemType();
        this.canSell = shopToBackpack.getCanSell();

    }

    /**
     * Gets item name.
     *
     * @return the item name
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Gets tool tip.
     *
     * @return the tool tip
     */
    public String getToolTip() {
        return this.toolTip;
    }

    /**
     * Gets item qty.
     *
     * @return the item qty
     */
    public int getItemQty() {
        return this.itemQty;
    }

    /**
     * Gets item cost.
     *
     * @return the item cost
     */
    public int getItemCost() {
        return this.itemCost;
    }

    /**
     * Gets item type.
     *
     * @return the item type
     */
    public String getItemType() {
        return this.itemType;
    }

    /**
     * Gets can sell.
     *
     * @return the can sell
     */
    public boolean getCanSell() {
        return canSell;
    }

    /**
     * Sets item name.
     *
     * @param itemName the item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Sets item qty.
     *
     * @param itemQty the item qty
     */
    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    /**
     * Sets item cost.
     *
     * @param itemCost the item cost
     */
    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }


    public String toString() {
        return String.format("%dX\t%s\t$%d", this.itemQty, this.itemName, this.itemCost);
    }
}

