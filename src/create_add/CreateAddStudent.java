package create_add;

import enum_human.Gender;
import human_beings.Student;

import java.util.Scanner;

/**\
 * Create a new class, which implements inputting student's info from keyboard;
 * creates a student based on the inputted info;
 * use the clas's methods in "Group" class
 */
public class CreateAddStudent implements CreateAddInterface {
    @Override
    public Student create() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Input student's name");
        student.setName(sc.nextLine());

        System.out.println("input student's lastname");
        student.setLastname(sc.nextLine());

        System.out.println("""
                Choose student's gender:
                Male - type '1'
                Female - type '2'
                Other - type '3'""");
        int gender = sc.nextInt();
        switch (gender) {
            case 1:
                student.setGender(Gender.MALE);
                break;
            case 2:
                student.setGender(Gender.FEMALE);
            default:
                student.setGender(Gender.OTHER);
        }
        System.out.println("Input student's id");
        student.setId(sc.nextLong());

        return student;
    }
}
