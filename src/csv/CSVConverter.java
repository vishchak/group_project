package csv;

import exceptions.GroupOverflowException;
import human_beings.Student;

import java.io.File;
import java.io.IOException;

public interface CSVConverter {

    interface FileCSV<T> {
        void saveToFileSCV(T t) throws IOException;

        T loadFromFileCSV(File fileSCV) throws IOException, GroupOverflowException;

        File findFileByName(String fileName, File workFolder);
    }

    String toCSVString();

    Student fromCSVString(String csv);
}
