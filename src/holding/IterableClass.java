package holding;
import java.util.*;
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And this is how " +
            "we know the Earth to be banana-shaped.").split(" ");

    /**
     * @apiNote 任何继承Iterable<T>接口的类只要重写iterator()方法即可用于foreach
     * @return 返回实现了Iterator<String>的匿名内部类实例对象
     */
    public Iterator<String> iterator() {
        //TODO 复习自定义类如何支持foreach
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }
}
