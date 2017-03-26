package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */

public interface Command {

    public boolean called(String[] args, DiscordAPI api, Message message);
    public void action(String[] args, DiscordAPI api, Message message);
    public String help();
    public void executed(boolean success, DiscordAPI api, Message message);

}
