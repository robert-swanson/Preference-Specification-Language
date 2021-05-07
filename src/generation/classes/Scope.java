package generation.classes;

import generation.PythonGenerator;
import generation.methods.ScorePlanGenerator;
import generation.methods.ValidatePlanGenerator;

public class Scope {
    private String python;
    private boolean required;
    private boolean preferred;
    private String description;
    private boolean usedPrefer = false;
    private boolean usedRequire = false;

    enum Type { whenBlock, ifBlock }
    private Type type;

    private Scope(String python, String description, Type type) {
        this.python = python;
        this.description = description;
        this.type = type;
    }

    public void setUsedPrefer(){
        usedPrefer = true;
    }
    public void setUsedRequire(){
        usedPrefer = true;
    }

    public static Scope whenBlock(Condition condition, String description) {
        return new Scope(String.format("if evaluator.contextStack.subcontext(lambda: %s):", condition.getPython()), String.format("Entering Context: %s",description), Type.whenBlock);
    }

    public static Scope ifBlock(Condition condition, String description) {
        return new Scope(String.format("if %s:", condition.getPython()), String.format("Entering Condition: %s", description), Type.ifBlock);
    }
    public static Scope otherwiseIfBlock(Condition condition, String description) {
        return new Scope(String.format("elif %s:", condition.getPython()), String.format("Entering Condition: %s", description), Type.ifBlock);
    }
    public static Scope otherwiseBlock(String description) {
        return new Scope("else:", String.format("Entering Condition: %s", description), Type.ifBlock);
    }

    public void open() {
        this.required = true;
        ValidatePlanGenerator validatePlanGenerator = PythonGenerator.getValidatePlanGenerator();
        validatePlanGenerator.openScope(python);
        validatePlanGenerator.addLine(String.format("print('%s')", description));

        this.preferred = true;
        ScorePlanGenerator scorePlanGenerator = PythonGenerator.getScorePlanGenerator();
        scorePlanGenerator.openScope(python);
        scorePlanGenerator.addLine(String.format("print('%s')", description));
    }

    public void close() {
        if (this.required) {
            PythonGenerator.getValidatePlanGenerator().addLine("print('Closing Scope')");
            PythonGenerator.getValidatePlanGenerator().closeScope();
        }
        if (this.preferred) {
            PythonGenerator.getScorePlanGenerator().addLine("print('Closing Scope')");
            PythonGenerator.getScorePlanGenerator().closeScope();
        }
    }



}
