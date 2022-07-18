package arrays;

public class ArrayOfGenericType<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //array = new T[size];
        array = (T[]) new Object[size];
        //擦除使得array在此处还是个Object
        System.out.println(array.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        ArrayOfGenericType<Integer> arrayOfGenericType = new ArrayOfGenericType<>(2);
    }
}
