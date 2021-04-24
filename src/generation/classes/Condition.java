package generation.classes;

public class Condition {
    private String python;

    public Condition(String python) {
        this.python = python;
    }

    public String getPython() {
        return this.python;
    }

    public Condition and(Condition right) {
        return new Condition(String.format("(%s and %s)", this.python, right.python));
    }
    public Condition or(Condition right) {
        return new Condition(String.format("(%s or %s)", this.python, right.python));
    }
    public Condition not() {
        return new Condition(String.format("(not %s)", this.python));
    }
}

