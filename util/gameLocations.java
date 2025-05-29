package util;

/**@author Christian Rayos */
/**@Ver 2.1               */
/**@Date 27/05/25        */

public class gameLocations {
    static boolean hasBambooWood = false;
    static boolean hasBambooRaft = false;
    static boolean hasTalisman = false;
    static boolean hasSpiritOrb = false;
    static boolean hasTriggeredGoodShrine = false;
    static boolean hasTriggeredBadShrine = false;
    static boolean hasTriggeredQuest = false;
    static boolean hasFirstInteract = false;
    static boolean hasObtainedArmour = false;
    static boolean hasObtainedBlade = false;

    //    if (hasBambooWood == true) {
//        System.out.print("You have found a bamboo wooden shrine.\n");
//    } else {
//        System.out.print("You haven't found a bamboo wooden shrine.\n");
//    }
//    if (hasBambooRaft == true) {
//        System.out.print("You have found a bamboo raft.\n");
//    }
//    if (hasTalisman == true) {
//        System.out.print("You have found a talisman.\n");
//    }
//    if (hasSpiritOrb == true) {
//        System.out.print("You have found a spirit orb.\n");
//    }
//    if (hasTriggeredGoodShrine == true) {
//        System.out.print("You have found a good shrine.\n");
//    }
//    if (hasTriggeredBadShrine == true) {
//        System.out.print("You have found a bad shrine.\n");
//    }
//
    public static void locationEntry() {
        int currentLocation = gameMap.getCurrentLocation();

        switch (currentLocation) {
            case 101: // Cave location
                System.out.print("\n - Creepy Cave - \nAn ominous cave lays before you... Is it worth exploring?\nAnd are you prepared to undergo whatever comes next?\n");
                break;
            case 102: // Ritual area
                System.out.print("\n - Ritual Area - \nAn area where Shamans and Monks used to house rituals to banish spirits...\nPerhaps you'll find what's needed to finally enter the cave?\n");
                break;
            case 104: // Bamboo forest
                System.out.print("\n - Bamboo Forest - \nWalking deeper into the greenery down south, you find yourself surrounded\nby bamboo all around, reaching and towering over you... A small clearing\n can be made, and there sits a tiny moss-covered shrine.");
                break;
            case 105: // blacksmith
                System.out.print("\n - Old Blacksmith - \nAs the bamboo clears up around you, the moonlight shines upon an old,\ndecrepit blacksmith building... A blind of man sits by the porch...\n");
                break;
            case 302: // Island Piers
                System.out.print("\n - Island Piers - \nThe Fog has gotten thicker around now, settling just above the water surface which separates\nthe islands. This is the only way to and from the western portion of this area.\n");
                break;
            case 303: // Village
                System.out.print("\n - Village - \nThe misty dew disperses around you, revealing a small cozy village with some beings that move about...\nA lady stands there, seemingly glancing your direction.\n");
                break;
            case 305: // Spawn | Pier
                System.out.print("\n - The Pier - \nThis place feels unsafe, and standing still, you can hear nothing but \nthe waves crashing around you... It's probably not save to idle here.\n");
                break;
            case 501: // Fogged forest
                System.out.print("\n - Fogged Forest - \nThe Fog has gotten thicker, and you can only make out a distant figure,\nsitting by an old broken shrine...\n");
                break;
            case 503: // Shrine
                System.out.print("\n - Shrine - \nAs you go walk through the mist, passing by the shrubbery, You \ncome an old but somehow well maintained shrine... There's some \nsort of importance that can be felt here...\n");
                break;
            case 505: // wooden Outpost
                System.out.print("\n - old tower - \nSpotting an old wooden militaristic tower by the cliff side overlooking the waters,\nIt feels eerily silent. You might wanna be on your guard... and on the lookout \nfor some good items.\n");
                break;
            default: // else
                System.out.print("\n - Idle Plains - \nThere's nothing interesting here...\nIt's best to keep moving.\n");

        }
    }

