package human_beings;

import csv.CSVConverter;
import enums.Gender;

import java.util.Objects;

/**
 * Create a student class based on Human.
 * Define the toString() method for the group so that it lists the students in alphabetical order.
 */
public class Student extends Human implements CSVConverter {
    private String groupNumber;
    private Long id;

    public Student() {
    }

    public Student(String name, String lastname, Gender gender, Long id) {
        super(name, lastname, gender);
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toCSVString() {
        return super.getName() + ";" +
                super.getLastname() + ";" +
                super.getGender() + ";" +
                this.groupNumber + ";" +
                this.id + ";";
    }

    @Override
    public Student fromCSVString(String csv) {
        Student student = new Student();
        String[] elements = csv.split(";");

        student.setName(elements[0]);
        student.setLastname(elements[1]);
        student.setGender(Gender.valueOf(elements[2]));
        student.setGroupNumber(elements[3]);
        student.setId(Long.valueOf(elements[4]));

        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(groupNumber, student.groupNumber) && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupNumber, id);
    }

    @Override
    public String toString() {
        return super.toString() +
                " groupNumber='" + groupNumber + '\'' +
                ", id=" + id +
                ']';
    }
}
