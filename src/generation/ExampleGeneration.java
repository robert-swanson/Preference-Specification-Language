package generation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleGeneration {
    public static void main(String[] args) throws IOException {
        // Requirements
        Constraint.courseName("COS 120").require();
        Constraint.courseName("COS 121").require();
        Constraint.nCourseNames(2, new ArrayList<String>(Arrays.asList("COS 120", "COS 121", "COS 143"))).require();
        Constraint.leftBeforeRight("COS 120", "COS 121").require();


        // Preferences
        Constraint.courseName("COS 121").prefer(1.0);
        Constraint.nCreditsForSemester(15).prefer(10); // TODO: n credits in plan, courses in plan/semester

        File output = new File("test-data/generator/output/generated.py");
        output.createNewFile();
        FileWriter writer = new FileWriter(output);
        PythonGenerator.generate(writer); // <-- Generation
        writer.flush();
        writer.close();
    }
}
