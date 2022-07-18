package generics;

class GenericBase<T> {
    private T element;
    public void set(T arg) { arg = element; }
    public T get() { return element; }
}
class Derived<T> extends GenericBase<T> {}

class Derived2 extends GenericBase {} //no warning

//不能是?，泛型参数需要边界
//class Derived3 extends GenericBase<?> {}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
