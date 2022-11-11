package comparator;

import human_beings.Student;

import java.util.Comparator;

public class StudentLastnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        String lastname1 = o1.getLastname();
        String lastname2 = o2.getLastname();

        if (lastname1.compareTo(lastname2) > 0) {
            return 1;
        } else if (lastname1.compareTo(lastname2) == 0) {
            return 0;
        }
        return -1;
    }
}
