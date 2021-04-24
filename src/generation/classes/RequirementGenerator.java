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

    public static RequirementGenerator assertTrue(String value, String message, boolean invert) {
        if (invert) return assertFalse(value, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue(%s, '%s')", value, message));
    }

    public static RequirementGenerator assertFalse(String value, String message, boolean invert) {
        if (invert) return assertTrue(value, message, false);
        return new RequirementGenerator(String.format("validator.assertFalse(%s, '%s')", value, message));
    }

    public static RequirementGenerator assertEquals(String value, String expected, String message, boolean invert) {
        if (invert) return assertNotEquals(value, expected, message, false);
        return new RequirementGenerator(String.format("validator.assertEquals(%s, %s, '%s')", value, expected, message));
    }
    public static RequirementGenerator assertNotEquals(String value, String invalid, String message, boolean invert) {
        if (invert) return assertEquals(value, invalid, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue(%s != %s, '%s')", value, invalid, message));
    }

    public static RequirementGenerator assertGreaterThanEqual(String value, String min, String message, boolean invert) {
        if (invert) return assertLessThan(value, min, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue((%s >= %s), '%s')", value, min, message));
    }

    public static RequirementGenerator assertLessThanEqual(String value, String max, String message, boolean invert) {
        if (invert) return assertGreaterThan(value, max, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue((%s <= %s), '%s')", value, max, message));
    }

    public static RequirementGenerator assertGreaterThan(String value, String min, String message, boolean invert) {
        if (invert) return assertLessThanEqual(value, min, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue((%s > %s), '%s')", value, min, message));
    }

    public static RequirementGenerator assertLessThan(String value, String max, String message, boolean invert) {
        if (invert) return assertGreaterThanEqual(value, max, message, false);
        return new RequirementGenerator(String.format("validator.assertTrue((%s < %s), '%s')", value, max, message));
    }
}
