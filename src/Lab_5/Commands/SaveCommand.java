package Lab_5.Commands;

import Lab_5.Catalog;

import java.io.IOException;

public class SaveCommand extends Command{
    private static SaveCommand instance;
    public static Command getInstance() {
        if (instance == null){
            instance = new SaveCommand(Catalog.getInstance());
        }
        return instance;
    }
    private SaveCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException, IOException {

    }
}
