package Lab_5.Commands;

import Lab_5.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand extends Command{
    private static PlayCommand instance;
    public static Command getInstance() {
        if (instance == null){
            instance = new PlayCommand(Catalog.getInstance());
        }
        return instance;
    }
    private PlayCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IOException {

        catalog = Catalog.getInstance();
        Desktop desktop = Desktop.getDesktop();

//        try {
//            File file = new File(item.getLocation()); // TODO
//            desktop.open(file);
//        } catch (IOException ex) {
//            System.out.println("No application registered for PDFs");
//        }
    }
}
