package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */
public class CommandParser {

    public static CommandContainer parse(DiscordAPI api, Message message, String str) {
        String raw = str;
        String beheaded = str.split("!")[1];
        String invoke = beheaded.split(" ")[0];
        String[] temp = beheaded.split(" ");
        String[] args = new String[temp.length-1];
        for(int x = 1; x < temp.length; x++) {
            args[x-1] = temp[x];
        }
        return new CommandContainer(api, message, invoke, args);
    }

}
