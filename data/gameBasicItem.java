package data;
/**@author Christian Rayos */
/**@Ver 1.0              */

/**
 * The type Game items.
 *
 * @Date 25 /05/25
 */
/**
 * The type Game basic item.
 */
public class gameBasicItem extends gameItems {
    /**
     * Instantiates a new Game basic item.
     *
     * @param itemName the item name
     * @param toolTip  the tool tip
     * @param itemQty  the item qty
     * @param itemCost the item cost
     * @param itemType the item type
     * @param canSell  the can sell
     */
    public gameBasicItem(String itemName, String toolTip, int itemQty,int itemCost, String itemType, boolean canSell) {
        super(itemName,toolTip,itemQty,itemCost,itemType, canSell);
    }

    @Override
    public gameItems copy() {
        return new gameBasicItem(getItemName(),getToolTip(),getItemQty(),getItemCost(),getItemType(),getCanSell());
    }
}
