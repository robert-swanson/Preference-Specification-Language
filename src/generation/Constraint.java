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
        RequirementGenerator requirementGenerator = RequirementGenerator.assertEquals(EvaluatorGenerator.totalCredits(), Integer.toString(n), String.format("%d credits required for semester", n) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreOptimum(EvaluatorGenerator.totalCredits(), String.format("Prefer %d credits for semester", n), Integer.toString(n), null, 1.0, null, null, null, null);
        return new RequireableConstraint(requirementGenerator, preferenceGenerator);
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

