package generation;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferenceGenerator {
    private static final boolean diagnosis = true;
    private final String pythonScoring;
    private final String value;
    private final String[] scoreArgs;

    private PreferenceGenerator(String pythonScoring, String value, String[] scoreArgs) {
        this.pythonScoring = pythonScoring;
        this.value = value;
        this.scoreArgs = scoreArgs;
    }

    public void add(double weight) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(scoreArgs));
        list.add(0, Double.toString(weight));
        list.add(0, value);
        String finalPython = String.format(pythonScoring, list.toArray());
        PythonGenerator.getValidatePlanGenerator().addLine(finalPython);
    }

    public static PreferenceGenerator scoreBoolean(String value, String preferenceName) {
        return new PreferenceGenerator("scorer.scoreBoolean(%s, %s, %s)", value, new String[]{preferenceName});
    }

    public static PreferenceGenerator scoreSigmoid(String value, String preferenceName, double worstBound, double bestBound) {
        return new PreferenceGenerator("scorer.scoreSigmoid(%s, %s, %s, worstBound=%s, bestBound=%f, diagnosis=%s)", value, new String[]{preferenceName, Double.toString(worstBound), Double.toString(bestBound)});
    }


}
