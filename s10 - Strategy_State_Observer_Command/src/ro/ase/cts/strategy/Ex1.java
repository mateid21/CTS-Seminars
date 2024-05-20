package ro.ase.cts.strategy;

interface TextFormatter{
    String format(String text);
}

class UpperCaseFormatter implements TextFormatter{
    public String format(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter{
    public String format(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter{
    public String format(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}

class TextEditor{
    private TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void setFormatter(TextFormatter textFormatter){
        this.textFormatter = textFormatter;
    }

    public String formatText(String text){
        return textFormatter.format(text);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(new UpperCaseFormatter());

        String text = "Hello World!";
        System.out.println("Original text: " + text);
        System.out.println("Uppercase: " + textEditor.formatText(text));

        textEditor.setFormatter(new LowerCaseFormatter());
        System.out.println("Lowercase: " + textEditor.formatText(text));

        textEditor.setFormatter(new CamelCaseFormatter());
        System.out.println("Camelcase: " + textEditor.formatText(text));
    }
}
