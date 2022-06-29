package strings;

import java.util.Scanner;

public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name?");
        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you ? What is your favorite double?");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.println(age);
        System.out.println(favorite);
        System.out.printf("Hi %s.\nIn 5 years you will be %d.\n", name, age + 5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}
