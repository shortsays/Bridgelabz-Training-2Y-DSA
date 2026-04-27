import java.util.*;

class BSTDelete {
    static class N {
        int v;
        N l, r;

        N(int v) {
            this.v = v;
        }
    }

    static N ins(N r, int v) {
        if (r == null)
            return new N(v);
        if (v < r.v)
            r.l = ins(r.l, v);
        else
            r.r = ins(r.r, v);
        return r;
    }

    static N min(N r) {
        while (r.l != null)
            r = r.l;
        return r;
    }

    static N del(N r, int v) {
        if (r == null)
            return null;
        if (v < r.v)
            r.l = del(r.l, v);
        else if (v > r.v)
            r.r = del(r.r, v);
        else {
            if (r.l == null)
                return r.r;
            if (r.r == null)
                return r.l;
            N t = min(r.r);
            r.v = t.v;
            r.r = del(r.r, t.v);
        }
        return r;
    }

    static void in(N r) {
        if (r != null) {
            in(r.l);
            System.out.print(r.v + " ");
            in(r.r);
        }
    }

    public static void main(String[] a) {
        int[] x = { 15, 10, 20, 8, 12, 17, 25 };
        N r = null;
        for (int i : x)
            r = ins(r, i);
        r = del(r, 10);
        r = ins(r, 14);
        r = ins(r, 9);
        in(r);
    }
}