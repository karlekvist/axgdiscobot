package commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.user.User;

//from bastian's github example. here for testing purposes.
public class InfoCommand implements CommandExecutor {

    @Command(aliases = {"!info", "!i" }, description = "Shows some information aboout the bot.", usage = "!info [author|time]")
    public String onInfoCommand(String[] args, User user) {
        if (args.length > 1) {
            return "Too many arguments!";
        }
        if (args.length == 0) {
            return "- **Author:**" + user.getDiscriminatedName();
        }
        if (args.length == 1) {
            if (args[0].equals("author")) {
                return "author command";
            }
            if (args[0].equals("time")) {
                return "timecommand";
            }
        }
        return "Unknownn argument!";
    }


}
