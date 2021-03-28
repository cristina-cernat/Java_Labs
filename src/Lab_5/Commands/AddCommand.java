package Lab_5.Commands;

import Lab_5.Catalog;
import Lab_5.Item;
import Lab_5.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddCommand extends Command{


    private static AddCommand instance;
    public static Command getInstance() {
        if (instance == null){
            instance = new AddCommand(Catalog.getInstance());
        }
        return instance;
    }

    AddCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IOException {
        if (args.length < 1){
            throw new IllegalArgumentException("1 argument is required");
            // TODO add command workflow? How do I access the Item?
        }

        if (!args[0].equals("add")){
            throw new IllegalArgumentException("Invalid command name");
        }

//        Item song = new Song("1", "Orange", "D:/Musicc/Nyarons_Orange.mp3");
//        catalog.add(song);

    }
}
