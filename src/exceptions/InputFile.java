package exceptions;
import java.io.*;
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            //FileReader用于建立BufferedReader对象
            in = new BufferedReader(new FileReader(fname));
            //other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            //Wasn't open, so don't close it从未打开，又何来关闭
            throw e;
        } catch (Exception e) {
            //All other exception must close it
            try {
                //关闭也可能异常
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            //don't close it here
        }
    }
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e2) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }
    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
