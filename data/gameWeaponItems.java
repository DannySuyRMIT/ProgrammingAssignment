package data;

/**@author Christian Rayos */
/**@Ver 1.2               */
/**@Date 27/05/25        */

public class gameWeaponItems extends gameItems implements gamePlayer.Equipable {
    private int itemAtk;

    public gameWeaponItems (String itemName, String toolTip, int itemQty, int itemCost, boolean canSell, int itemAtk) {
        super(itemName, toolTip, itemQty, itemCost, "Armour", canSell); // Obtains Parameters from gameItems
        this.itemAtk = itemAtk;
    }

    @Override
    public void equip(gamePlayer player) {
        player.equipWeapon(this);
    }

    public int getItemAtk() { //
        return itemAtk;
    }

    public String toString () {
        return String.format("%dX\t%s \t%s\tATK: %d",this.getItemQty(), this.getItemName(), this.getToolTip(), this.getItemAtk());
    }
}
