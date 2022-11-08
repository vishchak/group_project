package csv;

import human_beings.Student;

public interface CSVConverter {
    String toCSVString();
    Student fromCSVString(String csv);
}
