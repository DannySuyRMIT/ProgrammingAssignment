package util;
import core.gameCore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import data.gameEnemy;
import data.gameItems;
import data.gamePlayer;
/**@author Christian Rayos */
/**@Ver 3.5               */
/**@Date 27/05/25        */

public class gameLocations {
    static boolean hasBambooWood = false;
    static boolean hasBambooRaft = false;
    static boolean hasTalisman = false;
    static boolean hasSpiritOrb = false;
    static boolean hasTriggeredGoodShrine = false;
    static boolean hasTriggeredBadShrine = false;
    static boolean hasTriggeredShrine = false;
    static boolean hasTriggeredQuest = false;
    static boolean hasFirstInteract = false;
    static boolean hasObtainedArmour = false;
    static boolean hasObtainedBlade = false;
    static boolean endingChoice = false;
    static boolean hasReadSign = false;
    static boolean hasPendant = false;

    // Initialize
    static gamePlayer player1 = new gamePlayer(gameCore.getUserName(), gamePlayer.getPlayerHealth(),gamePlayer.getPlayerAttackPower(),gamePlayer.getPlayerDefencePower());


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
                System.out.print("\n - Bamboo Forest - \nWalking deeper into the greenery down south, you find yourself surrounded\nby bamboo all around, reaching and towering over you... A small clearing\n can be made, and there sits a tiny moss-covered shrine.\n");
                break;
            case 105: // blacksmith
                System.out.print("\n - Old Blacksmith - \nAs the bamboo clears up around you, the moonlight shines upon an old,\ndecrepit blacksmith building... A blind of man sits by the porch...\n");
                break;
            case 302: // Island Piers
                System.out.print("\n - Island Piers - \nThe Fog has gotten thicker around now, settling just above the water surface which separates\nthe islands. This is the only way to and from the western portion of this area.\n");
                if (getHasBambooRaft() == true && gameEnemy.enemyPool.getLocationOnePoolState() == true) { // Guaranteed location fight.
                    gameEnemy chosenEnemy = gameEnemy.enemyPool.getRandomOneLocation();

                    System.out.print("\nEnemy encounter!\n");
                    gameBattle.gameCombat(player1, chosenEnemy, "locationOneEnemies");
                }
                break;
            case 303: // Village
                System.out.print("\n - Village - \nThe misty dew disperses around you, revealing a small cozy village with some beings that move about...\nA lady stands there, seemingly glancing your direction.\n");
                break;
            case 305: // Spawn | Pier
                System.out.print("\n - The Pier - \nThis place feels unsafe, and standing still, you can hear nothing but \nthe waves crashing around you... It's probably not save to idle here.\n");
                break;
            case 501: // Fogged forest
                System.out.print("\n - Fogged Forest - \nThe Fog has gotten thicker, and you can only make out\n a distant figure, sitting by an old broken shrine...\n");
                break;
            case 503: // Shrine
                System.out.print("\n - Shrine - \nAs you go walk through the mist, passing by the shrubbery, You \ncome an old but somehow well maintained shrine... There's some \nsort of importance that can be felt here...\n");
                break;
            case 505: // wooden Outpost
                System.out.print("\n - old tower - \nSpotting an old wooden militaristic tower by the cliff side overlooking the waters,\nIt feels eerily silent. You might wanna be on your guard... and on the lookout \nfor some good items.\n");
                break;
            default: // else

                // Create Random class
                Random percentChance = new Random();

