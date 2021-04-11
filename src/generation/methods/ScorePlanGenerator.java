package generation.methods;

import generation.PythonGenerator;

public class ScorePlanGenerator extends MethodGenerator {

    public ScorePlanGenerator() {
        super("scorePlan");
        addLine("scorer = Scorer()");
        newLine();
    }

    @Override
    protected void endMethod() {
        newLine();
        addLine("print(\"Final Score: {:.0f}%\".format(scorer.getScore()))");
        super.endMethod();
    }
}
