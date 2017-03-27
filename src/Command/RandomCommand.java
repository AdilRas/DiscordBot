package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

import java.util.IllegalFormatException;

/**
 * Created by Adil on 3/26/2017.
 */
public class RandomCommand implements Command {
    private static final String HELPTEXT = "Random Number:\tUSAGE:\t!random x y\t\tDESC:\tGenerates a random number in the range [x, y). <Ex: \"!random 3 7\" -> 4>";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        try {
            if(args.length > 0) {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                if(x >= y) {
                    throw new IndexOutOfBoundsException();
                }
                return true;
            } else {
                throw new IllegalMonitorStateException();
            }
        } catch(IllegalMonitorStateException imse) {
            message.reply("Error: Not enough parameters provided");
            return false;
        } catch (NumberFormatException nfe) {
            message.reply("Error: Parameters invalid. Must be Integers");
            return false;
        } catch(IndexOutOfBoundsException iobe) {
            message.reply("Error: First number should be smaller than the second.");
            return false;
        }

    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int rand = (int)(Math.random()*(y-x)) + x;
        message.reply("Random Number in range [" + x + ", " + y + ") : " + rand);
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        //not used here to handle specific issues in format of command
    }
}
