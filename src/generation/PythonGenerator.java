package generation;

import generation.methods.ScorePlanGenerator;
import generation.methods.ValidatePlanGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PythonGenerator {
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

    public static void generate(String filePath) throws IOException {
        File output = new File(filePath);
        output.createNewFile();
        FileWriter writer = new FileWriter(output);

        writer.write("from Helpers.PlanEvaluator import PlanEvaluator\n");
        writer.write("from Helpers.Validator import Validator\n");
        writer.write("from Helpers.Scorer import Scorer\n");
        writer.write("import Helpers.Utilities as ut\n");
        writer.write("\n");

        writer.write(getValidatePlanGenerator().generate());
        writer.write(getScorePlanGenerator().generate());

        writer.write("evaluator = PlanEvaluator()\n");
        writer.write("validatePlan()\n");
        writer.write("scorePlan()\n");

        writer.flush();
        writer.close();
    }
}
