package util;
import core.gameCore;
import java.util.Random;
/**@author Christian Rayos */
/**@Ver 3.0               */
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
    static boolean endingChoice = false;
    static boolean hasReadSign = false;

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
        Random randomGen = new Random();
        String userChoice;
        System.out.print("\nNote: If interacting with something, write out the name.\n");
        switch (currentLocation) {
            case 101: // Cave location
                System.out.print("\n - Interactable - \n- cave entrance\n");
                userChoice = userScanner.userScan();
                if (userChoice.equals("cave entrance")) {
                    if (getHasTalisman() == true) {
                        System.out.print("Taking out the talisman, the dark fog surrounding the entrance dissipates. Heading inside, a translucent fox-like figure can be seen.\nIt takes notice of you...");
                        System.out.print("Unknown: huh who enters this place...?\n");
                        System.out.print("The spirit floats to you, and it gaze seeps into your soul... It seems to want your name.\n");
                        userChoice = userScanner.userScan();
                        if (userChoice.equals(gameCore.getUserName())) {
                            System.out.print("\nUnknown: hm... lines up with what your soul tells me...\n");
                        } else {
                            System.out.print("\nUnknown: Hesitating to tell me? Bold of you... I'll ignore it for now.\n");
                        }
                        System.out.print("Unknown: Regardless, now that you're here...Gorou: I have a small request...\n");
                        System.out.print("Gorou: My name is Gorou, and I've been restless for far too long.\n");
                        System.out.print("Gorou: I want you to put me to rest...\n");
                        System.out.print("Gorou: Take my heart and place it at a shrine...\n");
                        System.out.print("Gorou: That is my only request... now go...\n");
                        System.out.print("The spirit disipates, leaving behind a spiritual orb...\nThis must be its' heart.\n");

                        // Change Status of SpiritOrb
                        setHasSpiritOrb();
                        System.out.print("\nSpirit Orb Obtained\n");
                    } else {
                        System.out.print("The cave feels too ominous to approach...\nNearby, many discarded broken talismans can be seen on the ground,\nleading to the East.\n");
                    }
                }

                break;
            case 102: // Ritual area
                System.out.print("\n - Interactable - \n- preserved chest\n- muddy note\n");
                userChoice = userScanner.userScan();
                int numberLock = randomGen.nextInt((99 - 10)+ 1) + 1;
                int numberGuess;
                if (userChoice.equals("preserved chest")) {
                    System.out.print("You check out the preserved chest. It seemingly has a number lock on it...\nYou put in the code:\n");
                    numberGuess = userScanner.intScan();
                    if (numberGuess == numberLock) {
                        System.out.print("\nThe chest unlocks... Inside you find a talisman.\n It gives off a calming effect.\n");
                        setHasTalisman();
                    } else {
                        System.out.print("\nNothing happens... perhaps finding a clue for the code is best\n");
                    }
                } else if(userChoice.equals("muddy note")) {
                    System.out.printf("Checking out the spotted note, you can make out nothing from\n the washed out words, except for a large number: %d", numberLock);
                }
                break;
            case 104: // Bamboo forest
                System.out.print("\n - Interactable -\n- mossy shrine\n");
                if (getHasTriggeredQuest() == true) {
                    System.out.print("- fallen bamboo");
                }
                userChoice = userScanner.userScan();
                if (userChoice.equals("mossy shrine\n")) {
                    if (getHasSpiritOrb() == true) {
                        if (endingChoice == false) {
                            System.out.print("This shrine emit more omnious energy, and the moss has turned dark...\nThough the spirit did say any shrine will do...\n");
                            System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                            do {
                                userChoice = userScanner.userScan();
                                if (userChoice.equals("yes")) {
                                    System.out.print("the spirit orb has been placed...\nThere's no going back.");
                                    endingChoice = true;
                                    setHasTriggeredBadShrine();
                                } else if (userChoice.equals("no")) {
                                    System.out.print("Deciding not to place it at this shrine, you step back... perhaps there's another place?");
                                    endingChoice = true;
                                } else {
                                    System.out.print("Hesitating at this moment, you must make a decision rather than waver.\n");
                                    System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                }
                            } while (endingChoice == false);
                        } else {
                            System.out.print("The orb remains unmoved from its' resting place.. hopefully the spirit is satisfied.\n");
                        }
                    } else {
                        System.out.print("the shrine is overgrown and barely any color remains...\nA small, moldy cushion is seen inside, like something is to rest on it...\n");
                    }
                } else if (getHasTriggeredQuest() == true && userChoice.equals("fallen bamboo")) {
                    System.out.print("Seeing a pile of fallen bamboo on the ground, you pick it up.\n");
                    setHasBambooWood();
                }
                break;
            case 105: // blacksmith
                System.out.print("\n - Interactable - \n- old blind man\n- broken board");
                userChoice = userScanner.userScan();
                if (userChoice.equals("old blind man")) {
                    if (getHasObtainedArmour() == false) {
                        System.out.print("As you approach the man, he hears your footstep and yells out.\n");
                        System.out.print("blind old man: Who goes there! Are you a Yokai!?\n");
                        userChoice = userScanner.userScan();
                        if (userChoice.isEmpty()) {
                            System.out.print("\nblind old man: Playing silent?! You yokais won't fool me.\n");
                        } else {
                            System.out.print("\nblind old man: what you say? how I know you're no yokai??\n");
                        }
                        System.out.print("It seems that in order to calm this old man, you need something to convince him...\n");
                        if (getHasReadSign() == true) {
                            System.out.print("Remembering the word 'tachibana' from the board, you say it out loud.");
                            System.out.print("blind old man: huh...? Ah, you can read? That clearly means you're no yokai!\n");
                            System.out.print("blind old man: In that case, welcome! welcome!\n");
                            System.out.print("blind old man: Here! Some armour as an apology!\nI have no use for it anymore, so keep it.\n");
                            System.out.print("The man leads to his storage room, and there sits a set of samurai armour...\nYou take it, and bid the man farewell.\n");
                            setHasObtainedArmour();
                        } else {
                            System.out.print("TR\n");
                        }
                    }
                } else if (userChoice.equals("broken board")) {
                    System.out.print("The broken board is barely legible...\nThough the words 'tachibana' seem to be written...\n");
                    setHasReadSign();
                }

                break;
            case 303: // Village
                System.out.print("\n - Interactable - \n- shop\n- lady\n");
                userChoice = userScanner.userScan();
                if (userChoice.equals("shop")) {
                    shop.shopDialogue();
                } else if (userChoice.equals("the lady")) {
                    if (getFirstInteract() == false) {
                        // Sets FirstInteraction  Instantly
                        setFirstInteract();
                        System.out.print("\nlady: Oh, are you new here? If that's the case,\nlet me introduce myself...\n");
                        System.out.print("Tachibana: my name is Tachibana, and I welcome you to the village\n");
                        System.out.print("She observes you, glancing up and down, before looking you in the eyes.\n");
                        System.out.print("Tachibana: I have a request... Since you seem to not be from around here.\n");
                        System.out.print("Tachibana: Please investigate the cave to the west... Yokai have been appearing everywhere recently,\nand it may has been getting dangerous...\n");
                        System.out.print("Will you agree with her request?\n  [yes]  [no]  \n");
                        userScanner.userScan();
                        if (userChoice.equals("yes")) {
                            System.out.print("Tachibana: Thank you...\n");
                        } else if (userChoice.equals("no")) {
                            System.out.print("Tachibana: Please reconsider, it may help you get home...\n");
                        } else {
                            System.out.print("Tachibana: I know you're hesitating, but it may help you...\n");
                        }
                        System.out.print("Tachibana: There's been others like you, newcomers to this land.\n");
                        System.out.print("Tachibana: Many of them lived their lives here, but have discovered\nthat their coming to this place has to do with some sort of spirit...\n");
                        System.out.print("Tachibana: If you wanna get home... You'll need find that spirit. Though\nyou'll need to get a boat...Head to the bamboo forest south of here\nfor some bamboo, and come back.\n");
                        System.out.print("Tachibana: From there, you'll need to traverse to the southern end\n of the western islands...\nI've heard about some hermit in the north though, so that may interest you...\n");
                        System.out.print("Tachibana: Now go, and hopefully you come back with answers...\nBut most of all, stay safe. Please.\n");
                        // Quest now obtained.
                        setHasTriggeredQuest();
                    } else {

                    }
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
    public static void setFirstInteract() {
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

    public static boolean getHasReadSign() {
        return hasReadSign;
    }

    public static void setHasReadSign() {
        hasReadSign = true;
    }
}
