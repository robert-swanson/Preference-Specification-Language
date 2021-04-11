package generation.classes;

import generation.PythonGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferenceGenerator {
    private static final boolean diagnostics = true;
    private final String pythonScoring;
    private final String value;
    private final Object[] scoreArgs;

    private PreferenceGenerator(String pythonScoring, String value, Object[] scoreArgs) {
        this.pythonScoring = pythonScoring;
        this.value = value;
        this.scoreArgs = scoreArgs;
    }

    public void add(double weight) {
        ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(scoreArgs));
        list.add(0, Double.toString(weight));
        list.add(0, value);
        String finalPython = String.format(pythonScoring, list.toArray());
        PythonGenerator.getScorePlanGenerator().addLine(finalPython);
    }

    public static PreferenceGenerator scoreBoolean(String value, String preferenceName) {
        return new PreferenceGenerator("scorer.scoreBoolean(%s, %s, '%s', diagnostics=%s)", value, new Object[]{preferenceName, diagnostics ? "True" : "False"});
    }

    public static PreferenceGenerator scoreSigmoid(String value, String preferenceName, double worstBound, double bestBound) {
        return new PreferenceGenerator("scorer.scoreSigmoid(%s, %s, '%s', worstBound=%f, bestBound=%f, diagnostics=%b)", value, new Object[]{preferenceName, worstBound, bestBound, diagnostics ? "True" : "False"});
    }


}
