package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/25/2017.
 */
public class AddCommand implements Command {
    private final static String HELPTEXT = "!add x y\tReturns the sum of two numbers. <Ex: \"!add 3 4\" would return 7>";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        boolean possibleOperation = false;
        try {
            Double.parseDouble(args[0]);
            Double.parseDouble(args[1]);
            possibleOperation = true;
        } catch (NumberFormatException nfe) {
            possibleOperation = false;
        }
        return possibleOperation;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        try {
            message.reply(String.valueOf(Double.parseDouble(args[0]) + Double.parseDouble(args[1])));
            executed(true, api, message);
        } catch (NumberFormatException nfe) {
            executed(false, api, message);
        }
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        if (!success) {
            message.reply("Error: Numbers not formatted correctly. USAGE: " + HELPTEXT);
        }
    }
}
