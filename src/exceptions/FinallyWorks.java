package exceptions;

class ThreeException extends Exception {}
public class FinallyWorks {
    static int count = 0;

    /**
     * 无论是否抛出ThreeException()总能执行finally子句
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            try {
                //Post-increment is zero first time:
                if (count++ == 0)
                    throw new ThreeException();
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}
