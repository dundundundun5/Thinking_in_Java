package exceptions;

public class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args) {
        try {
            sw.on();
            //code that can throw exceptions
            f();
            //每一个地方都要处理
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            //每一个地方都要处理
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffExcption2");
            //每一个地方都要处理
            sw.off();
        }
    }
}
