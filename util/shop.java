package util;
import core.*;
import data.*;

import java.util.ArrayList;
import java.util.Random;


/**@author Christian Rayos */
/**@Ver 3.0               */
/**@Date 26/05/25        */

public class shop {

    // Initialise shopInventory
    private static ArrayList<gameItems> shopInventory = populateShopInventory();
    private static ArrayList<gameItems> shopGambleInventory = populateGambleInventory();

    public static ArrayList<gameItems> populateShopInventory() {
        shopInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        shopInventory.add(new gameWeaponItems("dagger","Mildly pointy. Inflicts Bleed.",1,2,true,2));
        shopInventory.add(new gameWeaponItems("dull blade","Not so sharp... still better than nothing.",1,3,true,3));
        shopInventory.add(new gameWeaponItems("not-so-dull blade","Decently sharpened. Good for a fight.",1,5,true, 5));
        shopInventory.add(new gameWeaponItems("scam blade","Dull blade repainted...'are they trying to scam us? '",1,8,true,3));
        // Armour
        shopInventory.add(new gameArmourItems("dull steel helmet","A bit worn, but stops you from losing your head.",1,6,true,2));
        shopInventory.add(new gameArmourItems("dull steel breastplate","Has some dents, but you'll live. Maybe.",1,12,true,3));
        shopInventory.add(new gameArmourItems("dull steel leggings","Bit difficult to move in, but still protects.",1,8,true,2));
        shopInventory.add(new gameArmourItems("dull steel boots","You might trip, so don't do that.",1,4,true,1));
        // Utility
        shopInventory.add(new gameItems("pebble","A small stone... might trip your foe",3,2,"Usable",false));
        shopInventory.add(new gameItems("red potion","Wonders of alchemy... tastes bitter, but heals you. grants 15HP.",5,4,"Usable",true));
        return shopInventory;
    }

    /**
     *
     * @return returns Contents of shopGambleArray
     */
    public static ArrayList<gameItems> populateGambleInventory() {
        shopGambleInventory = new ArrayList<gameItems>();
        // Format                       itemName [Name]   toolTip [Description]       itemQTY [Amount] itemCost [Cost] itemType [Type] canSell [Sellable] + itemAtk / itemDef
        // Weapons
        shopGambleInventory.add(new gameWeaponItems("gilded dagger","Slightly more pointy, and more shiny. Inflicts Bleed II.",1,0,true,3));
        shopGambleInventory.add(new gameWeaponItems("gilded blade","Sharpened enough not to damage the gold. You might get robbed when using this.",1,0,true,5));

        // Utility
        shopGambleInventory.add(new gameItems("gilded pebble","A shiny pebble with flair. Twice as likely to trip your foe.",5,0,"usable",false));
        shopGambleInventory.add(new gameItems("shiny potion","better than red, but still just as bitter. Increases HP and ATK.",3,0,"usable",true));

        // Fodder
        shopGambleInventory.add(new gameItems("dirty dirt","Dirt. plain old dirt. if you sift it, you might find a nugget.",8,0,"useless",false));

        return shopGambleInventory;
    }

    public static void viewShopItems() {
        for (int i = 0; i < shopInventory.size(); i++) {
            System.out.println(" - "+shopInventory.get(i).toString());
        }
    }

    public static void gameBuy () {
        int spiritCoins = gamePlayer.getPlayerSpiritCoins();

        System.out.printf("Available spirit coins: $%d\n",spiritCoins); //Place playerCoin here
        System.out.print("- - -Items for sale- - -\n");
        viewShopItems();
        System.out.print("\nPlease select item by writing its name in full\n('pebble' or 'dull blade')\n");

        if (gameCore.isMapUnlocked() == false) { // Check if map has been unlocked, and if not, display option.
            System.out.print("\nIt seems you can also purchase the following:\n");
            System.out.print("map $5.00\n");
        }
        System.out.print("- - - - - - - - - - - -\n");
        itemPurchase();
    }

    public static void shopSell() {
        boolean isEmpty = gamePlayer.getIsEmpty();
        if (isEmpty = false) {
            System.out.print("Select item to sell\n");
            gamePlayer.getPlayerInventory();

        } else {
            System.out.print("You have nothing to sell.\nSelect something else.\n");
            System.out.print("\n    [sell] [buy] [gamble] [exit]  \n");
            String userChoice = userScanner.userScan();

            if (userChoice.equals("sell")) {
                shopSell();
            } else if (userChoice.equals("buy")) {
                gameBuy();
            } else if (userChoice.equals("gamble")) {
                shopGamble();
            }else if(userChoice.equals("exit")) {
                System.out.print("\nGoodbye. See you next time!");
            } else {
                System.out.print("\nYour intentions aren't understood. You are kicked out for now...\n");
            }
        }

    }

