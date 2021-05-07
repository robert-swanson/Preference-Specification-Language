package generation.classes;

public class Condition {
    private String python;
    private String description;

    public Condition(String python, String description) {
        this.python = python;
        this.description = description;
    }

    public String getPython() {
        return this.python;
    }

    public String getDescription() {
        return this.description;
    }

    public Condition and(Condition left) {
        return new Condition(String.format("(%s and %s)", left.python, this.python), String.format("(%s and %s)", left.description, this.description));
    }
    public Condition or(Condition left) {
        return new Condition(String.format("(%s or %s)", left.python, this.python), String.format("(%s or %s)", left.description, this.description));
    }
    public Condition not() {
        return new Condition(String.format("(not %s)", this.python), String.format("not %s", this.description));
    }
}

