package Lab_4;

import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {
        Student[] createStudents = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        List<Student> students = Arrays.asList(new Student("S1"), new Student("S0"),
                new Student("S2"), new Student("S4"));
        List<School> schools = Arrays.asList(new School("H1", 1), new School("H0", 2),
                new School("H2", 2));


        List<Student> linkedListStudents = new LinkedList<>(students);
        // Comparator sort
        Collections.sort(linkedListStudents, new StudentComparator());
        linkedListStudents.forEach(System.out::println);

        Set<School> treeSetSchools = new TreeSet<>(schools);

        treeSetSchools.forEach(System.out::println);

        Map<School, List<Student>> schoolPreference = new HashMap<>();
        List<Student> prefList1 = new ArrayList<>();
        prefList1.add(students.get(0));
        prefList1.add(students.get(1));
        prefList1.add(students.get(2));

        schoolPreference.put(schools.get(0), prefList1);
        System.out.println(schoolPreference);

    }
}
