package generation;

import generation.classes.Constraint;
import generation.classes.EvaluatorGenerator;
import generation.classes.RequireableConstraint;
import generation.classes.Scope;
import generation.conditions.Condition;

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

        Condition cos120Condition = new Condition(EvaluatorGenerator.courseNameIn("COS 120"));
        Condition cos121Condition = new Condition(EvaluatorGenerator.courseNameIn("COS 121"));
        Condition cos143Condition = new Condition(EvaluatorGenerator.courseNameIn("COS 143"));
        Condition combinedCondition = cos120Condition.and(cos121Condition.or(cos143Condition));
        Scope ifBlock = Scope.ifBlock(combinedCondition, "COS 120 and one of COS 121 or COS 143");
        Scope whenBlock = Scope.whenBlock(combinedCondition, "COS 120 and one of COS 121 or COS 143");


        // Requirements
        courseName.require();
        nCourseNames.require();
        lBeforeR.require();

        ifBlock.require();
        nCredits.require();
        ifBlock.close();

        whenBlock.require();
        nCourses.require();
        whenBlock.close();

        nCreditsGE.require();

        // Preferences
        courseName.prefer(5.0);
        nCourseNames.prefer(10.0);
        lBeforeR.prefer(10.0);

        ifBlock.prefer();
        nCredits.prefer(3.0);
        ifBlock.close();

        whenBlock.prefer();
        nCourses.prefer(4.2);
        whenBlock.close();

        nCreditsGE.prefer(18.0);

        earlierClasses.prefer(3.0);
        laterClasses.prefer(3.0);

        // Generate
        PythonGenerator.generate("test-data/generator/output/generated.py");
    }
}
