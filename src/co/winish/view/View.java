package co.winish.view;

import java.util.Locale;
import java.util.ResourceBundle;


public class View {
    static String MESSAGES_BUNDLE_NAME = "co.winish.messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("en"));
                    new Locale("ua", "UA"));


    public void printMessage(String message){
        System.out.println(message);
    }
}
