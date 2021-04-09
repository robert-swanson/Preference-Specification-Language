package generation;

public class ValidatePlanGenerator {
    private final StringBuilder validatePlanFunction;
    private int currentIndent;

    public ValidatePlanGenerator() {
        validatePlanFunction = new StringBuilder();
        addLine("def validatePlan():");
        currentIndent = 1;
        addLine("validator = Validator()");
    }

    public void addLine(String line) {
        validatePlanFunction.append(PythonGenerator.getIndent(currentIndent));
        validatePlanFunction.append(line);
        validatePlanFunction.append("\n");
    }

    public void closeScope() {
        assert currentIndent > 0;
        validatePlanFunction.append("\n");
        currentIndent--;
    }

    public void openScope() {
        currentIndent++;
    }

    public String getPython() {

        return validatePlanFunction.toString();
    }
}
