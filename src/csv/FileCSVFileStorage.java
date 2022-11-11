package csv;

import exceptions.GroupOverflowException;
import human_beings.Group;
import human_beings.Student;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * Refine a class describing a group of students, by adding the ability to save the group to a file;
 * Implement the reverse process. Those. read data about group from a file, and on their basis create an object of type group.
 * Add search for a file with the group name in the working directory function;
 */
public class FileCSVFileStorage implements CSVConverter.FileCSV<Group> {

    @Override
    public void saveToFileSCV(Group group) throws IOException {
        List<Student> students = group.getStudents();
        StringBuilder sb = new StringBuilder();
        for (Student st :
                students) {
            if (st != null) {
                sb.append(st.toCSVString()).append("\n");
            }
        }
        File file = new File(group.getGroupNumber() + ".csv");
        Writer pw = new PrintWriter(file);
        pw.write(sb.toString());
        pw.close();
    }

    @Override
    public Group loadFromFileCSV(File fileSCV) throws IOException, GroupOverflowException {
        Group group = new Group();

        if (fileSCV.exists()) {
            Reader rd = new FileReader(fileSCV);
            char[] chars = new char[1000];

            rd.read(chars);
            rd.close();

            String[] csv = String.valueOf(chars).split("\n");

            for (int i = 0; i < csv.length - 1; i++) {
                if (!csv[i].equals("")) {
                    Student student = new Student().fromCSVString(csv[i]);
                    group.addStudent(student);
                    group.setGroupNumber(student.getGroupNumber());
                }
            }
        }
        return group;
    }


    @Override
    public File findFileByName(String groupName, File workFolder) {
        if (workFolder.isDirectory()) {
            File[] files = workFolder.listFiles();
            if (Objects.requireNonNull(files).length > 0) {
                for (File f :
                        files) {
                    String[] fileName = f.getName().split("\\.");
                    if (groupName.equals(fileName[0]))
                        return f;
                }
            }
        }
        return null;
    }
}
