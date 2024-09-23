import java.util.ArrayList;

public class Sorter {
    private static int median3sort(int[] t, int v, int h) {
        int m = (v + h) / 2;
        if (t[v] > t[m]) bytt(t, v, m);
        if (t[m] > t[h]) {
            bytt(t, m, h);
            if (t[v] > t[m]) bytt(t, v, m);
        }
        return m;
    }

    public void quicksortModified(int[] t, int v, int h, int size) {
        if (h - v > size) {
            int delepos = splitt(t, v, h);
            quicksortModified(t, v, delepos - 1, size);
            quicksortModified(t, delepos + 1, h, size);
        } else innsettingssort(t,v, h);
    }

    public void quicksort(int[] t, int v, int h) {
        if (h - v > 2) {
            int delepos = splitt(t, v, h);
            quicksort(t, v, delepos - 1);
            quicksort(t, delepos + 1, h);
        } else median3sort(t, v, h);
    }

    private static int splitt(int[] t, int v, int h) {
        int iv, ih;
        int m = median3sort(t, v, h);
        int dv = t[m];
        bytt(t, m, h - 1);
        for (iv = v, ih = h - 1; ; ) {
            while (t[++iv] < dv) ;
            while (t[--ih] > dv) ;
            if (iv >= ih) break;
            bytt(t, iv, ih);
        }
        bytt(t, iv, h - 1);
        return iv;
    }

    public static void bytt(int[] t, int v, int h) {
        int temp = t[v];
        t[v] = t[h];
        t[h] = temp;
    }


    public static void innsettingssort(int[] t, int v, int h) {
        for (int j = v; j < h + 1; ++j) {
            int bytt = t[j];
            int i = j - 1;
            while (i >= v && t[i] > bytt) {
                t[i + 1] = t[i];
                --i;
            }
            t[i + 1] = bytt;
        }
    }
}
