package listeners;

import Command.Command;
import Command.CommandParser;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;
import startup.AugmentBot;


/**
 * Created by Adil on 3/25/2017.
 */
public class MessageListener implements MessageCreateListener{


    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        try {
            if (!(message.getAuthor().getName().equals("startup.AugmentBot")) && message.getContent().startsWith("!") && message.getContent().length() > 1) {
                AugmentBot.handleCommand(CommandParser.parse(discordAPI, message, message.getContent()));

            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
