package group;

public class Student extends Human {
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
    public String toString() {
        return super.toString() + " Student[" +
                "groupNumber='" + groupNumber + '\'' +
                ", id=" + id +
                ']';
    }
}
