package exceptions;

public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            //展示调用方法的栈轨迹，从栈底到栈顶是依次调用的方法
            //所以输出的时候是相反顺序（后进先出）
            for (StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
        }
    }
    static void g() { f(); }
    static void h() { g(); }

    public static void main(String[] args) {
        f();
        System.out.println("----------------------------------");
        g();
        System.out.println("----------------------------------");
        h();
    }
}
