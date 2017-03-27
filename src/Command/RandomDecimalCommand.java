package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/26/2017.
 */
public class RandomDecimalCommand implements Command {
    private static final String HELPTEXT = "Random Decimal:\tUSAGE:\t!randomdec x y\t\tDESC:\tGenerates a random number in the range [x, y). <Ex: !randomdec 3.2  7.0 -> 4.4>";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        try{
            if(args.length > 0) {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                if(y <= x) {
                    throw new ArithmeticException();
                }
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException nfe) {
            message.reply("Error: Invalid or non-real number");
            return false;
        } catch (IllegalArgumentException iae) {
            message.reply("Error: Not enough parameters provided. Use the help menu (!help) for usage details.");
            return false;
        } catch (ArithmeticException ae) {
            message.reply("Error: First number should be smaller than the second.");
            return false;
        }

    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double rand = Math.random()*(y-x) + x;
        message.reply("Random Decimal in range [" + x + ", " + y + ") : " + rand);
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
