package holding;
import java.util.*;
public class MultiIterableClass extends IterableClass{
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }
                    @Override
                    public String next() {
                        return words[current--];
                    }
                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                //Arrays.asList(words)作为形参传入，作为shuffled的引用
                List<String> shffled = new ArrayList<String>(Arrays.asList(words));
                //如果直接作为引用，则会改变原数组
                //shffled = Arrays.asList(words);
                Collections.shuffle(shffled, new Random(47));
                return shffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic.reversed())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();
        //Collections.shuffle();并没有影响到原来的字符串数组
        for (String s : mic)
            System.out.print(s + " ");


    }
}
