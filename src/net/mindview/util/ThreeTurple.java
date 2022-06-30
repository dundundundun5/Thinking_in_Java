package net.mindview.util;

public class ThreeTurple<A, B, C> extends TwoTurple<A, B> {
    public final C third;
    public ThreeTurple(A a, B b, C c) {
        super(a, b);
        third = c;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
