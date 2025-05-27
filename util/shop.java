package util;
import core.gameCore;
import data.gameItems;
import java.util.ArrayList;

/**@author Christian Rayos */
/**@Ver 2.1               */
/**@Date 26/05/25        */

public class shop {
    // Initialise temporary value of spiritCoins || remove later
    static double spiritCoins = 20.00;
    // Initialise shopInventory
    private static ArrayList<gameItems> shopInventory = populateShopInventory();

    // Initialise
    static String userChoice;

    public static ArrayList<gameItems> populateShopInventory() {
        shopInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]                   itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable]
        // Weapons
        shopInventory.add(new gameItems("dagger","Mildly pointy. Inflicts Bleed.",1,2.5,"Weapon",true));
        shopInventory.add(new gameItems("dull blade","Not so sharp... still better than nothing.",1,3.5,"Weapon",true));
        shopInventory.add(new gameItems("not-so-dull blade","Decently sharpened. Good for a fight.",1,5.0,"Weapon",true));
        shopInventory.add(new gameItems("scam blade","Dull blade repainted...'are they trying to scam us? '",1,8.0,"Weapon",true));
        // Armour
        shopInventory.add(new gameItems("dull steel helmet","A bit worn, but stops you from losing your head.",1,6.0,"Armour",true));
        shopInventory.add(new gameItems("dull steel breastplate","Has some dents, but you'll live. Maybe.",1,12.0,"Armour",true));
        shopInventory.add(new gameItems("dull steel leggings","Bit difficult to move in, but still protects.",1,8.0,"Armour",true));
        shopInventory.add(new gameItems("dull steel boots","You might trip, so don't do that.",1,4.0,"Armour",true));
        // Utility
        shopInventory.add(new gameItems("pebble","A small stone... might trip your foe",3,2.0,"Usable",true));
        shopInventory.add(new gameItems("red potion","Wonders of alchemy... tastes bitter, but heals you. grants 15HP.",5,4.0,"Usable",true));
        return shopInventory;
    }

    public static void gameBuy () {

        System.out.printf("Available spirit coins: $%.2f\n",spiritCoins); //Place playerCoin here
        System.out.print("- - -Items for sale- - -\n");
        viewShopItems();

        if (gameCore.isMapUnlocked() == false) { // Check if map has been unlocked, and if not, display option.
            System.out.print("\nIt seems you can also purchase the following:\n");
            System.out.print("map $5.00\n");

        }
        itemPurchase();
    }

    public static void shopSell() {
        System.out.print("Select item to sell\n");
        // Do later
    }

    public static void shopDialogue() {
        System.out.print("welcome to shop\n");
        System.out.print("Would you like to buy some wares? or... perhaps\n you'd like to sell some and try gambling...?\n");
        System.out.print("[sell]    [buy]    [exit]\n");
        String userChoice = userScanner.userScan();

        if (userChoice.equals("sell")) {
            shopSell();
        } else if (userChoice.equals("buy")) {
            gameBuy();
        } else if(userChoice.equals("exit")) {
            System.out.print("\nGoodbye. See you next time!");
        } else {
            System.out.print("\nYour intentions aren't understood. You are kicked out for now...\n");
        }
    }

    public static void itemPurchase() {
        String userChoice = userScanner.userScan();
        if (gameCore.isMapUnlocked() == false && userChoice.equals("map")) {
            if (spiritCoins >= 5.0) {
                spiritCoins -=  5.0;
                gameCore.unlockMap();
            } else {
                System.out.print("You do not have enough spirit Coins\n");
            }
        } else if (userChoice.equals("map")) {
            System.out.print("map already unlocked. Why you Trying?\n Select another item.");
            userChoice = userScanner.userScan();
        } else if (!userChoice.equals("map")) {
            String itemSelect = userChoice;
            boolean itemFound = false; //flags whether item is found
            double shopCost = 0.00; // Assigns purchase cost to 0 whenever shop is visited
            int index = 0;
            int itemQty = 0;
            int inventoryIndex = 0; // Checks to see if item exists within Inventory. Should it exist, +1 to qty.
            boolean inventoryFlag = false; // Used alongside inventoryIndex, only as a flag.

            for (int i = 0; i < shopInventory.size(); i++) {
                if (itemSelect.equals(shopInventory.get(i).getItemName())) {
                    itemFound = true;
                    shopCost = shopInventory.get(i).getItemCost();
                    index = i;
                    itemQty = shopInventory.get(i).getItemQty();
                }
            }

            if (itemFound && spiritCoins >= shopCost && itemQty > 0) {
                System.out.printf("\n%s costs: $%.2f. You have $%.02f. Purchase?\n[Y] / [N]\n", itemSelect, shopCost, spiritCoins);
                userChoice = userScanner.userScan();

                switch (userChoice) {
                    case "y":
                        System.out.println("Item Purchased.\n");
                        // Search inventory || Section commented out until Connected with Inventory
//                    for (int i = 0; i < inventory.size(); i++) {
//                         if (itemSelect.equals(inventory.get(i).getItemName())) ;
//                             inventoryIndex = 1;
//                             inventoryFlag = true;
//                        }
//                    }
//                    if(inventoryFlag == true) { // Runs following only when Item exists within Inventory. +1 to item.
//                        inventory.get(inventoryIndex).setQty(inventory.get(inventoryIndex).getQty()+1);
//                    } else { // should item not exist, add to inventory
//                        inventory.add(new gameItems(itemSelect, ,1, shopCost));
//                    }
//                    spiritCoins -= shopCost;
//                    shopInventory.get(index).setItemQty(shopInventory.get(index).getItemQty()-1);
                        break;


                    case "n":
                        System.out.println("What a buzzkill... Go away.\n");
                        break;
                    default:
                        System.out.print("Please decide consciously\n");
                        break;
                }

            } else if (itemFound && spiritCoins < shopCost) {
                System.out.println("Not enough coins... come back richer?");
            } else if (itemFound = false || itemQty == 0) {
                System.out.print("item " + itemSelect + " not available.\n");
            }
            System.out.print("Taking too long caused you to be kicked out for now...\n\n");
        }
    }

    public static void shopGamble() {
    // Do later
    } public static void viewShopItems() {
        for (int i = 0; i < shopInventory.size(); i++) {
            System.out.println("["+i+"]"+shopInventory.get(i).toString());
        }
    }
}
