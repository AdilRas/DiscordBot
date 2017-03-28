package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.entities.message.MessageReceiver;

/**
 * Created by 726115 on 3/27/2017.
 */
public class ShoutCommand implements Command {
    private static final String HELPTEXT = "Shout:\tUSAGE: !shout string\t\tDESC: Have the bot shout a message <Ex: \"!shout memes\" -> \nmemes>\"";
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        if(args.length > 0)
            return true;
        return false;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        for(String s : args) {
            sb.append(s + " ");
        }
        MessageBuilder mb = new MessageBuilder();
        mb.append(sb.toString());
        (message.getReceiver()).sendMessage(sb.toString(), true);

    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        if(!success)
            message.reply("Error: No parameters provided. See the help menu (!help) for usage details");
    }
}
