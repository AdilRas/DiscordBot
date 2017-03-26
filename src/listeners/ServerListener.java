package listeners;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.listener.server.ServerJoinListener;

/**
 * Created by Adil on 3/26/2017.
 */
/*TODO  - Create index of server members upon bot turning on.
        - Add members to list as they join server
        - Delete upon exit
*/
public class ServerListener implements ServerJoinListener{
    @Override
    public void onServerJoin(DiscordAPI discordAPI, Server server) {

    }
}
