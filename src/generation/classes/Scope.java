package generation.classes;

import generation.PythonGenerator;
import generation.conditions.Condition;
import generation.methods.ScorePlanGenerator;
import generation.methods.ValidatePlanGenerator;

public class Scope {
    private String python;
    private boolean required;
    private boolean preferred;
    private String description;

    enum Type { whenBlock, ifBlock }
    private Type type;

    private Scope(String python, String description, Type type) {
        this.python = python;
        this.description = description;
        this.type = type;
    }

    public static Scope whenBlock(Condition condition, String description) {
        return new Scope(String.format("if evaluator.contextStack.subcontext(lambda: %s):", condition.getPython()), String.format("Entering Context: %s",description), Type.whenBlock);
    }

    public static Scope ifBlock(Condition condition, String description) {
        return new Scope(String.format("if %s:", condition.getPython()), String.format("Entering Condition: %s", description), Type.ifBlock);
    }

    public void require() {
        this.required = true;
        this.preferred = false;
        ValidatePlanGenerator validatePlanGenerator = PythonGenerator.getValidatePlanGenerator();
        validatePlanGenerator.openScope(python);
        validatePlanGenerator.addLine(String.format("print('%s')", description));
    }

    public void prefer() {
        this.preferred = true;
        this.required = false;
        ScorePlanGenerator scorePlanGenerator = PythonGenerator.getScorePlanGenerator();
        scorePlanGenerator.openScope(python);
        scorePlanGenerator.addLine(String.format("print('%s')", description));
    }

    public void close() {
        if (this.required) {
            PythonGenerator.getValidatePlanGenerator().closeScope();
        }
        if (this.preferred) {
            PythonGenerator.getScorePlanGenerator().addLine(String.format("print('Closing Scope')"));
            PythonGenerator.getScorePlanGenerator().closeScope();
        }
    }



}
