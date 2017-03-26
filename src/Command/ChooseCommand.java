package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */
public class ChooseCommand implements Command {
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        if(args.length > 1)
            return true;
        return false;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        int x = (int)(Math.random()*args.length);
        message.reply("I choose " + args[x]);
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {

    }
}
