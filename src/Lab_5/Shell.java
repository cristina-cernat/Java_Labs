package Lab_5;

import Lab_5.Commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shell {

    static private Shell instance;


    static public Shell getInstance(){
        if (instance == null){
            instance = new Shell();
        }
        return instance;
    }

    public HashMap<String, Command> getCommands(){
        return commands;
    }

    HashMap<String, Command> commands;
    Catalog catalog;
    private Shell(){
        commands = new HashMap<>();
        commands.put("add", AddCommand.getInstance());
        commands.put("list", ListCommand.getInstance());
        commands.put("play", PlayCommand.getInstance());
        commands.put("save", SaveCommand.getInstance());
        commands.put("load", LoadCommand.getInstance());

        catalog = Catalog.getInstance();
    }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) continue;
            String[] args = splitArguments(line);

            if (args[0].equals("exit")) {
                return;
            }

            if (!commands.containsKey(args[0])) {
                System.out.println("Command does not exist.");
                continue;
            }

            try {
                commands.get(args[0]).execute(args);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private String[] splitArguments(String line) {
        StringBuilder builder = new StringBuilder();
        ArrayList<String> args = new ArrayList<>();

        boolean inQuotes = false;
        for (int i = 0; i < line.length(); ++i){
            char c = line.charAt(i);
            if (c == '\"'){
                inQuotes = !inQuotes;
            }
            else if (c == ' '){
                if (inQuotes){
                    builder.append(c);
                }
                else{
                    if (builder.length() > 0){
                        args.add(builder.toString());
                    }
                    builder.setLength(0);
                }
            }
            else{
                builder.append(c);
            }
        }
        if (builder.length() > 0){
            args.add(builder.toString());
        }
        String[] strings = new String[args.size()];
        strings = args.toArray(strings);
        return strings;
    }
}
