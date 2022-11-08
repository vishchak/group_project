import exceptions.GroupOverflowException;
import exceptions.NoSuchStudentException;
import enum_human.Gender;
import human_beings.Group;
import human_beings.Student;

public class Main {
    public static void main(String[] args) {


        Student student1 = new Student("Denis", "Vishchak", Gender.MALE, 123L);
        Student student2 = new Student("Bruce", "Willis", Gender.MALE, 1432L);
        Student student3 = new Student("John", "Travolta", Gender.FEMALE, 213L);
        Student student4 = new Student("Mark", "Wahlberg", Gender.MALE, 231L);
        Student student5 = new Student("Brad", "Pitt", Gender.MALE, 312L);
        Student student6 = new Student("Gwyneth", "Paltrow", Gender.FEMALE, 321L);
        Student student7 = new Student("Anthony", "Hopkins", Gender.MALE, 234L);
        Student student8 = new Student("Christian", "Bale", Gender.MALE, 324L);
        Student student9 = new Student("Jack", "Nicholson", Gender.MALE, 1423L);
        Student student10 = new Student("NAMELESS", "VOID", Gender.OTHER, 404L);


        Group group1 = new Group("402");

        try {
            group1.addStudent(student1);
            group1.addStudent();
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student2);
            group1.addStudent(student10);

        } catch (GroupOverflowException e) {
            System.out.println("the group is full");
        }

        System.out.println();
        for (Student st :
                group1.getStudents()) {
            System.out.println(st);
        }

        System.out.println();

        String searchLastname = "Vishchak";
        try {
            System.out.println(group1.searchStudent(searchLastname));
        } catch (NoSuchStudentException e) {
            System.err.println("There is no such a student " + searchLastname);
        }

        System.out.println();

        Long id = 123L;
        try {
            group1.deleteStudent(id);
            group1.deleteStudent(213L);
        } catch (NoSuchStudentException e) {
            System.err.println("There is no student with id: " + id);
        }

        System.out.println();

        System.out.println(group1);
    }
}