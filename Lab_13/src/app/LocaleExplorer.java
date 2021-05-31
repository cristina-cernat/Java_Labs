package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplorer {

    public static String baseName = "res.Messages";
    public static Locale locale;
    public static ResourceBundle resourceBundle;

    public static void main(String[] args) {
        run();
    }

    private static void run()
    {
        SetLocale.setLocale("ro-RO");
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println(" ");
            System.out.println(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit"))
                break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : {
                    DisplayLocales.displayLocales();
                    break;
                }
                case "set" : {
                    try {
                        if (params[1].equals("ro-RO") || params[1].equals("en-US"))
                            SetLocale.setLocale(params[1]);
                        else
                        {
                            System.out.println(message("tagWrong"));
                            break;
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
                case "info" : {
                    Info.info();
                    break;
                }
                default: System.out.println(message("invalid"));
            }
        }
    }

    public static String message(String key, String ... arguments)
    {
        String pattern = resourceBundle.getString(key);
        return new MessageFormat(pattern).format(arguments);
    }
}
