package generation.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Constraint {
    protected final PreferenceGenerator preference;

    public Constraint(PreferenceGenerator preference) {
        this.preference = preference;
    }

    public void prefer(double weight) {
        preference.add(weight);
    }

    public static RequireableConstraint equalTo(String value, double expected, double deviance, String description) {
        OptimumParameters params = new OptimumParameters(expected, new SoftBound(deviance));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreOptimum(value, description, params);
        RequirementGenerator requirementGenerator = RequirementGenerator.assertEquals(value, Double.toString(expected), description);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint greaterThan(String value, double min, double deviance, String description) {
        SigmoidParameters params = new SigmoidParameters(new SoftBound(min), new SoftBound(min+deviance));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(value, description, params);
        RequirementGenerator requirementGenerator = RequirementGenerator.assertGreaterThan(value, Double.toString(min), description);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint lessThan(String value, double max, double deviance, String description) {
        SigmoidParameters params = new SigmoidParameters(new SoftBound(max), new SoftBound(max-deviance));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(value, description, params);
        RequirementGenerator requirementGenerator = RequirementGenerator.assertLessThan(value, Double.toString(max), description);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint greaterThanOrEqualTo(String value, double min, double deviance, String description) {
        SigmoidParameters params = new SigmoidParameters(new SoftBound(min-deviance), new SoftBound(min));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(value, description, params);
        RequirementGenerator requirementGenerator = RequirementGenerator.assertGreaterThanEqual(value, Double.toString(min), description);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint lessThanOrEqualTo(String value, double max, double deviance, String description) {
        SigmoidParameters params = new SigmoidParameters(new SoftBound(max+deviance), new SoftBound(max));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(value, description, params);
        RequirementGenerator requirementGenerator = RequirementGenerator.assertLessThanEqual(value, Double.toString(max), description);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint courseName(String courseName) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.courseNameIn(courseName), String.format("Course %s expected but not found", courseName) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.courseNameIn(courseName), String.format("Taking course: %s",courseName));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint nCourseNames(int n, ArrayList<String> courseNames) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.nCourseNamesIn(n, courseNames), String.format("%d courses from %s required but not found", n, courseNames.toString()) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.nCourseNamesIn(n, courseNames), String.format("Taking %d courses from %s", n, courseNames.toString()));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint leftBeforeRight(String left, String right) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.violatesLeftBeforeRight(left, right), String.format("Course %s must come before course %s", left, right) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.violatesLeftBeforeRight(left, right), String.format("Taking course %s before course %s", left, right));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    /*
    public static RequireableConstraint nCreditsForSemester(int n) {
        return nCreditsConstraintGreaterThanEqualToCourseNumberWithDev(n, 0, 1.0, String.format("%d credits required for semester", n), String.format("%d credits preferred for semester", n));
    }

    public static RequireableConstraint nCreditsForPlan(int n) {
        return nCreditsConstraintGreaterThanEqualToCourseNumberWithDev(n, 0, 10.0, String.format("%d credits required for plan", n), String.format("%d credits preferred for plan", n));
    }

    public static RequireableConstraint nCoursesForSemester(int n) {
        return nCoursesConstraintGreaterThanEqualToWithDev(n, 0, 1.0, String.format("%d courses required for semester", n), String.format("%d courses preferred for semester", n));
    }

    public static RequireableConstraint nCoursesForPlan(int n) {
        return nCoursesConstraintGreaterThanEqualToWithDev(n, 0, 10.0, String.format("%d courses required for plan", n), String.format("%d courses preferred for plan", n));
    }

    public static RequireableConstraint nCreditsGreaterThanEqualForSemester(int n, int courseNumber) {
        return nCreditsConstraintGreaterThanEqualToCourseNumberWithDev(n, courseNumber, 1.0, String.format("%d credits over level %d required for semester", n, courseNumber), String.format("%d credits over level %d preferred for semester", n, courseNumber));
    }

    public static RequireableConstraint nCreditsGreaterThanEqualForPlan(int n, int courseNumber) {
        return nCreditsConstraintGreaterThanEqualToCourseNumberWithDev(n, courseNumber, 10.0, String.format("%d credits over level %d required for plan", n, courseNumber), String.format("%d credits over level %d preferred for plan", n, courseNumber));
    }

    public static RequireableConstraint nCoursesGreaterThanEqualForSemester(int n, int courseNumber) {
        return nCoursesConstraintGreaterThanEqualToWithDev(n, courseNumber, 1.0, String.format("%d courses over level %d required for semester", n, courseNumber), String.format("%d courses over level %d preferred for semester", n, courseNumber));
    }

    public static RequireableConstraint nCoursesGreaterThanEqualForPlan(int n, int courseNumber) {
        return nCoursesConstraintGreaterThanEqualToWithDev(n, courseNumber, 10.0, String.format("%d courses over level %d required for plan", n, courseNumber), String.format("%d courses preferred for plan", n, courseNumber));
    }

    private static RequireableConstraint nCreditsConstraintGreaterThanEqualToCourseNumberWithDev(int n, int courseNumber, double deviation, String requirementDesc, String preferenceDesc) {
        RequirementGenerator requirementGenerator;
        PreferenceGenerator preferenceGenerator;
        if (courseNumber > 0) {
            requirementGenerator = RequirementGenerator.assertEquals(EvaluatorGenerator.totalCreditGreaterThanEqualToCourseNumber(courseNumber), Integer.toString(n), requirementDesc);
            preferenceGenerator = PreferenceGenerator.scoreOptimum(EvaluatorGenerator.totalCreditGreaterThanEqualToCourseNumber(courseNumber), preferenceDesc, Integer.toString(n), null, deviation, null, null, null, null);
        } else {
            requirementGenerator = RequirementGenerator.assertEquals(EvaluatorGenerator.totalCredits(), Integer.toString(n), requirementDesc);
            preferenceGenerator = PreferenceGenerator.scoreOptimum(EvaluatorGenerator.totalCredits(), preferenceDesc, Integer.toString(n), null, deviation, null, null, null, null);
        }
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    private static RequireableConstraint nCoursesConstraintGreaterThanEqualToWithDev(int n, int courseNumber, double deviation, String requirementDesc, String preferenceDesc) {
        RequirementGenerator requirementGenerator;
        PreferenceGenerator preferenceGenerator;
        if (courseNumber > 0) {
            requirementGenerator = RequirementGenerator.assertEquals(EvaluatorGenerator.totalCoursesGreaterThanEqualToCourseNumber(courseNumber), Integer.toString(n), requirementDesc);
            preferenceGenerator = PreferenceGenerator.scoreOptimum(EvaluatorGenerator.totalCoursesGreaterThanEqualToCourseNumber(courseNumber), preferenceDesc, Integer.toString(n), null, deviation, null, null, null, null);
        } else {
            requirementGenerator = RequirementGenerator.assertEquals(EvaluatorGenerator.totalCourses(), Integer.toString(n), requirementDesc);
            preferenceGenerator = PreferenceGenerator.scoreOptimum(EvaluatorGenerator.totalCourses(), preferenceDesc, Integer.toString(n), null, deviation, null, null, null, null);
        }
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }
     */

    final static Double TEN_AM = 600.0, NOON = 720.0, TWO_PM = 840.0;

    public static Constraint earlierClasses() {
        SigmoidParameters parameters = new SigmoidParameters(new SoftBound(TWO_PM), new SoftBound(TEN_AM));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(EvaluatorGenerator.averageStartTime(), "Earlier classes", parameters);
        return new Constraint(preferenceGenerator);
    }
    public static Constraint laterClasses() {
        SigmoidParameters parameters = new SigmoidParameters(new SoftBound(TEN_AM), new SoftBound(TWO_PM));
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(EvaluatorGenerator.averageStartTime(), "Later classes", parameters);
        return new Constraint(preferenceGenerator);
    }
}


