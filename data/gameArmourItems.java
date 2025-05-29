package data;

/**@author Christian Rayos */
/**@Ver 1.0               */
/**@Date 27/05/25        */

public class gameArmourItems extends gameItems{
    private int itemDef;

    public gameArmourItems (String itemName, String toolTip, int itemQty, int itemCost, boolean canSell, int itemDef) {
        super(itemName, toolTip, itemQty, itemCost, "Amour", canSell); // Obtains parameters from gameItems
        this.itemDef = itemDef;
    }

    public int getItemDef() {
        return itemDef;
    }
}
