package Lab_5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String location;
    private final Map<String, Object> tags = new HashMap<>();

    public Item(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;

    }

    public Item(String name) {
        this.name = name;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String id) {
        this.location = location;
    }

    public void writeObject(Catalog catalog) {


    }
}
