package generation.classes;

import generation.classes.Constraint;
import generation.classes.PreferenceGenerator;
import generation.classes.RequirementGenerator;

public class RequireableConstraint extends Constraint {
    private final RequirementGenerator requirement;

    public RequireableConstraint(RequirementGenerator requirement, PreferenceGenerator preference) {
        super(preference);
        this.requirement = requirement;
    }

    public void require() {
        requirement.add();
    }
}
