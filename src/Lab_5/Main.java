package Lab_5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }

        Shell shell = Shell.getInstance();
        shell.execute();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("My Books",
                "D:/0.Uni/Java/Other/catalog.txt");

        Item song = new Song("1", "Orange", "D:/Musicc/Nyarons_Orange.mp3");
        Item book = new Book("2");
        book.setLocation("D:/0.Uni/Java/Other/Cristian_Frasinaru-Curs_practic_de_Java.pdf");
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("D:/0.Uni/Java/Other/catalog.txt");
        CatalogUtil.view(catalog.findById("2"));
    }


}
