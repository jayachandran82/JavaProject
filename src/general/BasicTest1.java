package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicTest1 {
    public static void main(String[] args) {

        String str = "alice is a good girl she is a good student";
        String st[] = str.split("\\s");
        System.out.println(Arrays.toString(st));
        List<String> l = new ArrayList<>();
        l.add("girl");
        l.add("Jay");

        System.out.println(l);
        System.out.println(st);

/*        boolean dp[][]=new boolean[1][1];
        System.out.println(isMatch());*/
    }
    public static boolean isMatch(){
        boolean dp[][]=new boolean[2][2];
        dp[1][1]=true;
        return dp[1][1];
        //dp[2][2]=dp[1][1];
        //return dp[2][2];
    }
}
