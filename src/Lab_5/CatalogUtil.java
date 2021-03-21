package Lab_5;

import java.awt.*;
import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog catalog = null;
        try (
                FileInputStream fileIn = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ) {
            catalog = (Catalog) in.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new InvalidCatalogException(e);
        }
        return catalog;
    }


    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();

        try {
            File file = new File(item.getLocation());
            desktop.open(file);
        } catch (IOException ex) {
            System.out.println("No application registered for PDFs");
        }

    }
}