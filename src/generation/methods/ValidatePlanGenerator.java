package generation.methods;

import generation.PythonGenerator;

public class ValidatePlanGenerator extends MethodGenerator {

    public ValidatePlanGenerator() {
        super("validatePlan");
        addLine("validator = Validator()");
        newLine();
    }

    @Override
    protected void endMethod() {
        newLine();
        addIf("validator.isValid");
        addLine("print(\"Valid Plan\")");
        addElse();
        addLine("print(\"Invalid Plan\")");
        closeScope();
        super.endMethod();
    }
}
