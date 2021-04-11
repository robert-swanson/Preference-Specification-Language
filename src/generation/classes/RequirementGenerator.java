package generation.classes;

import generation.PythonGenerator;

public class RequirementGenerator {
    String pythonValidation;
    private RequirementGenerator(String pythonValidation) {
        this.pythonValidation = pythonValidation;
    }

    public void add() {
        PythonGenerator.getValidatePlanGenerator().addLine(pythonValidation);
    }

    public static RequirementGenerator assertTrue(String value, String message) {
        return new RequirementGenerator(String.format("validator.assertTrue(%s, '%s')", value, message));
    }

    public static RequirementGenerator assertFalse(String value, String message) {
        return new RequirementGenerator(String.format("validator.assertFalse(%s, '%s')", value, message));
    }

    public static RequirementGenerator assertEquals(String value, String message) {
        return new RequirementGenerator(String.format("validator.assertFalse(%s, '%s')", value, message));
    }

}
