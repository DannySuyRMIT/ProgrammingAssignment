package data;

/**@author Christian Rayos */
/**@Ver 1.0               */
/**@Date 27/05/25        */

public class gameArmourItems extends gameItems implements gamePlayer.Equipable {
    private int itemDef;

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

    public int getItemDef() {
        return itemDef;
    }

    public String toString () {
        return String.format("%dX\t%s \t%s\tDEF: %d",this.getItemQty(), this.getItemName(), this.getToolTip(), this.getItemDef());
    }
}
