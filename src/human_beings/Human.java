package human_beings;

import enums.Gender;

import java.util.Objects;

/**
 * Create a class that describes a person.
 */
public class Human {
    private String name;
    private String lastname;
    private Gender gender;

    public Human() {
    }

    public Human(String name, String lastname, Gender gender) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(lastname, human.lastname) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, gender);
    }

    @Override
    public String toString() {
        return
                "[name='" + name + '\'' +
                        ", lastname='" + lastname + '\'' +
                        ", gender=" + gender;
    }
}
