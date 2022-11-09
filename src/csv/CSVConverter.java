package csv;

import exceptions.GroupOverflowException;
import human_beings.Student;

import java.io.File;
import java.io.IOException;

public interface CSVConverter {

    interface GroupCSV {
        void saveGroupToSCV(human_beings.Group gr) throws IOException;

        human_beings.Group loadFGroupFromCSV(File fileSCV) throws IOException, GroupOverflowException;

        File findFileByGroupName(String groupName, File workFolder);
    }

    String toCSVString();

    Student fromCSVString(String csv);
}