                // Generate 1-100
                int spawnChance = percentChance.nextInt(100)+1;
                if (spawnChance <= 10) { // Provide 10% to spawn
                    gameEnemy chosenEnemy = gameEnemy.enemyPool.getRandomCommon();
                    System.out.print("\nEnemy encounter!\n");
                    gameBattle.gameCombat(player1, chosenEnemy, "CommonEnemies");


                }
                System.out.print("\n - Idle Plains - \nThere's nothing interesting here...\nIt's best to keep moving.\n");

        }
    }

    public static void locationInteract() {
        int currentLocation = gameMap.getCurrentLocation();
        String userChoice;
        System.out.print("\nNote: If interacting with something, write out the full name.\nNote: You may also write 'back' to stop.");
        boolean validChoice = false;
        switch (currentLocation) {
            case 101: // Cave location
                System.out.print("\n - Interactable - \n- cave entrance\n");
                do {
                    userChoice = userScanner.userScan();

                    if (userChoice.equals("cave entrance")) {
                        validChoice = true;
                        if (getHasTalisman() == true) {
                            if (hasSpiritOrb == false) {
                                System.out.print("\nTaking out the talisman, the dark fog surrounding the entrance dissipates. Heading inside, a translucent fox-like figure can be seen.\nIt takes notice of you...\n");
                                System.out.print("\nUnknown: huh who enters this place...?\n");
                                System.out.print("\nThe spirit floats to you, and it gaze seeps into your soul... It seems to want your name.\n");
                                userChoice = userScanner.userScan();
                                if (userChoice.equals(gameCore.getUserName())) {
                                    System.out.print("\nUnknown: hm... lines up with what your soul tells me...\n");
                                } else {
                                    System.out.print("\nUnknown: Hesitating to tell me? Bold of you... I'll ignore it for now.\n");
                                }
                                System.out.print("Unknown: Regardless, now that you're here...\nUnknown: I have a small request...\n");
                                System.out.print("Gorou: My name is Gorou, and I've been restless for far too long.\n");
                                System.out.print("Gorou: I want you to put me to rest...\n");
                                System.out.print("Gorou: Take my heart and place it at a shrine...\n");
                                System.out.print("Gorou: That is my only request... now go...\n");
                                System.out.print("\nThe spirit disipates, leaving behind a spiritual orb...\nThis must be its' heart.\n");

                                // Change Status of SpiritOrb
                                setHasSpiritOrb();
                                System.out.print("\n  Spirit Orb acquired.\n");
                            } else {
                                System.out.print("\nWithout the spirit here, it's just an empty, dark cave...\n");
                            }
                        } else {
                            System.out.print("\nThe cave feels too ominous to approach...\nNearby, many discarded broken talismans can be seen on the ground,\nleading to the East.\n");
                        }
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                } while (validChoice == false);

                break;
            case 102: // Ritual area
                System.out.print("\n - Interactable - \n- preserved chest\n- muddy note\n");
                int numberLock = gameCore.getNumberLock();

                do {
                    userChoice = userScanner.userScan();

                    if (userChoice.equals("preserved chest")) {
                        validChoice = true;
                        if (getHasTalisman() == false) {
                            System.out.print("\nYou check out the preserved chest. It seemingly has a number lock on it...\nYou put in the code:\n");

                            try {
                                int numberGuess = userScanner.intScan();


                                if (numberGuess == numberLock) {
                                    System.out.print("\nThe chest unlocks... Inside you find a talisman.\n It gives off a calming effect.\n");
                                    setHasTalisman();
                                    System.out.print("\n  Talisman acquired.\n");
                                    userScanner.userScan();
                                } else {
                                    System.out.print("\nNothing happens... perhaps finding a clue for the code is best\n");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("\nDon't put non-ints here ok?\n");
                            }
                        } else {
                            System.out.print("\nChecking the now open chest, you find nothing inside...\n");
                        }
                    } else if (userChoice.equals("muddy note")) {
                        System.out.printf("\nChecking out the spotted note, you can make out nothing from\n the washed out words, except for a large number: %d\n", numberLock);
                        validChoice = true;
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                } while (validChoice == false);
                break;
            case 104: // Bamboo forest
                System.out.print("\n - Interactable -\n- mossy shrine\n");
                if (getHasTriggeredQuest() == true && getHasBambooWood() == false) {
                    System.out.print("- fallen bamboo\n");
                }

                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("mossy shrine")) {
                        validChoice = true;
                        if (getHasSpiritOrb() == true) {
                            if (endingChoice == false) {
                                System.out.print("\nThis shrine emit more omnious energy, and the moss has turned dark...\nThough the spirit did say any shrine will do...\n");
                                System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                do {
                                    userChoice = userScanner.userScan();
                                    if (userChoice.equals("yes")) {
                                        System.out.print("\nthe spirit orb has been placed...\nThere's no going back.\n");
                                        endingChoice = true;
                                        setHasTriggeredBadShrine();
                                    } else if (userChoice.equals("no")) {
                                        System.out.print("\nDeciding not to place it at this shrine, you step back... perhaps there's another place?\n");
                                        break;
                                    } else {
                                        System.out.print("\nHesitating at this moment, you must make a decision rather than waver.\n");
                                        System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                    }
                                } while (endingChoice == false);
                            } else if (getHasTriggeredBadShrine() == true) {
                                System.out.print("\nThe orb remains unmoved from its' resting place.. hopefully the spirit is satisfied.\n");
                                System.out.print("It's time to head back to the pier... There's a feeling that have feeling something's there.\n");
                            } else {
                                System.out.print("The shrine only emits an omnious feeling... the choice not to \nchoose this one may have been wise.\n");
                            }
                        } else {
                            System.out.print("\nthe shrine is overgrown and barely any color remains...\nA small, moldy cushion is seen inside, like something is to rest on it...\n");
                        }
                    } else if (getHasTriggeredQuest() == true && userChoice.equals("fallen bamboo")) {
                        System.out.print("\nSeeing a pile of fallen bamboo on the ground, you pick it up.\n");
                        setHasBambooWood();
                        System.out.print("\n  Bamboo wood acquired.\n");
                        validChoice = true;
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                } while (validChoice == false);

                break;
            case 105: // blacksmith
                System.out.print("\n - Interactable - \n- old blind man\n- broken board\n");
                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("old blind man")) {
                        validChoice = true;
                        if (getHasObtainedArmour() == false) {
                            System.out.print("As you approach the man, he hears your footstep and yells out.\n");
                            System.out.print("blind old man: Who goes there! Are you a Yokai!?\n");
                            userChoice = userScanner.userScan();
                            if (userChoice.isEmpty()) {
                                System.out.print("\nblind old man: Playing silent?! You yokais won't fool me.\n");
                            } else {
                                System.out.print("\nblind old man: what you say? how I know you're no yokai??\n");
                            }
                            System.out.print("\nIt seems that in order to calm this old man, you need something to convince him...\n");
                            if (getHasReadSign() == true) {
                                System.out.print("\nRemembering the word 'tachibana' from the board, you say it out loud.\n");
                                System.out.print("\nblind old man: huh...? Ah, you can read? That clearly means you're no yokai!\n");
                                System.out.print("blind old man: In that case, welcome! welcome!\n");
                                System.out.print("blind old man: Here! Some armour as an apology!\nI have no use for it anymore, so keep it.\n");
                                System.out.print("\nThe man leads to his storage room, and there sits a set of samurai armour...\nYou take it, and bid the man farewell.\n");
                                setHasObtainedArmour();
                                System.out.print("\n  Samurai set acquired.\n");
                            }
                        } else {
                            System.out.print("\nThe old man sits by his porch... It seems he's fallen asleep.\n");
                        }
                    } else if (userChoice.equals("broken board")) {
                        System.out.print("\nThe broken board is barely legible...\nThough the words 'tachibana' seem to be written...\n");
                        setHasReadSign();
                        validChoice = true;
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                }while (validChoice == false);

                break;
            case 303: // Village
                System.out.print("\n - Interactable - \n- shop\n- lady\n");
                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("shop")) {
                        validChoice = true;
                        shop.shopDialogue();
                    } else if (userChoice.equals("lady")) {
                        validChoice = true;
                        if (getFirstInteract() == false) {
                            // Sets FirstInteraction  Instantly
                            setFirstInteract();
                            System.out.print("\nlady: Oh, are you new here? If that's the case,\nlet me introduce myself...\n");
                            System.out.print("Tachibana: my name is Tachibana, and I welcome you to the village\n");
                            System.out.print("\nShe observes you, glancing up and down, before looking you in the eyes.\n");
                            System.out.print("\nTachibana: I have a request... Since you seem to not be from around here.\n");
                            System.out.print("Tachibana: Please investigate the cave to the west... Yokai have been appearing everywhere recently,\nand it may has been getting dangerous...\n");
                            System.out.print("\nWill you agree with her request?\n  [yes]  [no]  \n");
                            userChoice = userScanner.userScan();
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
                            System.out.print("Tachibana: From there, you'll need to traverse to the southern end\n of the western islands...\nI've also heard about some hermit in the north though, so that may interest you...\n");
                            System.out.print("Tachibana: There's also a store here, if you need to buy anything\nHere, let me give you some coins...\n");
                            gamePlayer.setPlayerSpiritCoins(20);
                            System.out.printf("\n Current Spirit coins: %d\n",gamePlayer.getPlayerSpiritCoins());
                            System.out.print("\nTachibana: Now go, and hopefully you come back with answers...\nBut most of all, stay safe. Please.\n");
                            // Quest now obtained.
                            setHasTriggeredQuest();
                        } else if (getHasSpiritOrb() == true) {
                            System.out.print("\nTachibana: You've come back. It seems you have an orb of some kind...\n");
                            System.out.print("\nShe glances at it before nodding. It seems she understands its' origins\n");
                            System.out.print("Tachibana: I think I understand it now...\n");
                            System.out.print("\nYou explain the spirit named Gorou, and their wish to be 'put to rest'.\n");
                            System.out.print("\nTachibana: If that's the case, I can point you towards three locations...\n");
                            System.out.print("\nThe three locations pointed out are:\n- the shrine to the north\n- the shrine in the bamboo forest\n- the shrine right at the pier\n");
                            System.out.print("\nTachibana: Though I know of the one by the pier, you can also try these two other shrines... Though not sure...\n");
                            System.out.print("Tachibana: Anyways, I wish you luck on your final journey, and hope that you get home safely...\n");
                        }else if (getHasBambooWood() == true) {
                            System.out.print("\nTachibana: Ah! Welcome back. I see you have obtained the bamboo.\n");
                            System.out.print("Tachibana: Let me handle that and make the boat.\n");
                            System.out.print("\nTime seeemingly slows down, and as soon as you blink, the bamboo you held\nhas disappeared. There's now a stable, bamboo raft that's being held up by Tachibana.\n");
                            System.out.print("\nTachibana: I know you might be confused, but let's not focus on that for now\n");
                            System.out.print("Tachibana: Before you head off, you might be interested in these locations, before you head west.\n");
                            System.out.print("Tachibana points out the following:\n - A shrine to directly to the north\n - An outpost northeast of the village\n - A blacksmith southeast of the village.\n");
                            System.out.print("\nTachibana: By the way, before you set off...Apparently the cave entrance is not\n approachable, as if some sort of energy is warding people off, making them feel \nanxious... Though that's all I got from old records.\n");
                            System.out.print("\nAs you thank Tachibana for the info, you head off.\n");
                            setHasBambooRaft();
                            System.out.print("\n  Bamboo raft acquired.\n");
                        } else {
                            System.out.print("\nTachibana: Ah, hello? It seems you've come just to talk?\n");
                            System.out.print("Tachibana: How kind of you, though you should probably focus on your journey.\n");
                        }
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                }while (validChoice == false);

                break;
            case 305: // Spawn | Pier
                System.out.print("\n - Interactable - \n- small shrine\n- sign\n");
                if (endingChoice == true) {
                    System.out.print("\n- pier edge\n");
                }

                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("small shrine")) {

                        validChoice = true;
                        if (getHasSpiritOrb() == true) {
                            if (endingChoice == false) {
                                System.out.print("\nAs you approach, shrine slowly glows, and the surrounding fog reels back...\nPerhaps this will appease did the spirit...\n");
                                System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                do {
                                    userChoice = userScanner.userScan();
                                    if (userChoice.equals("yes")) {
                                        System.out.print("\nthe spirit orb has been placed...\nThere's no going back.\n");
                                        endingChoice = true;
                                        setHasTriggeredShrine();
                                    } else if (userChoice.equals("no")) {
                                        System.out.print("\nDeciding not to place it at this shrine, you step back... perhaps there's another place?\n");
                                        break;
                                    } else {
                                        System.out.print("\nHesitating at this moment, you must make a decision rather than waver.\n");
                                        System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                    }
                                } while (endingChoice == false);
                            } else if (getHasTriggeredShrine() == true) {
                                System.out.print("\nThe shrine slowly hums with energy, and the fog around dissipates\naround you... though the energy of the shrine disperses gradually\n");
                                System.out.print("It's to approach the end of the Pier, see if an exit has been found.\n");
                            } else {
                                System.out.print("\nThe shrine's is unchanged, so it's unclear if not picking this was wrong...\n");
                            }
                        } else {
                            System.out.print("\nAn old, weathered small shrine by the pier...Though damaged \nand decaying due to nature, it's arguably well-maintained.\nThere appears to be a slot for some sort of orb atop a cushion...\n");
                        }

                    } else if (userChoice.equals("sign")) {
                        validChoice = true;
                        System.out.print("\nThough the sign is weathered from exposure to nature, the following can be read:\n \"VILLAGE LOCATED TO THE WEST\"\n");
                    } else if (userChoice.equals("pier edge") && endingChoice == true) {
                        validChoice = true;
                        System.out.print("\nApproaching the end of the Pier, you turn arround and see a big foe\nbefre you... It seems this is the final stretch\n");
                        // Obtain Boss Enemy
                        gameEnemy chosenEnemy = gameEnemy.enemyPool.getRandomBoss();

                        System.out.print("\nEnemy encounter!\n");
                        // Simulate Battle
                        gameBattle.gameCombat(player1,chosenEnemy,"bossEnemies");
                                
                        gameEnding.gameEnding();
                    }else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                }while (validChoice == false);

                break;
            case 501: // Fogged forest
                System.out.print("\n - Interactable - \n- strange man\n");
                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("strange man")) {
                        validChoice = true;

                        System.out.print("\nYou apporach the figure by the fog, a supposed hermit. But his rambles keep you far away.\n");
                        System.out.print("\nStrange man: ... The shrines...choose wisely\n");
                        System.out.print("Strange man: ... Omnious... to damnation\n");
                        System.out.print("Strange man: ... The... bright... clean... salvation\n");
                        System.out.print("\nNo more of his ramblings are legible... Perhaps there's a reason \nwhy the destroyed shrine emits a cold and anxious feeling...\n");
                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                } while(validChoice == false);

                break;
            case 503: // Shrine
                System.out.print("\n - Interactable - \n- offering box\n");
                if (getHasPendant() == false) {
                    System.out.print("- pendant\n");
                }
                do {
                    userChoice = userScanner.userScan();
                    if (userChoice.equals("offering box")) {
                        validChoice = true;
                        if (getHasSpiritOrb() == true) {
                            if (endingChoice == false) {
                                System.out.print("\nAs you approach, A calming light lights up the entire shrine, and the fog appears to have entirely disappear ..\nIt seems that whatever happens, it'll satisfy the spirits' request...\n");
                                System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                do {
                                    userChoice = userScanner.userScan();
                                    if (userChoice.equals("yes")) {
                                        System.out.print("\nthe spirit orb has been placed...\nThere's no going back.");
                                        endingChoice = true;
                                        setHasTriggeredGoodShrine();
                                    } else if (userChoice.equals("no")) {
                                        System.out.print("\nDeciding not to place it at this shrine, you step back... perhaps there's another place?\n");
                                        break;
                                    } else {
                                        System.out.print("\nHesitating at this moment, you must make a decision rather than waver.\n");
                                        System.out.print("Place the spiritOrb here?\n [yes]  [no]  \n");
                                    }
                                } while (endingChoice == false);
                            } else if (getHasTriggeredGoodShrine() == true) {
                                System.out.print("\nWith the gradual retreat of the fog, the beauty of the forestry\nand its surroundings can be seen...It seems the fog is slowly retreating from the island itself\n");
                                System.out.print("It's time to head back to the pier... There's a feeling that have feeling something's there.\n");
                            } else {
                                System.out.print("\nThe shrine lays still, with  a small calmning atmosphere still present...\n");
                            }
                        } else {
                            System.out.print("\nA well-maintained shrine, despite being surrounded by trees on all sides.\nIt's unknown who, or what tends to this place, but the fog dares not enter the proximity...\n");
                        }
                    } else if(getHasPendant() == false && userChoice.equals("pendant")) {
                        System.out.print("Seeing a pendent within the shine, you contemplate taking it... eventually you\ngrab it, due to its' calming presence.\n");
                        setHasPendant();
                        gamePlayer.addItem(gameItems.populateWorldInventory().get(1));
                        validChoice = true;

                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }

                } while (validChoice == false);
                break;
            case 505: // wooden Outpost
                System.out.print("\n - Interactable - \n- old note\n");
                if (getHasObtainedBlade() == false) {
                    System.out.print("- blade\n");
                }

                do {
                    userChoice = userScanner.userScan();

                    if (userChoice.equals("old note")) {
                        validChoice = true;
                        System.out.print("\nYou find an old note attached to the wall which reads:\n \"TRUST NOT THE SHRINE THAT DECAYS\"\n");
                    } else if (userChoice.equals("blade") && getHasObtainedBlade() == false) {
                        validChoice = true;
                        System.out.print("\nSpotting a blade stabbed in the ground, You glance around before taking it\n. As soon as you grab it though, unwelcomed accompany arrives.\n");
                        setHasObtainedBlade();
                        gamePlayer.addItem(gameItems.populateWorldInventory().get(0));
                        if (getHasObtainedBlade() == true && gameEnemy.enemyPool.getLocationTwoPoolState() == true) { // Guaranteed location fight.
                            gameEnemy chosenEnemy = gameEnemy.enemyPool.getRandomTwoLocation();
                            System.out.print("\nEnemy encounter!\n");
                            gameBattle.gameCombat(player1, chosenEnemy, "locationTwoEnemies");
                        }

                    } else if (userChoice.equals("back")) {
                        validChoice = true;
                    }
                 } while (validChoice == false);
                break;
            default: // else
                System.out.print("\n - Interactable - \n Nothing\n");

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

    public static boolean getHasPendant() {
        return hasPendant;
    }

    public static void setHasPendant() {
        hasPendant = true;
    }

    public static boolean getHasTriggeredShrine() {
        return hasTriggeredShrine;
    }

    public static void setHasTriggeredShrine() {
        hasTriggeredShrine = true;
    }
}
