package generation;

class Constraint {
    private final RequirementGenerator requirement;
    private final PreferenceGenerator preference;

    private Constraint(RequirementGenerator requirement, PreferenceGenerator preference) {
        this.requirement = requirement;
        this.preference = preference;
    }

    public void require() {
        requirement.add();
    }

    public void prefer(double weight) {
        preference.add(weight);
    }

    public static Constraint courseName(String courseName) {
        RequirementGenerator requirementGenerator = RequirementGenerator.assertTrue(EvaluatorGenerator.courseNameIn(courseName), String.format("Course '%s' expected but not found", courseName) );
        PreferenceGenerator preferenceGenerator = PreferenceGenerator.scoreBoolean(EvaluatorGenerator.courseNameIn(courseName), String.format("Taking course: %s",courseName));
        return new Constraint(requirementGenerator, preferenceGenerator);
    }
}

