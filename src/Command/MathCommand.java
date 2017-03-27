package Command;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Adil on 3/26/2017.
 */
public class MathCommand implements Command {

    private static final String HELPTEXT = "Math:\tUSAGE:\t!math <constant>\t\tDESC:\tReturns the value of a given mathematical constant. <Ex: \"!math pi\" -> \"3.141592653\">";
    private TreeMap<String, String> constantsList = new TreeMap<String, String>();
    public MathCommand() {
        addConstants();
    }
    @Override
    public boolean called(String[] args, DiscordAPI api, Message message) {
        if(args.length > 0) {
            if(constantsList.containsKey(message.getContent().toLowerCase().split(" ")[1]) || message.getContent().toLowerCase().split(" ")[1].equals("showconstants"))
                return true;
        }
        return false;
    }

    @Override
    public void action(String[] args, DiscordAPI api, Message message) {
        if(args[0].toLowerCase().equals("showconstants")) {
            Set<String> constants = constantsList.keySet();
            StringBuilder sb = new StringBuilder();
            sb.append("`");
            for(String s : constants)
                sb.append(s + ";\t");
            sb.append("`");
            message.reply(sb.toString());
        } else if(constantsList.containsKey(message.getContent().split(" ")[1].toLowerCase())){
            message.reply(constantsList.get(message.getContent().split(" ")[1].toLowerCase()));
        }
    }

    @Override
    public String help() {
        return HELPTEXT;
    }

    @Override
    public void executed(boolean success, DiscordAPI api, Message message) {
        if(!success)
            message.reply("Unknown constant. Type \"!math showconstants\" to see a list of known constants");
    }

    private void addConstants() {
        constantsList.put("pi", "π ≈ " + String.valueOf(Math.PI));
        constantsList.put("e", String.valueOf(Math.E));
        constantsList.put("i", "√(-1)");
        constantsList.put("golden-ratio", "φ ≈ 1.61803 39887 49894 8482");
        constantsList.put("euler–mascheroni-constant", "γ ≈ 0.57721");
        constantsList.put("omega-constant", "Ω ≈ 0.56714 32904 09783 87299");
        constantsList.put("mao-constant", "mao = mu alpha theta = corrupt");
        constantsList.put("conways-constant", String.valueOf((char)955) + "≈ 1.30357 72690 34296 39125");
        constantsList.put("baguette", "The Rasiyani-Sollenberger constant (well known as \"Baguette\") = √π ≈ " + String.valueOf(Math.pow(Math.PI, 0.5)));
    }
}
