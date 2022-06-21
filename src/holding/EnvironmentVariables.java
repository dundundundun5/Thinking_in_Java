package holding;
import java.util.*;
public class EnvironmentVariables {
    /**
     * System.getenv()返回一个Map<br>
     * entrySet()产生一个由Map.Entry元素构成的Set<br>
     * 这个Set也是一个Iterable<T>
     * @param args
     */
    public static void main(String[] args) {

        for (Map.Entry entry: System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
