package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import org.apache.commons.io.FileUtils;

import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 726115 on 3/27/2017.
 */
public class PersonCommand implements Command {
    private static final String HELPTEXT = "Person:\tUSAGE:\t!person name/id\t\tDESC:\tReturns the picture of a known person or a school picture based on ID <Ex: \"!person Mrs. Coffman\" -> picture of mrs. coffman>";
    private TreeMap<String, URL> knownPeople = new TreeMap<String, URL>();
    public PersonCommand() {
        try {
            knownPeople.put("mrs. coffman", new URL("http://www.fortbendisd.com/cms/lib09/TX01917858/Centricity/Domain/1020/Me%202016-2017%20cropped.jpg"));
            knownPeople.put("vicki coffman", new URL("http://www.fortbendisd.com/cms/lib09/TX01917858/Centricity/Domain/1020/Me%202016-2017%20cropped.jpg"));
            knownPeople.put("coffman", new URL("http://www.fortbendisd.com/cms/lib09/TX01917858/Centricity/Domain/1020/Me%202016-2017%20cropped.jpg"));
            knownPeople.put("ms. coffman", new URL("http://www.fortbendisd.com/cms/lib09/TX01917858/Centricity/Domain/1020/Me%202016-2017%20cropped.jpg"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        if(args.length == 0)
            return true;
        return false;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) throws InterruptedException {
        try{
            int id = Integer.parseInt(args[0]);
            FileUtils.copyURLToFile(new URL("https://skystorage.iscorp.com/pictures/tx/fortbend//0"+ id + ".JPG"), new File("temporary.JPG"));
        } catch (NumberFormatException nfe) {
            if(knownPeople.containsKey(message.getContent().toLowerCase())) {
                try {
                    FileUtils.copyURLToFile(knownPeople.get(message.getContent().toLowerCase()), new File("temp.jpg"));
                    message.getReceiver().sendFile(new File("temp.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (MalformedURLException mfe) {
            mfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        if(!success) message.reply("Invalid ID or unknown name");
    }
}
