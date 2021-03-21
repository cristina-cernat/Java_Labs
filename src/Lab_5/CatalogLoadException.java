package Lab_5;

public class CatalogLoadException extends Exception{
    public CatalogLoadException(){
        super("Couldn't load catalog");
    }
}
