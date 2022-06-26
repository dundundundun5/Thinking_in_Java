package exceptions;

public class Cleanup {
    public static void main(String[] args) {
        try {
            //必须用绝对路径？
            InputFile in = new InputFile("F:\\Thinking_in_Java\\src\\exceptions\\Cleanup.java");
            try {
                String s;
                int i = 1;
                while((s = in.getLine()) != null)
                    ;
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
