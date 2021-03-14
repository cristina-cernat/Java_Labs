package Lab_4;

public class School implements Comparable<School>{
    private final int capacity;
    private final String name;

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    public String getSchoolName() {
        return name;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append(" capacity = ").append(capacity);

        return str.toString();
    }

    @Override
    public int compareTo(School o) {
        return this.name.compareTo(o.getSchoolName());
    }
}