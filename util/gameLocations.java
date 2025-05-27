package util;

/**@author Christian Rayos */
/**@Ver 1.0               */
/**@Date 27/05/25        */

public class gameLocations {
    public static void locationEntry() {
        int currentLocation = gameMap.getCurrentLocation();

        if (currentLocation == 101) { // Creepy Cave || Final objective
            System.out.print("\n - Creepy Cave - \nAn ominous cave lays before you... Is it worth exploring?\nAnd are you prepared to undergo whatever comes next?\n");
        } else if (currentLocation == 104) { // Bamboo Forest || True ending finder
            System.out.print("\n - Bamboo Forest - \nWalking deeper into the greenery down south, you find yourself surrounded\nby bamboo all around, reaching and towering over you... A small clearing\n can be made, and there sits a tiny moss-covered shrine.");
        } else if (currentLocation == 105) { // Blacksmith || Only accessible through Bamboo forest
            System.out.print("\n - Old Blacksmith - \nAs the bamboo clears up around you, the moonlight shines upon an old, decrepit blacksmith...\nPerhaps there's something that might prove useful...");
        } else if (currentLocation == 303) { // Village
            System.out.print("\n - Village - \nThe misty dew disperses around you, revealing a small cozy village with some beings that move about...\nA lady stands there, seemingly glancing your direction.\n");
        } else if (currentLocation == 305) { // Pier || Spawnpoint
            System.out.print("\n - The Pier - \nThis place feels unsafe, and standing still, you can hear nothing but \nthe waves crashing around you... It's probably not save to idle here.\n");
        } else if (currentLocation == 501) { // Foggy Forest
            System.out.print("\n - Fogged Forest - \nThe Fog has gotten thicker, and you can only make out a distant figure,\nsitting by an old shrine...\n");
        } else if (currentLocation == 503) { // old, maintained shrine || True ending finder
            System.out.print("\n - Shrine - \nAs you go walk through the mist, passing by the shrubbery, You \ncome an old but somehow well maintained shrine... There's some \nsort of importance that can be felt here...\n");
        } else if (currentLocation == 505) { // Outpost
            System.out.print("\n - old tower - \nSpotting an old militaristic tower by the cliff side overlooking the waters,\nIt feels eerily silent. You might wanna be on your guard... and on the lookout \nfor some good items.\n");
        } else {
            System.out.print("\n - Idle Plains - \nThere's nothing interesting here, so it's best to keep moving.\n");
        }
    }

    public static void locationInteract() {
        System.out.print(gameMap.getCurrentLocation());
    }
}
