package generation;

import java.io.FileWriter;
import java.io.IOException;

public class PythonGenerator {
    static final int SPACESPERINDENT = 2;
    private static PythonGenerator instance;
    private final ValidatePlanGenerator validatePlanGenerator;
    private final ScorePlanGenerator scorePlanGenerator;

    private PythonGenerator() {
        instance = this;
        validatePlanGenerator = new ValidatePlanGenerator();
        scorePlanGenerator = new ScorePlanGenerator();
    }

    public static ValidatePlanGenerator getValidatePlanGenerator() {
        if (instance == null) {
            new PythonGenerator();
        }
        return instance.validatePlanGenerator;
    }

    public static ScorePlanGenerator getScorePlanGenerator() {
        if (instance == null) {
            new PythonGenerator();
        }
        return instance.scorePlanGenerator;
    }

    public static void generate(FileWriter writer) throws IOException {
        writer.write("from Helpers.PlanEvaluator import PlanEvaluator\n");
        writer.write("from Helpers.Validator import Validator\n");
        writer.write("from Helpers.Validator import Validator\n");
        writer.write("from Helpers.Scorer import Scorer\n");
        writer.write("import Helpers.Utilities as ut\n");

        writer.write(getValidatePlanGenerator().getPython());
        writer.write(getScorePlanGenerator().getPython());

        writer.write("evaluator = PlanEvaluator()\n");
        writer.write("validatePlan()\n");
        writer.write("scorePlan()\n");
    }
    public static String getIndent(int currentIndent){
        return " ".repeat(Math.max(0, currentIndent * PythonGenerator.SPACESPERINDENT));
    }
}
