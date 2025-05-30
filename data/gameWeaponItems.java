package data;

/**@author Christian Rayos */

/**
 * The type Game weapon items.
 *
 * @Date 27 /05/25
 */
/**@Ver 2.0               */


public class gameWeaponItems extends gameItems implements gamePlayer.Equipable {
    private int itemAtk;

    /**
     * Instantiates a new Game weapon items.
     *
     * @param itemName the item name
     * @param toolTip  the tool tip
     * @param itemQty  the item qty
     * @param itemCost the item cost
     * @param canSell  item that can sell
     * @param itemAtk  the item atk
     */
    public gameWeaponItems (String itemName, String toolTip, int itemQty, int itemCost, boolean canSell, int itemAtk) {
        super(itemName, toolTip, itemQty, itemCost, "Armour", canSell); // Obtains Parameters from gameItems
        this.itemAtk = itemAtk;
    }

    @Override
    public void equip(gamePlayer player) {
        player.equipWeapon(this);
    }

    @Override
    public gameItems copy() {
        return new gameWeaponItems(getItemName(),getToolTip(),getItemQty(),getItemCost(),getCanSell(),getItemAtk());
    }

    /**
     * Gets item attack.
     *
     * @return the item attack
     */
    public int getItemAtk() { //
        return itemAtk;
    }

    public String toString () {
        return String.format("%dX\t%s \t%s\tATK: %d",this.getItemQty(), this.getItemName(), this.getToolTip(), this.getItemAtk());
    }
}
