package generation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExampleGeneration {
    public static void main(String[] args) throws IOException {
        // Requirements
        Constraint.courseName("COS 120").require();

        // Preferences
        Constraint.courseName("COS 121").prefer(1.0);

        File output = new File("generated.py");
        output.createNewFile();
        FileWriter writer = new FileWriter(output);
        PythonGenerator.generate(writer); // <-- Generation
        writer.flush();
        writer.close();
    }
}
