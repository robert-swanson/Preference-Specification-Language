package generation;

import generation.classes.Constraint;
import generation.classes.EvaluatorGenerator;
import generation.classes.RequireableConstraint;
import generation.classes.Scope;
import generation.classes.Condition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleGeneration {
    public static void main(String[] args) throws IOException {
        boolean invert = true;
        // Constraints
        RequireableConstraint courseName = Constraint.courseName("COS 120", invert);
        RequireableConstraint nCourseNames = Constraint.nCourseNames(2, new ArrayList<String>(Arrays.asList("COS 120", "COS 121", "COS 143")), invert);
        RequireableConstraint lBeforeR = Constraint.leftBeforeRight("COS 120", "COS 121", invert);
        RequireableConstraint lBeforeMR = Constraint.multiLeftBeforeRight(new ArrayList<String>(Arrays.asList("COS 120", "COS 143")), "COS 121", invert);

        RequireableConstraint nCredits = Constraint.equalTo(EvaluatorGenerator.totalCredits(), 15, 2.0, invert, String.format("%d credits", 15) );
        RequireableConstraint nCourses = Constraint.equalTo(EvaluatorGenerator.totalCourses(), 5, 1.0, invert, String.format("%d courses", 5));

        RequireableConstraint nCreditsGE = Constraint.greaterThan(EvaluatorGenerator.totalCreditsGreaterThanEqualToCourseNumber(200), 80.0, 5, invert, String.format("More than %d credits over %d", 80, 200));

        Constraint earlierClasses = Constraint.earlierClasses(invert);
        Constraint laterClasses = Constraint.laterClasses(invert);

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
        lBeforeMR.require();

        ifBlock.open();
        nCredits.require();
        ifBlock.close();

        whenBlock.open();
        nCourses.require();
        whenBlock.close();

        nCreditsGE.require();

        // Preferences
        courseName.prefer(5.0);
        nCourseNames.prefer(10.0);
        lBeforeR.prefer(10.0);

//        ifBlock.prefer();
        ifBlock.open();
        nCredits.prefer(3.0);
        ifBlock.close();

//        whenBlock.prefer();
        whenBlock.open();
        nCourses.prefer(4.2);
        whenBlock.close();

        nCreditsGE.prefer(18.0);

        earlierClasses.prefer(3.0);
        laterClasses.prefer(3.0);

        // Generate
        PythonGenerator.generate("test-data/generator/output/generated.py");
    }
}
