package strings;

import java.io.*;


public class SimpleRead {
    public static BufferedReader input = new BufferedReader(
            new StringReader("Sir Robin of Camelot\n22 1.61803"));
    public static void main(String[] args) {
        try {
            System.out.println("What's your name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("How old are you ? What is your favorite double?");
            String numbers = input.readLine();
            System.out.println(numbers);
            String[] numArray = numbers.split(" ");
            int age = Integer.parseInt(numArray[0]);
            double favorite = Double.parseDouble(numArray[1]);
            System.out.printf("Hi %s.\nIn 5 years you will be %d.\n", name, age + 5);
            System.out.format("My favorite double is %f.", favorite / 2);
        } catch (IOException e) {
            //TODO: handle exception
            System.err.println("I/O Exception");
        }
    }
}
