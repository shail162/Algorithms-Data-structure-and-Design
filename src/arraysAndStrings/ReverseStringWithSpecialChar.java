package arraysAndStrings;

public class ReverseStringWithSpecialChar {

    public static void main(String args[]) {

            String str = "a,b$c";
            System.out.println(reverseString(str.toCharArray()));
    }


    /**
     * O(n) complexity
     * @param str
     * @return
     */
    public static String reverseString(char str[]){
            int l = 0;
            int r = str.length - 1;

            while (l < r){
                int lvalue = str[l];
                int rvalue = str[r];

                if (Character.isAlphabetic(lvalue) && Character.isAlphabetic(rvalue)){
                    //swap
                    char t = str[l];
                    str[l] = str[r];
                    str[r] = t;
                    l++;
                    r--;
                } else if(!Character.isAlphabetic(lvalue)){
                    l++;
                } else {
                    r--;
                }
            }

            return String.valueOf(str);
    }
}
