package strings;
import java.util.regex.*;
public class StartEnd {
    public static String input =
            "As long as there is injustice, whenever a\n" +
            "Targathian baby cries out, wherever a distress\n" +
            "signal sounds among the starts ... We'll be there.\n" +
            "This fine ship, and this fine crew ...\n" +
            "Never give up! Never surrender!";
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        public Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display(String.format("find() '%s' start = %d end = %d", m.group(), m.start(), m.end()));
        if (m.lookingAt())
            d.display(String.format("lookingAt() start = %d end = %d", m.start(), m.end()));
        if (m.matches())
            d.display(String.format("matches() start = %d end = %d", m.start(), m.end()));
    }

    public static void main(String[] args) {
        for (String in : input.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[]{"\\w*ere\\w*", "\\w*ever", "T\\w+", "Never.*?!"})
                examine(in, regex);
        }
    }
}
