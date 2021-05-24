import commands.InfoCommand;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Bot {
    private String discordToken;
    private DiscordApi api;
    //"discordToken", "streamLobbyID"

    public Bot() {
        ConfigHandler configHandler = new ConfigHandler();
        this.discordToken = configHandler.getDiscordToken();
    }

    public void run() {
        api = new DiscordApiBuilder()
                .setToken(discordToken)
                .setAllIntents()
                .login().join();

        CommandHandler handler = new JavacordHandler(api);
        handler.registerCommand(new InfoCommand());

        System.out.println("Invite link: " + api.createBotInvite());




    }


}
