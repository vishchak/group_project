import exceptions.GroupOverflowException;
import exceptions.NoSuchStudentException;
import group.Gender;
import group.Group;
import group.Student;

public class Main {
    /**
     * 1) Create a class that describes a person.
     * 2) Create a student class based on it.
     * 3) Create a Group class which contains an array of 10 objects of class Student. Implement add method, delete a student method and a find a student by last name method.
     * if trying to add 11th student, create own exception and handle it.
     */
    public static void main(String[] args) {


        Student student1 = new Student("Denis", "Vishchak", Gender.MALE, 123L);
        Student student2 = new Student("Robert", "Paulson", Gender.MALE, 132L);
        Student student3 = new Student("Marla", "Singer", Gender.FEMALE, 213L);
        Student student4 = new Student("Tyler", "Durden", Gender.MALE, 231L);
        Student student5 = new Student("Brad", "Pitt", Gender.MALE, 312L);
        Student student6 = new Student("Gwyneth", "Paltrow", Gender.FEMALE, 321L);
        Student student7 = new Student("Anthony", "Hopkins", Gender.MALE, 234L);
        Student student8 = new Student("Christian", "Bale", Gender.MALE, 324L);
        Student student9 = new Student("Jack", "Nicholson", Gender.MALE, 1423L);
        Student student10 = new Student("Bruce", "Willis", Gender.MALE, 1432L);
        Student student11 = new Student("NAMELESS", "VOID", Gender.OTHER, 404L);


        Group group1 = new Group("402");

        try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student10);
            group1.addStudent(student11);
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
            group1.deleteStudent(1432L);
        } catch (NoSuchStudentException e) {
            System.err.println("There is no student with id: " + id);
        }
    }
}