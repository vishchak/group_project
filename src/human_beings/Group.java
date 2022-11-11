package human_beings;

import comparator.StudentLastnameComparator;
import create_add.CreateAddStudent;
import exceptions.GroupOverflowException;
import exceptions.NoSuchStudentException;

import java.util.*;

/**
 * Create a Group class which contains an array of 10 objects of class Student. Implement add method, delete a student method and a find a student by last name method.
 * if trying to add 11th student, create own exception and handle it.
 * Define the toString() method for the group so that it lists the students in alphabetical order.
 */
public class Group {
    public static void sortStudentsByLastName(List<Student> students) {
        students.sort(Comparator.nullsLast(new StudentLastnameComparator()));
    }

    private List<Student> students = new ArrayList<>(10);
    private String groupNumber;

    public Group() {
    }

    public Group(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (students.size() == 10) {
            System.err.println(student.getLastname() + " was not added");
            throw new GroupOverflowException();
        }
        students.add(student);
        student.setGroupNumber(this.groupNumber);
        System.out.println(student.getLastname() + " has been added");
    }

    public void addStudent() throws GroupOverflowException {
        if (students.size() == 10) {
            throw new GroupOverflowException();
        }
        Student student = CreateAddStudent.create();
        student.setGroupNumber(this.groupNumber);
        students.add(student);
        System.out.println(student.getLastname() + " has been added" + '\n');
    }


    public void deleteStudent(Long id) throws NoSuchStudentException {
        List<Student> toRemove = new ArrayList<>();
        for (Student st :
                students) {
            if (st.getId().equals(id)) {
                toRemove.add(st);
            }
        }
        if (toRemove.isEmpty()) throw new NoSuchStudentException();
        this.students.removeAll(toRemove);
    }

    public Student searchStudent(String lastName) throws NoSuchStudentException {
        if (students.isEmpty()) {
            throw new NoSuchStudentException();
        }
        for (Student student :
                students) {
            if (student.getLastname().equals(lastName)) {
                return student;
            } else throw new NoSuchStudentException();
        }
        return null;
    }

    public void ifEquals() throws NoSuchStudentException {
        List<Student> newList = new ArrayList<>();
        for (Student st :
                students) {
            if (!newList.contains(st)) {
                newList.add(st);
            }
        }
        students.clear();
        students.addAll(newList);
        System.out.println(newList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(students, group.students) && Objects.equals(groupNumber, group.groupNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, groupNumber);
    }

    @Override
    public String toString() {
        Group.sortStudentsByLastName(this.students);
        return " Group[ " + students.toString() +
                ", groupNumber='" + groupNumber + '\'' +
                ']';
    }
}
