package org.TeamTest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class util {
    static int getForeignPlayerCount(String defaultCountry, String filepath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader =  new FileReader(filepath);
        Object obj = jsonParser.parse(reader);
        JSONObject teamJson = (JSONObject) obj;
        JSONArray players = (JSONArray) teamJson.get("player");
        String[] player_country = new String[11];
        int count = 0;
        for(int i=0; i<players.size(); i++)
        {
            JSONObject player = (JSONObject) players.get(i);
            player_country[i] = (String) player.get("country");
        }

        for(String s:player_country)
        {
            if(!s.equals(defaultCountry))
                count++;
        }

        return  count;
    }

    static int getWicketKeeperCount(String filepath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader =  new FileReader(filepath);
        Object obj = jsonParser.parse(reader);
        JSONObject teamJson = (JSONObject) obj;
        JSONArray players = (JSONArray) teamJson.get("player");
        String[] player_role = new String[11];
        int count = 0;
        for(int i=0; i<players.size(); i++)
        {
            JSONObject player = (JSONObject) players.get(i);
            player_role[i] = (String) player.get("role");
        }

        for(String s:player_role)
        {
            if(s.equals("Wicket-keeper"))
                count++;
        }

        return  count;
    }
}
