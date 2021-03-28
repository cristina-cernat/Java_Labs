package Lab_5.Commands;

import Lab_5.Catalog;

import java.io.IOException;

public class ListCommand extends Command{
    private static ListCommand instance;
    public static Command getInstance() {
        if (instance == null){
            instance = new ListCommand(Catalog.getInstance());
        }
        return instance;
    }

    private ListCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IOException {

    }
}
