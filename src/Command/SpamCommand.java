package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

/**
 * Created by Adil on 3/26/2017.
 */
public class SpamCommand implements Command {
    private static final String HELPTEXT = "Spam:\tUSAGE: !spam n string\t\tDESC: Have the bot spam a message <Ex: \"!spam 2 memes\" -> \nmemes\nmemes>";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        try {
            int x = Integer.parseInt(args[0]);
            if(!(x < 50)) {
                throw new IllegalMonitorStateException();
            } else {
                if(args.length > 1)
                    return true;
                else {
                    throw new IllegalArgumentException();
                }
            }
        } catch(IllegalMonitorStateException imse) {
            message.reply("Number too large. Try a number less than 50");
            return false;
        } catch(NumberFormatException nfe) {
            message.reply(args[0] + " is not a usable interval");
            return false;
        } catch (IllegalArgumentException iae) {
            message.reply("Not enough arguments.");
            return false;
        }
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) throws InterruptedException{
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < args.length; i++)
            sb.append(args[i] + " ");
        if(Integer.parseInt(args[0]) < 6) {
            for(int i = Integer.parseInt(args[0]); i > 0; i--) {
                message.reply(sb.toString());
            }
        } else {

            for(int i = 0; i < Integer.parseInt(args[0]); i++) {
                if((i+1)%5 == 0)
                    Thread.sleep(3500);
                message.reply(sb.toString());
            }
        }
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        //implemented with try/catch in "called" method
    }
}