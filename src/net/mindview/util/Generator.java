package net.mindview.util;

public interface Generator<T> {
    /**
     *
     * @return 返回工厂里的商品对象
     */
    T next();
}