    public static void locationInteract() {
        int currentLocation = gameMap.getCurrentLocation();

        String userChoice;
        switch (currentLocation) {
            case 101: // Cave location
                System.out.print("\n - Interactable - \n- cave entrance\n");
                userChoice = userScanner.userScan();
                if (userChoice.equals("cave entrance")) {
                    if (getHasTalisman() == true) {
                        System.out.print("Taking out the talisman, the dark fog surrounding the entrance dissipates. Heading inside, a translucent fox-like figure can be seen.\n");
                        System.out.print("Gorou: \n");
                        setHasSpiritOrb();
                    } else {
                        System.out.print("The cave feels too ominous to approach...\nNearby, many discard broken talismans can be seen on the ground,\nleading to the East.\n");
                    }
                }

                break;
            case 102: // Ritual area
                System.out.print("\n - Interactable - \nAn area where Shamans and Monks used to house rituals to banish spirits...\nPerhaps you'll find what's needed to finally enter the cave?\n");
                break;
            case 104: // Bamboo forest
                System.out.print("\n - Interactable - \nWalking deeper into the greenery down south, you find yourself surrounded\nby bamboo all around, reaching and towering over you... A small clearing\n can be made, and there sits a tiny moss-covered shrine.");
                break;
            case 105: // blacksmith
                System.out.print("\n - Interactable - \nAs the bamboo clears up around you, the moonlight shines upon an old, decrepit blacksmith...\nA blind of man sits by the porch...\n");
                break;
            case 303: // Village
                System.out.print("\n - Interactable - \n- shop\n- village girl\n");
                userChoice = userScanner.userScan();
                if (userChoice.equals("shop")) {
                    shop.shopDialogue();
                } else if (userChoice.equals("the lady")) {
                    System.out.print("\nTachibana: Oh, are you new here?");
                    setHasBambooRaft();
                }

                break;
            case 305: // Spawn | Pier
                System.out.print("\n - Interactable - \nThis place feels unsafe, and standing still, you can hear nothing but \nthe waves crashing around you... It's probably not save to idle here.\n");
                break;
            case 501: // Fogged forest
                System.out.print("\n - Interactable - \nThe Fog has gotten thicker, and you can only make out a distant figure,\nsitting by an old shrine...\n");
                break;
            case 503: // Shrine
                System.out.print("\n - Interactable - \nAs you go walk through the mist, passing by the shrubbery, You \ncome an old but somehow well maintained shrine... There's some \nsort of importance that can be felt here...\n");
                break;
            case 505: // wooden Outpost
                System.out.print("\n - Interactable - \nSpotting an old wooden militaristic tower by the cliff side overlooking the waters,\nIt feels eerily silent. You might wanna be on your guard... and on the lookout \nfor some good items.\n");
                break;
            default: // else
                System.out.print("\n - Interactable - \nThere's nothing interesting here, so it's best to keep moving.\n");

        }
    }

    public static boolean getHasBambooRaft() {
        return hasBambooRaft;
    }

    public static void setHasBambooRaft() {
        hasBambooRaft = true;
    }

    public static boolean getHasBambooWood() {
        return hasBambooWood;
    }

    public static void setHasBambooWood() {
        hasBambooWood = true;
    }

    public static boolean getHasTalisman() {
        return hasTalisman;
    }

    public static void setHasTalisman() {
        hasTalisman = true;
    }

    public static boolean getHasSpiritOrb() {
        return hasSpiritOrb;
    }

    public static void setHasSpiritOrb() {
        hasSpiritOrb = true;
    }

    public static boolean getHasTriggeredGoodShrine() {
        return hasTriggeredGoodShrine;
    }

    public static void setHasTriggeredGoodShrine() {
        hasTriggeredGoodShrine = true;
    }

    public static boolean getHasTriggeredBadShrine() {
        return hasTriggeredBadShrine;
    }

    public static void setHasTriggeredBadShrine() {
        hasTriggeredBadShrine = true;
    }

    public static boolean getHasTriggeredQuest() {
        return hasTriggeredQuest;
    }

    public static void setHasTriggeredQuest() {
        hasTriggeredQuest = true;
    }

    public static boolean getFirstInteract() {
        return hasFirstInteract;
    }
    public static void setHasFirstInteract() {
        hasFirstInteract = true;
    }

    public static boolean getHasObtainedArmour() {
        return hasObtainedArmour;
    }

    public static void setHasObtainedArmour() {
        hasObtainedArmour = true;
    }

    public static boolean getHasObtainedBlade() {
        return hasObtainedBlade;
    }

    public static void setHasObtainedBlade() {
        hasObtainedBlade = true;
    }


}
