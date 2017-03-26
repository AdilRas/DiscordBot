package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */
public class PingCommand implements Command {
    private static final String HELPTEXT = "Ping:\tUSAGE:\t!ping\t\tDESC:\tClassic Ping command. <Ex: !ping>";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        return true;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        message.reply("Pong!");
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        //Not needed for this command
    }
}
