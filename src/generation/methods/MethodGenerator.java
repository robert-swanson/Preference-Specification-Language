package generation.methods;

import generation.PythonGenerator;

public abstract class MethodGenerator {
    private final StringBuilder pythonSource;
    private int currentIndent;
    private boolean writeable = true;

    static final int SPACESPERINDENT = 2;

    protected MethodGenerator(String methodName) {
        pythonSource = new StringBuilder();
        addLine(String.format("def %s():", methodName));
        currentIndent = 1;
    }

    private String getIndent(){
        return " ".repeat(Math.max(0, currentIndent * SPACESPERINDENT));
    }

    public void addLine(String line) {
        assert writeable: "Cannot edit method after call to generate()";

        pythonSource.append(getIndent());
        pythonSource.append(line);
        pythonSource.append("\n");
    }

    public void newLine() {
        addLine("");
    }

    public void closeScope() {
        assert writeable: "Cannot edit method after call to generate()";
        assert currentIndent > 1 : "There are no scopes to close";

        currentIndent--;
    }

    public void openScope(String line) {
        assert writeable: "Cannot edit preferences after call to generate()";

        addLine(line);
        currentIndent++;
    }


    public void addIf(String condition) {
        openScope(String.format("if %s:", condition));
    }
    public void addElse() {
        closeScope();
        openScope("else:");
    }

    protected void endMethod() {
        assert currentIndent == 1: "Indent > 1, make sure to close all scopes";
        currentIndent = 0;
        newLine();
        writeable = false;
    }

    public String generate() {
        if (writeable) {
            endMethod();
        }
        return pythonSource.toString();
    }

}
