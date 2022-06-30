package genrerics;
import net.mindview.util.*;
class Amphibian {}
class Vehicle {}

public class TupleTest {
    static TwoTurple<String, Integer> f() {
        return new TwoTurple<>("hi", 47);
    }

    static ThreeTurple<Amphibian, String, Integer> g() {
        return new ThreeTurple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTurple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTurple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTurple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
