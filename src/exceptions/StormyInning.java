package exceptions;

class BaseBallException extends Exception {}
class Foul extends BaseBallException {}
class Strike extends BaseBallException {}

abstract class Inning {
    public Inning() throws BaseBallException {}
    public void event() throws BaseBallException {
        //无需实际抛出任何异常，(只是作为限制)
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}
public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut, BaseBallException {}
    public StormyInning(String s) throws Foul, BaseBallException {}
    //错误void walk() throws PopFoul {}基类没抛你也不准跑
    //错误public void event() throws RainedOut {}基类抛啥你也要抛啥
    //基类抛啥你也要抛啥
    public void rainHard() throws RainedOut {}
    //基类抛了但你可以不抛
    public void event() {}
    //你也可以抛基类抛出异常的子类
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseBallException e) {
            System.out.println("Generic baseball exception");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseBallException e) {
            System.out.println("Generic baseball exception");
        }

    }
}
