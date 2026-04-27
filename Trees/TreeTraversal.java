import java.util.*;

class TreeTraversal {
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
        in(n.l);
        System.out.print(n.v + " ");
        in(n.r);
    }

    static void post(N n) {
        if (n == null)
            return;
        post(n.l);
        post(n.r);
        System.out.print(n.v + " ");
    }

    public static void main(String[] a) {
        N r = new N("root");
        r.l = new N("home");
        r.r = new N("var");
        r.l.l = new N("user");
        r.l.r = new N("docs");
        r.l.r.l = new N("config");
        r.r.r = new N("log");
        pre(r);
        System.out.println();
        in(r);
        System.out.println();
        post(r);
    }
}