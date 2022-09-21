package org.TeamTest;


import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.TeamTest.util.getForeignPlayerCount;
import static org.TeamTest.util.getWicketKeeperCount;

public class AppTest {

    //Verify Count of Foreign Players.
    @Test
    void verifyForeignPlayers() throws IOException, ParseException {
        String JSONFilePath = "./src/data/TeamRCB.json";
        int foreignPlayers = getForeignPlayerCount("India",JSONFilePath);
        Assert.assertEquals(foreignPlayers,4);
    }


    //Verify Count of Wicket Keepers.
    @Test
    void verifyWicketKeeper() throws IOException, ParseException {
        String JSONFilePath = "./src/data/TeamRCB.json";
        boolean flag = false;
        int wicketKeeper = getWicketKeeperCount(JSONFilePath);
        if(wicketKeeper>=1)
            flag = true;
        Assert.assertTrue(flag);
    }


}
