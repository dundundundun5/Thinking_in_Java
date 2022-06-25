package exceptions;

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            //return放在finally块里会静默所有抛出的异常
            return;
        }
    }
}
