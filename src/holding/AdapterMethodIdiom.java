package holding;
import java.util.*;
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) { super(c); }

    /**
     * 适配器设计模式，需要反复复习<br>
     * @apiNote 思路剖析：由于foreach里需要遍历的容器都是实现了Iterable<T>接口的类的对象<br>
     * 故在继承了原有的容器类后，添加一个reversed()方法返回一个Iterable<T>类的对象，这个类中重写了一个iterator()方法<br>
     * 这个方法返回一个特定匿名内部类的实例对象，从而实现自定义的元素迭代访问方式
     * @return iterable<T>对象，从而符合foreach中容器的要求(必须是实现了Iterable<T>接口的类的对象)
     */
    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral =
                new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        //Grabs the ordinary iterator via iterator()
        for (String s : ral)
            System.out.print(s + " ");
        System.out.println();
        for (String s : ral.reversed())
            System.out.print(s + " ");
    }
}
