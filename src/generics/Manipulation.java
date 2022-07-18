package generics;

public class Manipulation<T> {
    private T obj;
    public Manipulation(T x) { obj = x; }
    //无法编译成功
    // public void manipulate() { obj.f(); }
}