    public static void shopGamble() {

        int spiritCoins = gamePlayer.getPlayerSpiritCoins();
        System.out.print("Get a random item that might be useful for 5 coins...\n [y]   [n]\n");
        String userChoice = userScanner.userScan();
        if (userChoice.equals("y")) {
            if (spiritCoins > 5) {
                System.out.print("No refunds!\n");
                spiritCoins -= 5;
                gamePlayer.setPlayerSpiritCoins(spiritCoins);

                Random gambleNumber = new Random();

                // Generate random index to pick item
                int chosenRandomIndex = gambleNumber.nextInt(shopGambleInventory.size());
                System.out.print("Item Obtained: \n"+shopGambleInventory.get(chosenRandomIndex));

                //Provide to user
                gamePlayer.getPlayerInventory().add(new gameItems(shopGambleInventory.get(chosenRandomIndex)));

            }
        } else if (userChoice.equals("n")) {
            System.out.print("Why bother showing interest... if you won't go all in?\n");
        } else {
            System.out.print("The shop keeper was not happy. Kicked out for hesitation in the hobby.\n");
        }
    }

    public static void shopDialogue() {
        System.out.print("\n- - -welcome to shop- - -\n");
        System.out.print("Shopkeeper provides you the following options.\nThey have a short temper, so be short and concise.\n");
        System.out.print("\n   [sell] [buy] [gamble] [exit]  \n");
        String userChoice = userScanner.userScan();

        if (userChoice.equals("sell")) {
            shopSell();
        } else if (userChoice.equals("buy")) {
            gameBuy();
        } else if (userChoice.equals("gamble")) {
            shopGamble();
        }else if(userChoice.equals("exit")) {
            System.out.print("\nGoodbye. See you next time!");
        } else {
            System.out.print("\nYour intentions aren't understood. You are kicked out for now...\n");
        }
    }

    public static void itemPurchase() {

        int spiritCoins = gamePlayer.getPlayerSpiritCoins();
        String userChoice = userScanner.userScan();
        if (gameCore.isMapUnlocked() == false && userChoice.equals("map")) {
            if (spiritCoins >= 5) {
                spiritCoins -=  5;
                gameCore.unlockMap();
            } else {
                System.out.print("You do not have enough spirit Coins\n");
            }
        } else if (userChoice.equals("map")) {
            System.out.print("map already unlocked. Why you Trying?\nSelect another item: \n");
            userChoice = userScanner.userScan();
        } else if (!userChoice.equals("map")) {
            String itemSelect = userChoice;
            boolean itemFound = false; //flags whether item is found
            int shopCost = 0; // Assigns purchase cost to 0 whenever shop is visited
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
                System.out.printf("\n%s costs: $%d. You have $%d. Purchase?\n[Y] / [N]\n", itemSelect, shopCost, spiritCoins);
                userChoice = userScanner.userScan().trim();

                switch (userChoice) {
                    case "y":
                        System.out.println("Item Purchased.\n");
                        // Search inventory || Section commented out until Connected with Inventory

                        for (int i = 0; i < gamePlayer.getPlayerInventory().size(); i++) {
                            if (itemSelect.equals(gamePlayer.getPlayerInventory().get(i).getItemName())) {
                                inventoryIndex = 1;
                                inventoryFlag = true;
                            }
                        }

                        if (inventoryFlag == true) { // Runs following only when Item exists within Inventory. +1 to item.
                            gamePlayer.getPlayerInventory().get(inventoryIndex).setItemQty(gamePlayer.getPlayerInventory().get(inventoryIndex).getItemQty() + 1);
                        } else { // should item not exist, add to inventory
                            gamePlayer.getPlayerInventory().add(new gameItems(shopInventory.get(index)));
                        }
                        spiritCoins -= shopCost;
                        gamePlayer.setPlayerSpiritCoins(spiritCoins);
                        shopInventory.get(index).setItemQty(shopInventory.get(index).getItemQty() - 1);
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
            } else {
                System.out.print("Taking too long caused you to be kicked out for now...\n\n");
            }
        }

    }
}

