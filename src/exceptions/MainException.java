package exceptions;
import java.io.*;
public class MainException {
    //Pass all exceptions to the console:
    public static void main(String[] args) throws Exception{
        //Open the file:
        FileOutputStream file = new FileOutputStream("MainException.java");
        //Use the file...
        //Close the file...
        file.close();
    }
}
