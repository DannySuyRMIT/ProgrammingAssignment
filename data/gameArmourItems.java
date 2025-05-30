package data;

/**@author Christian Rayos */

/**
 * The type Game armour items.
 * @Date 27 /05/25
 *
 */
/**@Ver 1.0               */


public class gameArmourItems extends gameItems implements gamePlayer.Equipable {
    private int itemDef;

    /**
     * Instantiates a new Game armour items.
     *
     * @param itemName the item name
     * @param toolTip  the tool tip
     * @param itemQty  the item quantity
     * @param itemCost the item cost
     * @param canSell  the item can sell
     * @param itemDef  the item def
     */
    public gameArmourItems (String itemName, String toolTip, int itemQty, int itemCost, boolean canSell, int itemDef) {
        super(itemName, toolTip, itemQty, itemCost, "Armour", canSell); // Obtains parameters from gameItems
        this.itemDef = itemDef;
    }

    @Override
    public void equip(gamePlayer player) {
        player.equipArmour(this);
    }

    @Override
    public gameItems copy() {
        return new gameArmourItems(getItemName(),getToolTip(),getItemQty(),getItemCost(),getCanSell(),getItemDef());
    }

    /**
     * Gets item def.
     *
     * @return the item def
     */
    public int getItemDef() {
        return itemDef;
    }

    public String toString () {
        return String.format("%dX\t%s \t%s\tDEF: %d",this.getItemQty(), this.getItemName(), this.getToolTip(), this.getItemDef());
    }
}
