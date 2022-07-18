package generics;

public class Manipulation2<T extends HasF> {
    private T obj;
    public Manipulation2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}
