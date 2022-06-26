package exceptions;
import java.io.*;

class WrapCheckedException {
    /**
     * 可以产生不同类型的异常
     * @param type
     */
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException("Where am I?");
            }
        } catch (Exception e) {
            //Adapt to unchecked包装进RuntimeException
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {}

public class TurningOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        //You can call throwRuntimeException() without a try
        //block, and let RuntimeExceptions leave the method:
        //没有抛出被检查的异常所以可在try外面调用
        wce.throwRuntimeException(3);
        //Or you can choose to catch exceptions:
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
