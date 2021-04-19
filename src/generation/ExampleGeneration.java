package generation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleGeneration {
    public static void main(String[] args) throws IOException {
        // Constraints
        RequireableConstraint courseName = Constraint.courseName("COS 120");
        RequireableConstraint nCourseNames = Constraint.nCourseNames(2, new ArrayList<String>(Arrays.asList("COS 120", "COS 121", "COS 143")));
        RequireableConstraint lBeforeR = Constraint.leftBeforeRight("COS 120", "COS 121");

        RequireableConstraint nCreditsForSemester = Constraint.nCreditsForSemester(15);
        RequireableConstraint nCreditsForPlan = Constraint.nCreditsForPlan(150);
        RequireableConstraint nCoursesForSemester = Constraint.nCoursesForSemester(15);
        RequireableConstraint nCoursesForPlan = Constraint.nCoursesForPlan(150);

        RequireableConstraint nCreditsGEForSemester = Constraint.nCreditsGreaterThanEqualForSemester(15, 200);
        RequireableConstraint nCreditsGEForPlan = Constraint.nCreditsGreaterThanEqualForPlan(150, 200);
        RequireableConstraint nCoursesGEForSemester = Constraint.nCoursesGreaterThanEqualForSemester(15, 200);
        RequireableConstraint nCoursesGEForPlan = Constraint.nCoursesGreaterThanEqualForPlan(150, 200);

        // Requirements
        courseName.require();
        nCourseNames.require();
        lBeforeR.require();

        nCreditsForSemester.require();
        nCreditsForPlan.require();
        nCoursesForSemester.require();
        nCoursesForPlan.require();

        nCreditsGEForSemester.require();
        nCreditsGEForPlan.require();
        nCoursesGEForSemester.require();
        nCoursesGEForPlan.require();

        // Preferences
        courseName.prefer(5.0);
        nCourseNames.prefer(10.0);
        lBeforeR.prefer(10.0);

        nCreditsForSemester.prefer(3.0);
        nCreditsForPlan.prefer(5.0);
        nCoursesForSemester.prefer(5.0);
        nCoursesForPlan.prefer(1.0);

        nCreditsGEForSemester.prefer(3.0);
        nCreditsGEForPlan.prefer(5.0);
        nCoursesGEForSemester.prefer(5.0);
        nCoursesGEForPlan.prefer(1.0);

        // Generate
        PythonGenerator.generate("test-data/generator/output/generated.py");
    }
}
