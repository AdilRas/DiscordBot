package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/26/2017.
 */
public class ListCommand implements Command {
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        return true;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {

    }
}
