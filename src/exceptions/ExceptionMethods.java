package exceptions;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            //信息
            System.out.println("get message():" + e.getMessage());
            //本地语言表示的信息
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            //限定包名的异常类名
            System.out.println("toString():" + e);
            //在PrintStream中打出异常发生的栈轨迹
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
