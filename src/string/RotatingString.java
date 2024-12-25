package string;

public class RotatingString {
public static void main(String[] args) {
	String str = "abcdef";
	int offset=3;
	String result =rotateString(str, offset);
	System.out.println("Result "+ result);

}

static public String rotateString(String input, int offset) {
    StringBuilder sb = new StringBuilder();
    int len = input.length();
    
    for (int i = 0; i < len; i++) {
        if (i < offset) {
            sb.append(input.charAt(i));
        }
        else {
        	System.out.println("offset : "+offset+" Index i : "+i +" "+input.charAt(i));
            sb.insert(i-offset, input.charAt(i));
        }
    }
    
    return sb.toString();
}
}
