package Lab_5.Commands;

import Lab_5.Catalog;
import Lab_5.InvalidCatalogException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadCommand extends Command{
    private static LoadCommand instance;
    public static Command getInstance() {
        if (instance == null){
            instance = new LoadCommand(Catalog.getInstance());
        }
        return instance;
    }
    private LoadCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IOException, InvalidCatalogException {
        if (args.length < 2){
            throw new IllegalArgumentException("2 arguments are required"); // TODO load command workflow??
        }

        if (!args[0].equals("load")){
            throw new IllegalArgumentException("Invalid command name");
        }

        Catalog catalog = null;
        Path path = Paths.get(args[1]);
        try (
                FileInputStream fileIn = new FileInputStream(String.valueOf(path));
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ) {
            catalog = (Catalog) in.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new InvalidCatalogException(e);
        }

    }
}
