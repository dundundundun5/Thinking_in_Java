package holding;
import java.util.*;
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> integerSet = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            integerSet.add(rand.nextInt(30));
        }
        System.out.println(integerSet);
    }
}
