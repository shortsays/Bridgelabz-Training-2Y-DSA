import java.util.*;

class BST {
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

    static boolean search(N r, int v) {
        if (r == null)
            return false;
        if (r.v == v)
            return true;
        return v < r.v ? search(r.l, v) : search(r.r, v);
    }

    static void in(N r) {
        if (r != null) {
            in(r.l);
            System.out.print(r.v + " ");
            in(r.r);
        }
    }

    public static void main(String[] a) {
        int[] x = { 50, 30, 70, 20, 40, 60, 80, 10, 25 };
        N r = null;
        for (int i : x)
            r = ins(r, i);
        in(r);
        System.out.println();
        System.out.println(search(r, 25));
    }
}