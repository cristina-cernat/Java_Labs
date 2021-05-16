import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Person> list = new ArrayList<>();

    public SocialNetwork() {}
    public void addPerson(Person person) {
        this.list.add(person);
    }
    public List<Person> getList() {return list;}

}
