package exceptions;

public class WithFinally {
    static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            //code that can throw exceptions
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffExcption2");
        } finally {
            //只需要这一块处理一次就行
            sw.off();
        }
    }
}
