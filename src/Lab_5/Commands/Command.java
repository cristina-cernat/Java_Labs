package Lab_5.Commands;

import Lab_5.Catalog;
import Lab_5.InvalidCatalogException;

import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable {
    Catalog catalog;

    Command(Catalog catalog){
        this.catalog = catalog;
    }

    public abstract void execute(String[] args) throws IllegalArgumentException, IOException, InvalidCatalogException;
}