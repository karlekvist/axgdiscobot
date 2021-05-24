import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigHandler {

    private String discordToken = "";
    //private String twitchToken = "";
    //private String twitchClientId = "";
    //private String twitchClientSecret = "";
    static long streamLobbyId;

    public ConfigHandler() {
        String configurationFile = "src/main/resources/secrets.json";
        String configuration;
        try {
            configuration = new String((Files.readAllBytes(Paths.get(configurationFile))));
            JSONObject jsonObject = new JSONObject(configuration);
            discordToken = jsonObject.getString("discordToken");
            //twitchToken = jsonObject.getString("twitchToken");
            //twitchClientId = jsonObject.getString("twitchClientId");
            //twitchClientSecret = jsonObject.getString("twitchClientSecret");
            streamLobbyId = Long.parseLong(jsonObject.getString("streamLobbyId"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getDiscordToken() {
        return discordToken;
    }

    public long getStreamLobbyId() {
        return streamLobbyId;
    }
}
