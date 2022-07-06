package generics;
import java.util.*;
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    //只是个计数器而已
    private int n;
    public IterableFibonacci(int count) { n = count; }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                //调用当前对象继承父类的next()方法，也是Generator接口的规范方法,这里还是从1开始
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        //i获取的是IterableFibonacci.this.next();
        for (int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
