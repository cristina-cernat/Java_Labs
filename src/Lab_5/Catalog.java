package Lab_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    ArrayList<Item> items;
    private static Catalog instance;
    
    public static Catalog getInstance()
    {
        if (instance == null)
            instance = new Catalog();

        return instance;
    }
    public Catalog() {items = new ArrayList<>();}
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Catalog(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}