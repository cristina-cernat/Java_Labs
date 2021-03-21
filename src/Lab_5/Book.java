package Lab_5;

public class Book extends Item{
    public Book(String name) {
        super(name);
    }

    public Book(String id, String name, String location) {
        super(id, name, location);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public String getLocation() {
        return super.getLocation();
    }
}
