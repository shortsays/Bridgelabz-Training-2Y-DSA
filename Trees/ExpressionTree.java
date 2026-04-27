import java.util.*;

class ExpressionTree {
    static class N {
        String v;
        N l, r;

        N(String v) {
            this.v = v;
        }
    }

    static void pre(N n) {
        if (n == null)
            return;
        System.out.print(n.v + " ");
        pre(n.l);
        pre(n.r);
    }

    static void in(N n) {
        if (n == null)
            return;
        if (n.l != null)
            System.out.print("(");
        in(n.l);
        System.out.print(n.v + " ");
        in(n.r);
        if (n.r != null)
            System.out.print(")");
    }

    static void post(N n) {
        if (n == null)
            return;
        post(n.l);
        post(n.r);
        System.out.print(n.v + " ");
    }

    public static void main(String[] a) {
        N r = new N("*");
        r.l = new N("+");
        r.r = new N("-");
        r.l.l = new N("3");
        r.l.r = new N("5");
        r.r.l = new N("8");
        r.r.r = new N("2");
        pre(r);
        System.out.println();
        in(r);
        System.out.println();
        post(r);
    }
}