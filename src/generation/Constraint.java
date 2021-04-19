package generation;

import generation.classes.EvaluatorGenerator;
import generation.classes.PreferenceGenerator;
import generation.classes.RequirementGenerator;

import java.util.ArrayList;

class Constraint {
    protected final PreferenceGenerator preference;

    protected Constraint(PreferenceGenerator preference) {
        this.preference = preference;
    }

    public void prefer(double weight) {
        preference.add(weight);
    }

    public static RequireableConstraint courseName(String courseName) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.courseNameIn(courseName), String.format("Course %s expected but not found", courseName) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.courseNameIn(courseName), String.format("Taking course: %s",courseName));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint nCourseNames(int n, ArrayList<String> courseNames) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.nCourseNamesIn(n, courseNames), String.format("%d courses from [%s] required but not found", n, courseNames.toString()) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.nCourseNamesIn(n, courseNames), String.format("Taking %d courses from [%s]", n, courseNames.toString()));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

    public static RequireableConstraint leftBeforeRight(String left, String right) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.violatesLeftBeforeRight(left, right), String.format("Course %s must come before course %s", left, right) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.violatesLeftBeforeRight(left, right), String.format("Taking course %s before course %s", left, right));
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
    }

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

    final static Double TEN_AM = 600.0, NOON = 720.0, TWO_PM = 840.0;

    private static Constraint earlierClasses() {
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(EvaluatorGenerator.averageStartTime(), "Earlier classes", null, null, TWO_PM, TEN_AM);
        return new Constraint(preferenceGenerator);
    }
    private static Constraint laterClasses() {
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreSigmoid(EvaluatorGenerator.averageStartTime(), "Earlier classes", null, null, TEN_AM, TWO_PM);
        return new Constraint(preferenceGenerator);
    }
}

class RequireableConstraint extends Constraint {
    private final RequirementGenerator requirement;

    protected RequireableConstraint(RequirementGenerator requirement, PreferenceGenerator preference) {
        super(preference);
        this.requirement = requirement;
    }

    public void require() {
        requirement.add();
    }
}

