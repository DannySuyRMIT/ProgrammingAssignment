package data;

/**@author Christian Rayos */
/**@Ver 1.0               */
/**@Date 27/05/25        */

public class gameWeaponItems extends gameItems {
    private int itemAtk;

    public gameWeaponItems(String itemName, String toolTip, int itemQty, int itemCost, boolean canSell, int itemAtk) {
        super(itemName,toolTip,itemQty, itemCost,"Weapon", canSell); // Obtains Parameters from gameItems
        this.itemAtk = itemAtk;
    }

    public int getItemAtk() { //
        return itemAtk;
    }

}
