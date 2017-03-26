package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */
public class CommandContainer {

    private DiscordAPI api;
    private Message message;
    private String invoke;
    private String[] args;

    public CommandContainer(DiscordAPI api, Message message, String invoke, String[] args) {
        this.api = api;
        this.message = message;
        this.invoke = invoke;
        this.args = args;
    }

    public String getInvoke() {
        return invoke;
    }
    public String[] getArgs() {
        return args;
    }
    public DiscordAPI getAPI() {
        return api;
    }

    public Message getMessage() {
        return message;
    }


}
