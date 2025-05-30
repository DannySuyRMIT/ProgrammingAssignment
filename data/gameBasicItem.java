package data;

public class gameBasicItem extends gameItems {
    public gameBasicItem(String itemName, String toolTip, int itemQty,int itemCost, String itemType, boolean canSell) {
        super(itemName,toolTip,itemQty,itemCost,itemType, canSell);
    }

    @Override
    public gameItems copy() {
        return new gameBasicItem(getItemName(),getToolTip(),getItemQty(),getItemCost(),getItemType(),getCanSell());
    }
}
