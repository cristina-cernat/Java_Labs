package Lab_4;

import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<School> preferences;

    public Student(String name) {
        this.name = name;
    }

    public Student(List<School> preferences) {
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreferences(List<School> preferences) {
        this.preferences = preferences;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student s) {
        return s.getPreferences().size() - this.getPreferences().size();
    }
}
