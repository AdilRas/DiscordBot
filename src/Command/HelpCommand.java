package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import startup.AugmentBot;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Adil on 3/25/2017.
 */
public class HelpCommand implements Command{
    //TODO - Finish help command after creating rest of commands
    public static final String HELPTEXT = "Help:\tUSAGE:\t!help\t\tDESC:\tReturns a list of commands available through this bot.";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        return true;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append("***Your Best Friend***\n```\n");
        TreeMap<String, Command> commandTreeMap = AugmentBot.getCommandMap();
        Set<Map.Entry<String, Command>> entrySet = commandTreeMap.entrySet();
        for(Map.Entry<String, Command> entry : entrySet) {
            sb.append(entry.getValue().help() + "\n");
        }
        sb.append("```");
        message.reply(sb.toString());
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        //not needed for this command
    }
}
