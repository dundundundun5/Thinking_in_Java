package exceptions;
import java.util.logging.*;
import java.io.*;
class LoggingException extends Exception {
    //创建一个String参数相关联的Logger对象
    private static Logger logger =
            Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        //重载的printStackTrace方法，接受一个java.io.PrintWriter,
        // trace作为StringWriter对象传给其构造器，就可以通过toString方法把字符串提取出来
        printStackTrace(new PrintWriter(trace));
        //直接调用与日志记录消息的级别相关联的方法
        logger.severe("操你妈" + trace.toString()  );
    }
}
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}
