package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigram {
    public static void main(String[] args) {
        String first = "a";
        String second = "good";
        String str = "alice is a good girl she is a good student";
        String[] result = findOcurrences(str, first, second);
        System.out.println(" Result" + Arrays.toString(result));
    }

    public static String[] findOcurrences(String str, String first, String second) {
        String[] st = str.split("\\s+");

        List<String> l = new ArrayList<String>();
        int i = 0, n = st.length;

        while (i < n) {
            if (st[i].equals(first))
                if (i + 1 < n - 1 && st[i + 1].equals(second))
                    l.add(st[i + 2]);
            i++;
        }
        String[] result = l.toArray(new String[0]);
        return result;
       // return l.toArray(new String[0]);
    }

}
