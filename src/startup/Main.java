package startup;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
/**
 * Created by Adil on 3/25/2017.
 */
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        try {
            AugmentBot bot = new AugmentBot();
            System.out.println("Launch Successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to instantiate bot... Check internet connection and try again");
        }


    }

}
