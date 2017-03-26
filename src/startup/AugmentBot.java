package startup;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import listeners.MessageListener;
import Command.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Adil on 3/25/2017.
 */
public class AugmentBot {
    private static TreeMap<String, Command> commands = new TreeMap<String, Command>();
    public AugmentBot() throws IOException {
        DiscordAPI api = Javacord.getApi(new Scanner(new File("C:\\Users\\Adil\\Desktop\\credentials.txt")).nextLine(), true);
        api.connectBlocking();
        api.setAutoReconnect(true);
        api.registerListener(new MessageListener());
        commands.put("help", new HelpCommand());
        commands.put("add", new AddCommand());
        commands.put("ping", new PingCommand());
    }

    public static void handleCommand(CommandContainer cmd) {
        if(commands.containsKey(cmd.getInvoke())) {
            if(commands.get(cmd.getInvoke()).called(cmd.getArgs(), cmd.getAPI(), cmd.getMessage())) {
                commands.get(cmd.getInvoke()).action(cmd.getArgs(), cmd.getAPI(), cmd.getMessage());
            }
        } else {
            cmd.getMessage().reply("Command not found. Use the help menu to see a list of available commands");
        }
    }
    public static  TreeMap<String, Command> getCommandMap() {
        TreeMap<String, Command> cmds = new TreeMap<String, Command>();
        Set<Map.Entry<String, Command>> x = commands.entrySet();
        for(Map.Entry<String, Command> entry : x) {
            cmds.put(entry.getKey(), entry.getValue());
        }
        return cmds;
    }
}
