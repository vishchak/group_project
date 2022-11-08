package comparator;

import human_beings.Student;

import java.util.Comparator;

public class StudentLastnameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;

        String lastname1 = student1.getLastname();
        String lastname2 = student2.getLastname();

        if (lastname1.compareTo(lastname2) > 0) {
            return 1;
        } else if (lastname1.compareTo(lastname2) == 0) {
            return 0;
        }
        return -1;
    }
}
