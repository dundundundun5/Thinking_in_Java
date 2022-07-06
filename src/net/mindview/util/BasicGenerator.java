package net.mindview.util;

/**
 * 用于生成某个类的对象
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type) { this.type = type; }
    //工厂对象的接口，用于生成某个商品对象
    public T next() {
        try {
            //创建新的商品对象
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //返回一个工厂对象
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
