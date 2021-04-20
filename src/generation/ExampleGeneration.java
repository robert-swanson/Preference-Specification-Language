package generation;

import generation.classes.Constraint;
import generation.classes.EvaluatorGenerator;
import generation.classes.RequireableConstraint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleGeneration {
    public static void main(String[] args) throws IOException {
        // Constraints
        RequireableConstraint courseName = Constraint.courseName("COS 120");
        RequireableConstraint nCourseNames = Constraint.nCourseNames(2, new ArrayList<String>(Arrays.asList("COS 120", "COS 121", "COS 143")));
        RequireableConstraint lBeforeR = Constraint.leftBeforeRight("COS 120", "COS 121");

        RequireableConstraint nCredits = Constraint.equalTo(EvaluatorGenerator.totalCredits(), 15, 2.0, String.format("%d credits", 15));
        RequireableConstraint nCourses = Constraint.equalTo(EvaluatorGenerator.totalCourses(), 5, 1.0, String.format("%d courses", 5));

        RequireableConstraint nCreditsGE = Constraint.greaterThan(EvaluatorGenerator.totalCreditGreaterThanEqualToCourseNumber(200), 80.0, 5, String.format("More than %d credits over %d", 80, 200));

        Constraint earlierClasses = Constraint.earlierClasses();
        Constraint laterClasses = Constraint.laterClasses();

        // Requirements
        courseName.require();
        nCourseNames.require();
        lBeforeR.require();

        nCredits.require();
        nCourses.require();
        nCreditsGE.require();

        // Preferences
        courseName.prefer(5.0);
        nCourseNames.prefer(10.0);
        lBeforeR.prefer(10.0);

        nCredits.prefer(3.0);
        nCourses.prefer(4.2);
        nCreditsGE.prefer(18.0);

        earlierClasses.prefer(3.0);
        laterClasses.prefer(3.0);

        // Generate
        PythonGenerator.generate("test-data/generator/output/generated.py");
    }
}
